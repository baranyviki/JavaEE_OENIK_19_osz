/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.web;

import empire.EnvironmentTypes;
import hu.oenik.data.Hero;
import hu.oenik.data.Hybrid;
import hu.oenik.data.LoginException;
import hu.oenik.data.SpeciesRepository;
import hu.oenik.data.User;
import hu.oenik.data.UserRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
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

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

  @Inject
    UserRepository users;

  @Inject 
  SpeciesRepository species;
  
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
        String password = request.getParameter("pass");
        String username = request.getParameter("name");

        try {
            //User tmpU = new User(name, password, false);
            User loggedIn = users.login(username, password);
            loggedIn.getHeroes().add(new Hero("face", "scary", new ArrayList<Hybrid>()));
            request.getSession().setAttribute("user", loggedIn);
            request.setAttribute("heroes", loggedIn.getHeroes());
            request.setAttribute("empires", loggedIn.getEmpires());
            request.setAttribute("species", species.getSpecies());
            List<String> s = EnvironmentTypes.getAllTypes();
            request.setAttribute("envtypes",s);
            getServletContext().getRequestDispatcher("/UserHome.jsp").include(request, response);

            //  getServletContext().getRequestDispatcher("/hero.jsp").include(request, response);
        } catch (LoginException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.getWriter().print("login error");

//response.sendRedirect("/home");
        }
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
