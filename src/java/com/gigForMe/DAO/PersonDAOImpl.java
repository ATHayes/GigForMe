/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.DAO;

import com.gigForMe.utils.DBManager;
import com.gigForMe.model.Person;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 110310587
 */
public class PersonDAOImpl implements PersonDAO{
   //singleton code adapted from -- http://www.tutorialspoint.com/design_pattern/singleton_pattern.htm    
//create an object of SingleObject
   private static PersonDAOImpl instance = new PersonDAOImpl();

   //make the constructor private so that this class cannot be
   //instantiated
   private PersonDAOImpl(){}

   //Get the only object available
   public static PersonDAOImpl getInstance(){
      return instance;
   } 
   
//   CRUD METHODS
   @Override
     public Person getUser(int userID) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
    
        Person user = null;
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("select * from PERSON WHERE PERSON_ID=" + userID);
            while (results.next()) {
                //We get our results and insert them into a new user object. 
                user = new Person(
                        results.getInt(1),      //userID
                        results.getString(2),   //firstName
                        results.getString(3),   //surname
                        results.getString(4),   //DOB
                        results.getString(5),   //gender
                        results.getString(6),  //email
                        results.getString(7),  //signUpDate
                        results.getString(8),  //username 
                        results.getString(9),   //password
                        results.getString(10),   //auth
                        results.getInt(11),      //bandid
                        results.getString(12)   //img name
                 
                        );
            }
            results.close();
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
             System.out.println("SQL Error code:" + sqlExcept);
        }
        return user;
    }
     // WHERE AUTH= 'FAN - get all admins, get all fans...
   @Override
    public ArrayList<Person> getAllUsers() {
        ArrayList<Person> userList = new ArrayList<Person>();
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        Person user = null;
        try {
            stmt = con.createStatement();
            try (ResultSet results = stmt.executeQuery("Select * from PERSON")) {
                while (results.next()) {
                    Blob blob = results.getBlob(13);
                    userList.add(new Person(
                            results.getInt(1),      //userID
                            results.getString(2),   //firstName
                            results.getString(3),   //surname
                            results.getString(4),   //DOB
                            results.getString(5),   //gender
                            results.getString(6),  //email
                            results.getString(7),  //signUpDate
                            results.getString(8),  //username
                            results.getString(9),   //password
                            results.getString(10),   //auth
                            results.getInt(11),  //bandid
                            results.getString(12)   //imgname
                    ));
                }
            }
            stmt.close();
            con.close();
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code:" + sqlExcept);
        }
        return userList;
    }
      
   @Override
    public void insertUser(Person user) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        try {
            stmt = con.createStatement();
            String Query = "INSERT INTO PERSON("
                    + "FIRST_NAME,"
                    + "SURNAME,"
                    + "DOB,"
                    + "GENDER,"
                    + "EMAIL,"
                    + "SIGN_UP_DATE,"
                    + "USERNAME,"
                    + "PASSWORD,"
                    + "AUTH," 
                    + "BAND_ID,"
                    + "IMG_NAME)" +
                    " VALUES(";
            String vars = 
                    "'" + user.getFirstName() + "',"
                    + "'" + user.getSurname()+ "'," 
                    + "'" + user.getDOB() +  "',"
                    + "'" + user.getGender() +  "',"
                    + "'" + user.getEmail() +  "',"
                    + "'" + user.getSignUpDate() +  "',"
                    + "'" + user.getUsername() +  "',"
                    + "'" + user.getPassword() +  "',"
                    + "'" + user.getAuth() +  "',"
                    + "" + user.getBandID() +  ","
                    + "'" + user.getImgName() +  "')";;
            Query = Query + vars;
            stmt.execute(Query);
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code:" + sqlExcept);
        }
    }
    
      public void updateUser(Person user) {
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        int id = user.getUserID();
        String std = Integer.toString(id);
        try{
            stmt = con.createStatement();
//           //FIRST NAME
            String Query = "UPDATE PERSON SET FIRST_NAME = " + "'" + user.getFirstName() + "'"
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query);
//          //SURNAME
            Query = "UPDATE PERSON SET SURNAME = " + "'" + user.getSurname() + "'"
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query);
//          //DOB
            Query = "UPDATE PERSON SET DOB = " + "'" + user.getDOB() + "'"
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query);
//           //GENDER
            Query = "UPDATE PERSON SET GENDER = " + "'" + user.getGender() + "'"
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query);
//          //EMAIL
            Query = "UPDATE PERSON SET EMAIL = " + "'" + user.getEmail() + "'"
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query);
//          //SIGN_UP_DATE
            Query = "UPDATE PERSON SET SIGN_UP_DATE = " + "'" + user.getSignUpDate() + "'"
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query);
//           //USERNAME
            Query = "UPDATE PERSON SET USERNAME = " + "'" + user.getUsername() + "'"
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query);
//          //PASSWORD
            Query = "UPDATE PERSON SET PASSWORD = " + "'" + user.getPassword() + "'"
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query);
//          //PERMISSION
            Query = "UPDATE PERSON SET AUTH = " + "'" + user.getAuth() + "'"
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query); 
            
            Query = "UPDATE PERSON SET BAND_ID = " + "" + user.getBandID() + ""
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query);     
            
            Query = "UPDATE PERSON SET IMG_NAME = " + "'" + user.getImgName() + "'"
                    + "WHERE PERSON_ID = " + std;
            stmt.execute(Query);     
//          //BAND_ID -- FOR USERS TO BE A MEMBER OF BAND (ADmins can't be band members)
//            Query = "UPDATE PERSON SET BAND_ID = " + "'" + user.getBandID() + "'"
//                    + "WHERE PERSON_ID = " + std;
//            stmt.execute(Query);             
            
            //TODO - the rest of the update logic
        } catch (SQLException Ex) {
            System.out.println("SQL Error code:" + Ex);
        }
    }
      
   @Override
    public void deleteUser(int id){
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        try {
            stmt = con.createStatement();
            //String ID2 = integer.tostring(id);
            String Query = "DELETE FROM PERSON WHERE PERSON_ID = " + id;
            //System.out.println(Query);
            stmt.execute(Query);
        } catch (SQLException sqlExcept) {
            System.out.println("SQL Error code:" + sqlExcept);
        }
    }  
    
   @Override
    public Person getUserByEmail(String email) {
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        Person user = null;
        String query = "SELECT * FROM PERSON WHERE EMAIL=" + "'" + email + "'";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
          
           while (results.next()) {
                //We get our results and insert them into a new user object. 
                user = new Person(
                        results.getInt(1),      //userID
                            results.getString(2),   //firstName
                            results.getString(3),   //surname
                            results.getString(4),   //DOB
                            results.getString(5),   //gender
                            results.getString(6),  //email
                            results.getString(7),  //signUpDate
                            results.getString(8),  //username
                            results.getString(9),   //password
                            results.getString(10),   //auth
                            results.getInt(11),  //bandid
                            results.getString(12)   //twitter url
                        
                        );
            }
            results.close();
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return user;    
}
  
}
