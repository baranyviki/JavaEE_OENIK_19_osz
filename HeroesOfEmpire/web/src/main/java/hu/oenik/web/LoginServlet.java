/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oenik.web;

import hu.oenik.data.EnvironmentTypes;
import exceptions.LoginException;
import hu.oenik.data.Building;
import hu.oenik.data.Empire;
import hu.oenik.data.NaturalAsset;
import repos.SpeciesRepository;
import hu.oenik.data.User;
import java.io.IOException;
import java.util.List;
//import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repos.BuildingRepository;
import repos.NaturalAssetRepository;
import services.UserService;
import repos.EmpireRepository;

/**
 *
 * @author Viki
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Inject
    UserService userService;

    @Inject
    SpeciesRepository speciesRepository;

//    @Inject
//    EmpireRepository empRe;
//
//    @Inject
//    NaturalAssetRepository natRe;
//
//    @Inject
//    BuildingRepository bldRe;

    /*
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
            User loggedIn = userService.login(username, password);
            //loggedIn.getHeroes().add(new Hero("face", "scary", new ArrayList<Hybrid>()));
            request.getSession().setAttribute("user", loggedIn);
            request.setAttribute("heroes", loggedIn.getHeroes());
            request.setAttribute("empires", loggedIn.getEmpires());
            request.setAttribute("species", speciesRepository.getSpecies());

            List<String> s = EnvironmentTypes.getAllTypes();
            request.setAttribute("envtypes", s);
            getServletContext().getRequestDispatcher("/userHome.jsp").include(request, response);

            //testing 
//            List<Building> bldlist = bldRe.getOrderedBuildings();
//            Building bld = bldRe.getBuildingByName("Barrack");
//            Building bild = bldRe.getBuildingByID(251L);
//                    
//            List<NaturalAsset> nts = natRe.getOrderedNaturalAssets();
//            NaturalAsset nt = natRe.getNaturalAssetByName("Gold");
//            NaturalAsset nas = natRe.getNaturalAssetByID(101L);
//            
            //
            // List<Empire> emp = empRe.searchEmpires(loggedIn.getId(),null, "fire", null, null);
            
            
        } catch (LoginException ex) {
            // Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
