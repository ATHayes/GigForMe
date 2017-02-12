/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.DAO;


import com.gigForMe.utils.DBManager;
import com.gigForMe.model.Band;
import com.gigForMe.model.Comment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * DA data access object for the Comment class. Can create, read, update and delete records from the database.
 * @author anthonyhayes
 */

//SHOULD BE SINGLETON!
public class CommentDAOImpl implements CommentDAO{
    //singleton code adapted from -- http://www.tutorialspoint.com/design_pattern/singleton_pattern.htm    
//create an object of SingleObject
   private static final CommentDAOImpl instance = new CommentDAOImpl();

   //make the constructor private so that this class cannot be
   //instantiated
   private CommentDAOImpl(){}

   //Get the only object available
   public static CommentDAOImpl getInstance(){
      return instance;
   }
    public Comment getComment(int commentID) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
    
        Comment comment = null;
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("select * from COMMENT WHERE COMMENT_ID=" + commentID);
            while (results.next()) {
                //We get our results and insert them into a new user object. 
                comment = new Comment(results.getInt(1), results.getInt(2),
                        results.getInt(3), results.getString(4));
            }
            results.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
             System.out.println("SQL Error code:" + sqlExcept);
        }
        return comment;
    }
    
    public ArrayList<Comment> getAllComments() {
        ArrayList<Comment> commentList = new ArrayList<Comment>();
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        Comment comment = null;

        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("Select * from COMMENT");
            while (results.next()) {
                commentList.add(new Comment(results.getInt(1),results.getInt(2),
                        results.getInt(3), results.getString(4)));
            }
            results.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code:" + sqlExcept);
        }
        return commentList;
    }
    
    public ArrayList<Comment> getAllBandComments(Band band) {
        ArrayList<Comment> commentList = new ArrayList<>();
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();

        try {
            stmt = con.createStatement();
            String bandID = Integer.toString(band.getBandID());
            try (ResultSet results = stmt.executeQuery("Select * from COMMENT WHERE BAND_ID=" + bandID)) {
                while (results.next()) {
                    commentList.add(new Comment(results.getInt(1),results.getInt(2),
                            results.getInt(3), results.getString(4)));
                }
            }
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code:" + sqlExcept);
        }
        return commentList;
    }
    
    
     public void insertComment(Comment comment) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        try {
            stmt = con.createStatement();
            String Query = "INSERT INTO COMMENT(USER_ID,BAND_ID, CONTENT)" +
"VALUES(";
            String vars = comment.getUserID() + ","
                    + comment.getBandID() + 
                   ",'" + comment.getContent() +"')";
            Query = Query + vars;
            stmt.execute(Query);
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code:" + sqlExcept);
        }
    }
     
     
     
     public void updateComment(Comment comment) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int id = comment.getCommentID();
        String std = Integer.toString(id);
        
        try{
            stmt = con.createStatement();
//          Update each value individually from the comment argument
            
            //user id
            String Query = "UPDATE COMMENT SET USER_ID = " + comment.getUserID()
                    + "WHERE COMMENT_ID = " + std;
            stmt.execute(Query);
//          // band id
            Query = "UPDATE COMMENT SET BAND_ID = " + comment.getBandID() 
                    + "WHERE COMMENT_ID = " + std;
            stmt.execute(Query);
//          // content
            Query = "UPDATE COMMENT SET CONTENT = " + "'" + comment.getContent() + "'"
                    + "WHERE COMMENT_ID = " + std;
            stmt.execute(Query);
            
        } catch (SQLException Ex) {
            System.out.println("SQL Error code:" + Ex);
        }
    }
     
      public void deleteComment(int id){
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        try {
            stmt = con.createStatement();
            //String ID2 = integer.tostring(id);
            String Query = "DELETE FROM COMMENT WHERE COMMENT_ID = " + id;
            //System.out.println(Query);
            stmt.execute(Query);
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code:" + sqlExcept);
        }
    }  

    @Override
    public int countRecords() {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int comment =0;
        try {
            stmt = con.createStatement();
            
            String Query = "SELECT COUNT(COMMENT_ID) FROM COMMENT";
            
            ResultSet results = stmt.executeQuery(Query);
            while (results.next()) {
                //We get our results and insert them into a new user object. 
                comment = results.getInt(1);
            }
            results.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code:" + sqlExcept);
        }  
       return comment;
    }
}
