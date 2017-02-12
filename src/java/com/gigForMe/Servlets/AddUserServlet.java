/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.Servlets;

import com.gigForMe.utils.IConstants;
import com.gigForMe.utils.StringUtils;
import com.gigForMe.manager.PersonManager;
import com.gigForMe.manager.RegisterManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to add a User to the database
 * @author anthonyhayes
 */
@WebServlet(name = "AddUserServlet", urlPatterns = {"/AddUserServlet"})
public class AddUserServlet extends HttpServlet {

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
        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String DOB = request.getParameter("DOB");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String signUpDate = Calendar.getInstance().getTime().toString();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String authorisation = request.getParameter("authorisation");
        ArrayList<String> alphaNumList = new ArrayList();
        alphaNumList.add(firstName);
        alphaNumList.add(surname);
        alphaNumList.add(gender);
       

        if (StringUtils.isStringEmpty(email) || StringUtils.isStringEmpty(password)) {
            RequestDispatcher rd = request.getRequestDispatcher(IConstants.ADD_USER_PAGE);
            rd.forward(request, response);
        } else {
            //Validate login details 
            Boolean flag = false;
            //Alphanumeric test
            for (String temp : alphaNumList) {
                flag = testAlphaNum(temp);
            }
            PersonManager pmg = PersonManager.getInstance();
            flag = pmg.testEmailUnique(email);
            
            ///Date test   
            //No special characters test ./*<etc
            if (flag == true) {
                //Save the user to the database
                RegisterManager rMgr = new RegisterManager();
                rMgr.registerUser(firstName, surname, DOB, gender, email, signUpDate, username, password, authorisation);
                
                }
                
            //if that all fails, just refresh the page
            }
            RequestDispatcher rd = request.getRequestDispatcher(IConstants.MANAGE_USERS_PAGE);
            rd.forward(request, response);
        }
    

    // validation code taken from http://stackoverflow.com/questions/12831719/fastest-way-to-check-a-string-is-alphanumeric-in-java

    /**
     *
     * @param str
     * @return
     */
     public boolean testAlphaNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a) {
                return false;
            }
        }
        return true;
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
