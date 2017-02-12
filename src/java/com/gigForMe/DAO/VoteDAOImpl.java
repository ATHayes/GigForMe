/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.DAO;


import com.gigForMe.utils.DBManager;
import com.gigForMe.model.Person;
import com.gigForMe.model.Vote;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * A data access object for the Vote class. Can create, read, update and delete records from the database.
 * @author anthonyhayes
 */

//SHOULD BE SINGLETON!
public class VoteDAOImpl implements VoteDAO{
    //singleton code adapted from -- http://www.tutorialspoint.com/design_pattern/singleton_pattern.htm    
//create an object of SingleObject
   private static final VoteDAOImpl instance = new VoteDAOImpl();

   //make the constructor private so that this class cannot be
   //instantiated
   private VoteDAOImpl(){}

   //Get the only object available
   public static VoteDAOImpl getInstance(){
      return instance;
   }
   
   @Override
    public Vote getVote(int voteID) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        Vote vote = null;
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("select * from VOTE WHERE VOTE_ID=" + voteID);
            while (results.next()) {
                //We get our results and insert them into a new user object. 
                vote = new Vote(results.getInt(1), results.getInt(2),
                        results.getInt(3), results.getString(4));
            }
            results.close();
            stmt.close();

        } catch (SQLException sqlExcept) {
             System.out.println("SQL Error code -getVote()" + sqlExcept);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vote;
    }
    //get votes for this user
     public ArrayList<Vote> getUserVotes(Person user) {
        ArrayList<Vote> voteList = new ArrayList<Vote>();
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("Select * from VOTE WHERE PERSON_ID="+ user.getUserID());
            while (results.next()) {
                voteList.add(new Vote(results.getInt(1),results.getInt(2),
                        results.getInt(3), results.getString(4)));
            }
            results.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code -getUserVotes():" + sqlExcept);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return voteList;
    } 
    
   @Override
    public ArrayList<Vote> getAllVotes() {
        ArrayList<Vote> voteList = new ArrayList<Vote>();
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();

        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("Select * from VOTE");
            while (results.next()) {
                voteList.add(new Vote(results.getInt(1),results.getInt(2),
                        results.getInt(3), results.getString(4)));
            }
            results.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code -getAllVotes():" + sqlExcept);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return voteList;
    }
   @Override
     public void insertVote(Vote vote) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        try {
            stmt = con.createStatement();
            String Query = "INSERT INTO VOTE(USER_ID,BAND_ID, VOTED)" +
"VALUES(";
            String vars = vote.getUserID() + ","
                        + vote.getBandID() + ",'"
                        + vote.getVoted() +"')";
            Query = Query + vars;
            stmt.execute(Query);
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code -insertVote():" + sqlExcept);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     
   @Override
     public void updateVote(Vote vote) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int id = vote.getVoteID();
        String std = Integer.toString(id);
        
        try{
           
            stmt = con.createStatement();
//          Update each value individually from the vote argument
            //user id
            String Query = "UPDATE VOTE SET USER_ID = " + vote.getUserID()
                    + " WHERE VOTE_ID = " + std;
            stmt.execute(Query);
//          // band id
            Query = "UPDATE VOTE SET BAND_ID = " + vote.getBandID()
                    + " WHERE VOTE_ID = " + std;
            stmt.execute(Query);
//          // Voted
            Query = "UPDATE VOTE SET VOTED = '" + vote.getVoted() 
                    + "' WHERE VOTE_ID = " + std;
            stmt.execute(Query);
        } catch (SQLException Ex) {
            System.out.println("SQL Error code -updateVote()::" + Ex);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     
   @Override
      public void deleteVote(int id){
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        try {
            stmt = con.createStatement();
            //String ID2 = integer.tostring(id);
            String Query = "DELETE FROM VOTE WHERE VOTE_ID = " + id;
            //System.out.println(Query);
            stmt.execute(Query);
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code -deleteVote():" + sqlExcept);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }  

    @Override
    public Vote getVote(int userID, int bandID) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        Vote vote = null;
        try {
            stmt = con.createStatement();
            String query = "select * from gigforme.VOTE WHERE USER_ID=" + userID + " AND BAND_ID=" + bandID;
            ResultSet results = stmt.executeQuery(query);
            while (results.next()) {
                //We get our results and insert them into a new user object. 
                vote = new Vote(results.getInt(1), results.getInt(2),
                        results.getInt(3), results.getString(4));
            }
            results.close();
            stmt.close();
            
        } catch (SQLException sqlExcept) {
             System.out.println("SQL Error code -getVoteOverloaded():" + sqlExcept);

        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vote;
    }

   
}
