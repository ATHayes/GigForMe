/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.Servlets;

import com.gigForMe.utils.IConstants;
import com.gigForMe.DAO.VoteDAO;
import com.gigForMe.DAO.VoteDAOImpl;
import com.gigForMe.model.Vote;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Takes a get request of a vote and saves that vote. Called via JQuery
 * @author anthonyhayes
 */
@WebServlet(name = "VoteServlet", urlPatterns = {"/VoteServlet"})
public class SubmitVote extends HttpServlet {

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
      String bandID = request.getParameter("bandID");
      String personID = request.getParameter("personID");
      String voted = request.getParameter("voted");
      VoteDAO vDAO = VoteDAOImpl.getInstance();
      if (null != voted) // don't want any values that aren't Yes or no going into the db
        switch (voted) {
          case "Yes":
          Vote thisVote = vDAO.getVote(Integer.valueOf(personID), Integer.valueOf(bandID));
          thisVote.setVoted(IConstants.VOTE_YES);
          vDAO.updateVote(thisVote);
          break;
         case "No":
         thisVote = vDAO.getVote(Integer.valueOf(personID), Integer.valueOf(bandID));
         thisVote.setVoted(IConstants.VOTE_NO);
         vDAO.updateVote(thisVote);
        break;
        }
      // No need to refresh page - Checkbox changes color on html page on click
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
