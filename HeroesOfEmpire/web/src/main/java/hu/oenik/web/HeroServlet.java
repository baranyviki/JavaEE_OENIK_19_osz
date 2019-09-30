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
import hu.oenik.data.UserRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viki
 */
@WebServlet(name = "HeroServlet", urlPatterns = {"/newHero"})
public class HeroServlet extends HttpServlet {

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

        Hero h = new Hero(request.getParameter("name"), request.getParameter("desc"));
        for (Species s : SpeciesRepository.instance.getSpecies()) {
            Hybrid newHybrid = new Hybrid(s, Byte.parseByte(request.getParameter(s.getName())));
            h.getHybrids().add(newHybrid);
            //response.getWriter().print(s.getName() + " - " + request.getParameter(s.getName()));
        }

        User sess = ((User) request.getSession().getAttribute("user"));
        sess.getHeroes().add(h);
        
            request.setAttribute("heroes",sess.getHeroes() );
            request.setAttribute("empires",sess.getEmpires() );
            request.setAttribute("species", SpeciesRepository.instance.getSpecies());
            
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
