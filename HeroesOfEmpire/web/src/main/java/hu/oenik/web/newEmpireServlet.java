/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.web;

import empire.Empire;
import empire.EnvironmentTypes;
import hu.oenik.data.SpeciesRepository;
import hu.oenik.data.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viki
 */
@WebServlet(name = "newEmpireServlet", urlPatterns = {"/newEmpire"})
public class newEmpireServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


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
        User sess = ((User)request.getSession().getAttribute("user"));
        String name = request.getParameter("name");
        String description = request.getParameter("desc");
        String envValue = request.getParameter("envlist");
        EnvironmentTypes envType = EnvironmentTypes.valueOf(request.getParameter("envlist"));
        Empire emp = new Empire(name,description,envType);
        sess.getEmpires().add(emp);
        
            request.setAttribute("heroes", sess.getHeroes());
            request.setAttribute("empires", sess.getEmpires());
            request.setAttribute("species", SpeciesRepository.instance.getSpecies());
            request.setAttribute("envtypes", Arrays.asList(EnvironmentTypes.values()));
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
