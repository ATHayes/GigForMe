/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.DAO;

import com.gigForMe.utils.DBManager;
import com.gigForMe.model.Band;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * A singleton data access object for the Band class. Can create, read, update and delete records from the database.
 * @author 110310587
 */
public class BandDAOImpl implements BandDAO{
    
//singleton code adapted from -- http://www.tutorialspoint.com/design_pattern/singleton_pattern.htm    
//create an object of SingleObject
   private static BandDAOImpl instance = new BandDAOImpl();

   //make the constructor private so that this class cannot be
   //instantiated
   private BandDAOImpl(){}

   //Get the only object available
   public static BandDAOImpl getInstance(){
      return instance;
   }    
   
//   CRUD METHODS
   @Override
    public Band getBand(int bandID) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        Band band = null;
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("Select * from BAND WHERE BAND_ID=" + bandID);
            while (results.next()) {
                //We get our results and insert them into a new user object. 
                band = new Band(results.getInt(1), results.getString(2),
                        results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getString(7), results.getString(8));
            }
            results.close();
            stmt.close();

        } catch (SQLException sqlExcept) {

             System.out.println("SQL Error code - getBand():" + sqlExcept);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return band;
    }
     
   @Override
    public ArrayList<Band> getAllBands() {
        ArrayList<Band> bandList = new ArrayList<Band>();
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        Band band = null;
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("Select * from `BAND`");
            while (results.next()) {
                bandList.add(new Band(results.getInt(1),results.getString(2),
                        results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getString(7), results.getString(8)));
            }
            results.close();
            stmt.close();

        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code -getAllBands():" + sqlExcept);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bandList;
    }
      
   @Override
    public void insertBand(Band band) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        try {
            stmt = con.createStatement();
            String Query = "INSERT INTO BAND(BANDNAME, GENRE, EMAIL, CANCELLED, IMG_NAME, DESCRIPTION, TWITTER_URL)" +
"VALUES(";
            String vars = "'" + band.getBandname() + "',"
                    +  "'" + band.getGenre()+ "'," 
                    + "'" + band.getEmail() + "'," 
                    + "'" + band.getCancelled() + "',"
                    + "'" + band.getImgName() + "',"
                    + "'" + band.getDescription() + "',"
                    + "'" + band.getTwitterUrl() + "')";
            Query = Query + vars;
            stmt.execute(Query);
        } catch (SQLException sqlExcept) {
            System.out.println("SSQL Error code -insertBand()" + sqlExcept);
        }
    }
    
    
   @Override
    public void updateBand(Band band) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int id = band.getBandID();
        String std = Integer.toString(id);
        
        try{
            stmt = con.createStatement();
            
            String Query = "UPDATE BAND SET BANDNAME = " + "'" + band.getBandname() + "'"
                    + "WHERE BAND_ID = " + std;
            stmt.execute(Query);
//            ----------------------
            Query = "UPDATE BAND SET GENRE = " + "'" + band.getGenre() + "'"
                    + "WHERE BAND_ID = " + std;
            stmt.execute(Query);
//          -----------------------
            Query = "UPDATE BAND SET EMAIL = " + "'" + band.getEmail() + "'"
                    + "WHERE BAND_ID = " + std;
            stmt.execute(Query);
 //           -------------------
            Query = "UPDATE BAND SET CANCELLED = " + "'" + band.getCancelled() + "'"
                    + "WHERE BAND_ID = " + std;
            stmt.execute(Query);
             //           -------------------
            Query = "UPDATE BAND SET DESCRIPTION = " + "'" + band.getDescription() + "'"
                    + "WHERE BAND_ID = " + std;
            stmt.execute(Query);
            //           -------------------
            Query = "UPDATE BAND SET IMG_NAME = " + "'" + band.getImgName() + "'"
                    + "WHERE BAND_ID = " + std;
            stmt.execute(Query);
            Query = "UPDATE BAND SET TWITTER_URL = " + "'" + band.getTwitterUrl() + "'"
                    + "WHERE BAND_ID = " + std;
            stmt.execute(Query);
            //TODO - the rest of the update logic
        } catch (SQLException Ex) {
            System.out.println("SQL Error code -updateBand():" + Ex);
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
    public void deleteBand(int id){
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        try {
            stmt = con.createStatement();
            //String ID2 = integer.tostring(id);
            String Query = "DELETE FROM BAND WHERE BAND_ID = " + id;
            //System.out.println(Query);
            stmt.execute(Query);
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code -deleteBand()" + sqlExcept);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }  
    
}
