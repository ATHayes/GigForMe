/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.Servlets;

import com.gigForMe.utils.IConstants;
import com.gigForMe.manager.BandManager;
import com.gigForMe.manager.CommentManager;
import com.gigForMe.manager.PersonManager;
import com.gigForMe.model.Band;
import com.gigForMe.model.Person;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Prepares the dashboard page for presentation
 * @author anthonyhayes
 */
public class ServeDashboardPage extends HttpServlet {

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
        //get
        BandManager bmg = BandManager.getInstance();
        ArrayList<Band> allBands = bmg.getAllBands();
        CommentManager cmg = CommentManager.getInstance();
        int numComments = cmg.countComments();
        PersonManager pmg = PersonManager.getInstance();
        ArrayList<Person> allFans = pmg.getAllFans();
        ArrayList<Person> allAdmins = pmg.getAllAdmins();
        int numFans = allFans.size();
        int numAdmins = allAdmins.size();
        int numVotes = 0;
        for (Band b: allBands){
            numVotes += b.getVotes();
        }
        
        
    
        
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_NUM_COMMENTS, numComments);
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_All_BANDS, allBands);
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_NUM_FANS, numFans);
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_NUM_ADMINS, numAdmins);
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_NUM_VOTES, numVotes);
        RequestDispatcher rd = request.getRequestDispatcher(IConstants.ADMIN_DASHBOARD_PAGE);
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
