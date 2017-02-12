package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.gigForMe.DAO.BandDAO;
import com.gigForMe.DAO.BandDAOImpl;
import com.gigForMe.DAO.CommentDAOImpl;
import com.gigForMe.model.Band;

import com.gigForMe.model.Comment;
import java.util.ArrayList;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author davidwalsh
 */
public class CommentDAOTest {
    
    public CommentDAOTest() {
    }
    
    @Test
    public static void testGet(){
        CommentDAOImpl cDAO = CommentDAOImpl.getInstance();
        Comment comment = cDAO.getComment(1);
        Assert.assertNotNull(comment);
    }
    
    @Test
    public static void testInsert(){
        CommentDAOImpl cDAO = CommentDAOImpl.getInstance();
        Comment c = new Comment(4,6, "Com5");
        cDAO.insertComment(c);
        //test each individual value
      
    }
    
    @Test
    public static void testModify(){
        Comment comment = new Comment(4,6, "Com5");
        CommentDAOImpl cDAO = CommentDAOImpl.getInstance();
        //save the old value for use after
        Comment oldComment = new Comment(comment.getCommentID(),comment.getUserID(), comment.getBandID(), comment.getContent());
        comment = cDAO.getComment(1);
        comment.setBandID(1);
        comment.setUserID(1);
        
        cDAO.updateComment(comment);
        Assert.assertEquals(cDAO.getComment(1).getUserID(), comment.getUserID());
        Assert.assertEquals(cDAO.getComment(1).getBandID(), comment.getBandID());
        Assert.assertEquals(cDAO.getComment(1).getContent(), comment.getContent());
        Assert.assertEquals(cDAO.getComment(1).getCommentID(), comment.getCommentID());
        //reset comment
        cDAO.updateComment(oldComment);
    }
  

    @Test
     public static void testGetAll(){
         ArrayList<Comment> stockComments;
         CommentDAOImpl aDAO = CommentDAOImpl.getInstance();
         ArrayList<Comment> allComments = aDAO.getAllComments();
         String results = "";
         
         Comment com1 = new Comment(4,6, "Com5");
         Comment com2 = new Comment(4,6, "Com5");
         Comment com3  = new Comment(4,6, "Com5");
        
         Assert.assertNotNull(allComments.get(1));
         Assert.assertNotNull(allComments.get(2));
     }
     
     @Test
      public static void testGetAllForBand(){
         
         BandDAO bandDAO = BandDAOImpl.getInstance();
         Band tempband = null;
         tempband = bandDAO.getBand(1);
         CommentDAOImpl aDAO = CommentDAOImpl.getInstance();
         ArrayList<Comment> allComments = aDAO.getAllBandComments(tempband);
         
         Assert.assertNotNull(allComments.get(1));
     }
   

    @Test
    public static void testDelete(){
        CommentDAOImpl cDAO = CommentDAOImpl.getInstance();
        cDAO.deleteComment(5);
        Assert.assertNull(cDAO.getComment(5));
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
  
}
