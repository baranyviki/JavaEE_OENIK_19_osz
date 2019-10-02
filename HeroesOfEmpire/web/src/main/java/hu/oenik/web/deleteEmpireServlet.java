/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.web;

import empire.Empire;
import hu.oenik.data.SpeciesRepository;
import hu.oenik.data.User;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viki
 */
public class deleteEmpireServlet extends HttpServlet {

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
           String empireName = request.getParameter("empirename");
        User sess = ((User) request.getSession().getAttribute("user"));
        List<Empire> emp = sess.getEmpires();
        int idx = 0;
        int selected = 0;
        while (idx < emp.size() && !emp.get(idx).getName().equals(empireName)) {
            idx++;
        }
        if (idx < emp.size()) {
            selected = idx;
        } else {
            throw new ServletException("user dont have empire with given name");
        }

        sess.getEmpires().remove(selected);
        request.setAttribute("heroes", sess.getHeroes());
            request.setAttribute("empires", sess.getEmpires());
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
