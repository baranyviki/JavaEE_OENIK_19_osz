/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.web;

import hu.oenik.data.EnvironmentTypes;
import hu.oenik.data.Hero;
import repos.HeroRepository;
import hu.oenik.data.Hybrid;
import hu.oenik.data.Species;
import repos.SpeciesRepository;
import hu.oenik.data.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repos.UserRepository;

/**
 *
 * @author Viki
 */
@WebServlet(name = "HeroServlet", urlPatterns = {"/newHero"})
public class HeroServlet extends HttpServlet {

   //@Inject
    //UserRepository users;

    @Inject
    HeroRepository heroesRepository;

    @Inject
    SpeciesRepository speciesRepository;
    // UserRepository users = new UserRepository();
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

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

        
        User sess = ((User) request.getSession().getAttribute("user"));
        Hero h = new Hero(request.getParameter("name"), request.getParameter("desc"),sess);
        for (Species s : speciesRepository.getSpecies()) {

            try {
                Byte b = Byte.parseByte(request.getParameter(s.getName()));
                Hybrid newHybrid = new Hybrid(s, b);
                h.getHybrids().add(newHybrid);

            } catch (NumberFormatException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            //response.getWriter().print(s.getName() + " - " + request.getParameter(s.getName()));
        }

        sess.getHeroes().add(h);
        heroesRepository.add(h);
        request.setAttribute("heroes", sess.getHeroes());
        request.setAttribute("empires", sess.getEmpires());
        request.setAttribute("species", speciesRepository.getSpecies());

        List<EnvironmentTypes> envtypes = new ArrayList<>(Arrays.asList(EnvironmentTypes.values()));
        request.setAttribute("envtypes",envtypes);
                  
        getServletContext().getRequestDispatcher("/userHome.jsp").include(request, response);
        
    }
}
