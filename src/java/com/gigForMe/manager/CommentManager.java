/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.manager;

import com.gigForMe.DAO.CommentDAO;
import com.gigForMe.DAO.CommentDAOImpl;
import com.gigForMe.model.Comment;
import java.util.ArrayList;

/**
 * The Manager (or Service) class for Comments
 * @author anthonyhayes
 */
public class CommentManager {
       private static CommentManager instance = new CommentManager();

   //make the constructor private so that this class cannot be
   //instantiated
   private CommentManager(){}

   //Get the only object available

    /**
     * Singleton - returns the single instance of CommentManager
     * @return
     */
       public static CommentManager getInstance(){
      return instance;
   }  
   
   CommentDAO cDAO = CommentDAOImpl.getInstance();
   
    /**
     * Counts all the comments in the database
     * @return
     */
    public int countComments(){
       
       int commentCount = cDAO.countRecords();
       return commentCount;
   }
    
  
    
    /**
     * inserts a new comment into the database
     * @param userID
     * @param bandID
     * @param content
     */
    public void insertComment(int userID, int bandID, String content) {
        try{
            Comment comment = new Comment(userID,bandID,content);
            cDAO.insertComment(comment);
        } catch(Exception ex){
            //logger.info("Error Inserting Comment at CommentManager");
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Comment> getAllComments() {
        ArrayList<Comment> allComments = cDAO.getAllComments();
        return allComments;
    }
}
