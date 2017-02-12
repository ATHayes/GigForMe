/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.Servlets;

import com.gigForMe.utils.IConstants;
import com.gigForMe.utils.StringUtils;
import com.gigForMe.DAO.PersonDAOImpl;
import static com.gigForMe.Validation.ValidationTest.testAlphaNum;
import com.gigForMe.manager.PersonManager;
import com.gigForMe.manager.UserManager;
import com.gigForMe.model.Person;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to update a User on the database with new values
 * @author anthonyhayes
 */
public class EditUserServlet extends HttpServlet {

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
        String userID = request.getParameter("userID");
        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String DOB = request.getParameter("DOB");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String signUpDate = Calendar.getInstance().getTime().toString();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String imgName = request.getParameter("imgName");
        
        
        ArrayList<String> alphaNumList = new ArrayList();
        alphaNumList.add(firstName);
        alphaNumList.add(surname);
        alphaNumList.add(gender);


        if (StringUtils.isStringEmpty(email) || StringUtils.isStringEmpty(password)) {
            
            RequestDispatcher rd = request.getRequestDispatcher(IConstants.MANAGE_USERS_PAGE);
            rd.forward(request, response);
        } else {
            //Validate login details 
            //Alphanumeric test
            Boolean flag = false;
            for (String temp : alphaNumList) {
                flag = testAlphaNum(temp);
                if (flag == false){
                   
                }
            }
            
            //test if the email is unique
            PersonManager pmg = PersonManager.getInstance();
            flag = pmg.testEmailUnique(email, userID);
          
            if (flag == true) {
                //Save the user to the database
                UserManager uMgr = new UserManager();
                PersonDAOImpl pDAO = PersonDAOImpl.getInstance();
                Person user =  pDAO.getUser(Integer.valueOf(userID));
                user.setFirstName(firstName);
                user.setSurname(surname);
                user.setDOB(DOB);
                user.setGender(gender);
                user.setEmail(email);
                user.setPassword(password);
                user.setImgName(imgName);
                user.setSignUpDate(signUpDate);
                uMgr.modifyUser(user);
                
                RequestDispatcher rd = request.getRequestDispatcher(IConstants.MANAGE_USERS_PAGE);
            rd.forward(request, response);
            }
            else{
                 RequestDispatcher rd = request.getRequestDispatcher(IConstants.MANAGE_USERS_PAGE);
            rd.forward(request, response);
            }
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
