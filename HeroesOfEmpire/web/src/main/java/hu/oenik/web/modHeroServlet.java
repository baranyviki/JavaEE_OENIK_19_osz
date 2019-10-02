/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.web;

import hu.oenik.data.Hero;
import hu.oenik.data.Hybrid;
import hu.oenik.data.Species;
import hu.oenik.data.SpeciesRepository;
import hu.oenik.data.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viki
 */
@WebServlet(name = "modHeroServlet", urlPatterns = {"/modHero"})
public class modHeroServlet extends HttpServlet {

    @Inject
    SpeciesRepository species;
    
//    @Inject
//    UserRepository users;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // UserRepository users = new UserRepository();
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User sess = ((User) request.getSession().getAttribute("user"));

        String heroname = request.getParameter("heroname");
        Hero selectedHero = new Hero();
        for (Hero h : sess.getHeroes()) {
            if (h.getName().equals(heroname)) {
                selectedHero = h;
            }
            //TODO: error handling
        }
        request.setAttribute("selectedHero", selectedHero);

        List<Hybrid> selectionHybrids = new ArrayList<>();
        for (Species s : species.getSpecies()) {
            selectionHybrids.add(new Hybrid(s, (byte) 0));
        }

        for (Hybrid selection : selectionHybrids) {
            for (Hybrid hero : selectedHero.getHybrids()) {
                if (selection.getSpecies().getName().equals(hero.getSpecies().getName())) {
                    selection.setPercent(hero.getPercent());
                }
            }
        }
        request.setAttribute("hybrids", selectionHybrids);
        getServletContext().getRequestDispatcher("/hero.jsp").include(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String heroname = request.getParameter("heroname");
        String desc = request.getParameter("desc");
        User sessUser = ((User) request.getSession().getAttribute("user"));
        List<Hero> hos = sessUser.getHeroes();
        int moddedHeroIdx = 0;
        int i = 0;
        while (i < hos.size() && !hos.get(i).getName().equals(heroname)) {
            i++;
        }
        if (i < hos.size()) {
            moddedHeroIdx = i;
        } else {
            throw new ServletException("unlisted hero name in post request parameter of mod hero servlet");
        }
        sessUser.getHeroes().get(moddedHeroIdx).setDescription(desc);

        List<Hybrid> heroHybrids = new ArrayList<>();
        for (Species s : species.getSpecies()) {
            try {
                Byte percent = Byte.parseByte(request.getParameter(s.getName()));
                if (percent > 0) {
                    heroHybrids.add(new Hybrid(s, percent));
                }

            } catch (NumberFormatException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        sessUser.getHeroes().get(moddedHeroIdx).setHybrids(heroHybrids);
        request.setAttribute("heroes",sessUser.getHeroes() );
        request.setAttribute("empires",sessUser.getEmpires() );
        request.setAttribute("species",species.getSpecies());
            
        getServletContext().getRequestDispatcher("/UserHome.jsp").include(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
