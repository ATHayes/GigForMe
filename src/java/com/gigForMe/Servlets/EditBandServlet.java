/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.Servlets;

import com.gigForMe.utils.IConstants;
import com.gigForMe.manager.BandManager;
import com.gigForMe.model.Band;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to update a band on the database with new values
 * @author anthonyhayes
 */
public class EditBandServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get the band from the session key
        Band band = (Band) request.getSession(true).getAttribute(IConstants.SESSION_KEY_THIS_BAND);
        
        //get the new values
        String bandname = request.getParameter("bandname");
        String genre = request.getParameter("genre");
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        String dataWidgetID = request.getParameter("dataWidgetID");
       
        //validate the new values
        
        
        //update our band object with the new values
        band.setBandname(bandname);
        band.setGenre(genre);
        band.setEmail(email);
        band.setDescription(description);
        band.setTwitterUrl(dataWidgetID);

        //modify that band
        BandManager bmg = BandManager.getInstance();
        bmg.updateBand(band);
        //reload the page
         RequestDispatcher rd = request.getRequestDispatcher(IConstants.MANAGE_BANDS_PAGE);
        rd.forward(request, response);
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
