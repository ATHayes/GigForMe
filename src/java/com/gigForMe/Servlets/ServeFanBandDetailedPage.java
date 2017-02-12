package com.gigForMe.Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.gigForMe.utils.IConstants;
import com.gigForMe.DAO.BandDAOImpl;
import com.gigForMe.DAO.CommentDAOImpl;
import com.gigForMe.DAO.PersonDAOImpl;
import static com.gigForMe.manager.BandBoxManager.convertToBandBox;
import com.gigForMe.model.Band;
import com.gigForMe.model.BandBox;
import com.gigForMe.model.Comment;
import com.gigForMe.model.CommentBox;
import com.gigForMe.model.Person;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anthonyhayes
 */
public class ServeFanBandDetailedPage extends HttpServlet{

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
         
        BandDAOImpl bandDAO = BandDAOImpl.getInstance();
        PersonDAOImpl personDAO = PersonDAOImpl.getInstance();
        CommentDAOImpl commentDAO = CommentDAOImpl.getInstance();
        String bandID = request.getParameter("bandID");
        Band band = bandDAO.getBand(Integer.valueOf(bandID));
        
        //Array list for comment and comment boxes
        ArrayList<Comment> allCommentsForBand = commentDAO.getAllBandComments(band);
        ArrayList<CommentBox> commentBoxes = new ArrayList();
        
        Person tempPerson = null;
        Comment tempComment = null;
    
        try{
        //loop through comments, add that comment and user to the comment box
        for (int i = 1; i <= allCommentsForBand.size(); i++) {
             //new instance of comment box every time - here's why - https://stackoverflow.com/questions/19843506/why-does-my-arraylist-contain-n-copies-of-the-last-item-added-to-the-list
            CommentBox tempBox = new CommentBox();
            //arraylists start at 0, our database starts at 1
            tempComment = (allCommentsForBand.get(i-1));
            tempPerson = personDAO.getUser(tempComment.getUserID());
            tempBox.setComment(tempComment);
            tempBox.setPerson(tempPerson);
            commentBoxes.add(tempBox);
            //arraylists start at 0, our database starts at 1
//            System.out.println(commentBoxes.get(i-1).getPerson().getUsername());
         }
        Collections.sort(commentBoxes);
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_COMMENT_BOXES, commentBoxes);
        }
        catch (Exception ex){
             ex.printStackTrace(System.out);    
        }
        
        Person thisPerson = (Person) request.getSession(true).getAttribute(IConstants.SESSION_KEY_USER);
        BandBox bandBox = convertToBandBox(band, thisPerson);
       
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_THIS_BANDBOX, bandBox);
        request.getSession(true).setAttribute(IConstants.SESSION_KEY_THIS_BAND, band);
        RequestDispatcher rd = request.getRequestDispatcher(IConstants.FAN_BAND_PAGE_DETAILED);
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
