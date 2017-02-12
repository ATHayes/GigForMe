/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.Servlets;

import com.gigForMe.utils.IConstants;
import com.gigForMe.utils.StringUtils;
import com.gigForMe.manager.CommentManager;
import com.gigForMe.model.Band;
import com.gigForMe.model.Person;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anthonyhayes
 */
public class GetCommentsForThisBand extends HttpServlet{

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
        System.out.print("Comment Servlet fired");
        Person thisPerson = (Person) request.getSession(true).getAttribute(IConstants.SESSION_KEY_USER);
        Band thisBand = (Band) request.getSession(true).getAttribute(IConstants.SESSION_KEY_THIS_BAND);
        String content = request.getParameter("content");
        CommentManager cmg = CommentManager.getInstance();
        if (StringUtils.isStringEmpty(content)) {
           //do nothing
        } else {
            //save the comment, refresh the page.
            cmg.insertComment(thisPerson.getUserID(), thisBand.getBandID(), content);
            //call the fan bands servlet again - replace with ajax..
//            RequestDispatcher rd = request.getRequestDispatcher("FanBandDetailedServlet");
//            rd.forward(request,response);
        }
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
