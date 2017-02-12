package com.gigForMe.Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.gigForMe.utils.IConstants;
import com.gigForMe.DAO.BandDAO;
import com.gigForMe.DAO.BandDAOImpl;
import com.gigForMe.DAO.VoteDAO;
import com.gigForMe.DAO.VoteDAOImpl;
import static com.gigForMe.manager.BandBoxManager.convertToBoxList;
import static com.gigForMe.manager.BandBoxManager.dividePages;
import com.gigForMe.model.Band;
import com.gigForMe.model.BandBox;
import com.gigForMe.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anthonyhayes
 */
public class ServeFanBandsPage extends HttpServlet{

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
        String page = request.getParameter("page");
        BandDAO bandDAO = BandDAOImpl.getInstance();
        VoteDAO vDAO = VoteDAOImpl.getInstance();
        ArrayList<Band> allBandsList = bandDAO.getAllBands();
        ArrayList<BandBox> allBandBoxes = new ArrayList();
        Person thisPerson = (Person) request.getSession(true).getAttribute(IConstants.SESSION_KEY_USER);
        allBandBoxes = convertToBoxList(allBandsList, thisPerson);
        int numPages = dividePages(allBandBoxes, 9);
        
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_ALL_BANDBOXES, allBandBoxes);
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_ALL_BANDS, allBandsList);
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_PAGE_NO, page);
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_NUM_PAGES, numPages);
        RequestDispatcher rd = request.getRequestDispatcher(IConstants.FAN_BAND_PAGE);
        rd.forward(request, response);
    }
     
     //http://stackoverflow.com/questions/11830351/multiple-submit-buttons-in-the-same-form-calling-different-servlets
     //details on how to get more than one method per servlet
     //if statements or an MVC framework like JSF or Spring MVC
     //we'll go with simple if statements here...

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
