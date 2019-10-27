/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.web;

import hu.oenik.data.Hero;
import repos.SpeciesRepository;
import hu.oenik.data.User;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repos.HeroRepository;
import repos.UserRepository;

/**
 *
 * @author Viki
 */
@WebServlet(name = "deleteHeroServlet", urlPatterns = {"/deleteHero"})
public class deleteHeroServlet extends HttpServlet {
   
    @Inject
    SpeciesRepository speciesRepository;

    @Inject
    HeroRepository heroRepository;
    
    @Inject
    UserRepository userRepository;
    
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

        Long heroId =Long.parseLong( request.getParameter("heroid"));
        User sessUser = ((User) request.getSession().getAttribute("user"));
        try {
            sessUser.removeHero(heroId);
        } catch (Exception ex) {
            Logger.getLogger(deleteHeroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        heroRepository.remove(heroId);
        
        request.setAttribute("heroes", sessUser.getHeroes());
        request.setAttribute("empires", sessUser.getEmpires());
        request.setAttribute("species", speciesRepository.getSpecies());
        getServletContext().getRequestDispatcher("/userHome.jsp").include(request, response);
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
