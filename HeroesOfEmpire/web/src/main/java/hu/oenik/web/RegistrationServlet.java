/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.web;

import exceptions.RegistrationException;
import hu.oenik.data.User;
import repos.UserRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Viki
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/reg"})
public class RegistrationServlet extends HttpServlet {
    
private static final Logger logger = LoggerFactory.getLogger(RegistrationServlet.class);
    
    
   @Inject
    UserService userService;
    
    
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
        String username = request.getParameter("username");
        //String fullname = request.getParameter("name");
        //User tmpU = new User(name, password, false);

         try {
             userService.registration(username, password);
         } catch (RegistrationException ex) {
             //Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
             logger.error(ex.getMessage());
             response.getWriter().print("no success");
         }         
         response.sendRedirect("/web");
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
