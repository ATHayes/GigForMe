/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.manager;

import com.gigForMe.DAO.PersonDAO;
import com.gigForMe.DAO.PersonDAOImpl;
import com.gigForMe.model.Person;
import java.util.ArrayList;

/**
 * The Manager (or Service) class for Persons
 * @author anthonyhayes
 */
public class PersonManager {
     private static PersonManager instance = new PersonManager();
     
     
   //make the constructor private so that this class cannot be
   //instantiated
   private PersonManager(){}

   //Get the only object available

    /**
     * Singleton - returns the single instance of PersonManager
     * @return
     */
       public static PersonManager getInstance(){
      return instance;
   }  
   // Person DAO for all functions
   PersonDAO pDAO = PersonDAOImpl.getInstance();

    /**
     *
     * @return
     */
    public ArrayList<Person> getAllFans(){
       ArrayList<Person> allFans = new ArrayList();
       
       ArrayList<Person> allPeople = pDAO.getAllUsers();
       
       //filter out admins
       for (Person p : allPeople){
           if ("FAN".equals(p.getAuth())){
               allFans.add(p);
           }          
       }

       return allFans;
   }
   
    /**
     *
     * @return
     */
    public ArrayList<Person> getAllAdmins(){
       ArrayList<Person> allAdmins = new ArrayList();
       ArrayList<Person> allPeople = pDAO.getAllUsers();
       
       //filter out admins
       for (Person p : allPeople){
           if ("ADMIN".equals(p.getAuth())){
               allAdmins.add(p);
           }          
       }

       return allAdmins;
   }

    /**
     *
     * @return
     */
    public ArrayList<Person> getAllPeople(){
       ArrayList<Person> allPeople = pDAO.getAllUsers();
       return allPeople;
   }
    /**
     *
     * @param userID
     */
    public void deleteUser(int userID){
       try{
        pDAO.deleteUser(userID);
        }
        //Catch if the user doesn't exist or there's any other problem
        catch(Exception ex){
            //logger.info("DeleteUserServlet - Error Deleting User");
        }
   }
    
    /**
     * Will return false if the email passed is not unique
     * @param email
     * @return
     */
    public boolean testEmailUnique(String email){
         PersonManager pmg = PersonManager.getInstance();
         ArrayList<Person> allPeople = pmg.getAllPeople();
         for (Person p: allPeople){
             if(email.equals(p.getEmail())){
                 return false;
             }
         }
         return true;
     }
     
    /**
     * Will return false if the email passed is not unique, not including the user passed into this function
     * @param email
     * @param userID
     * @return
     */
    public boolean testEmailUnique(String email, String userID){
         PersonManager pmg = PersonManager.getInstance();
         ArrayList<Person> allPeople = pmg.getAllPeople();
         for (Person p: allPeople){
             if(email.equals(p.getEmail())){
                 // check if this is the user's current email
                 if (p.getUserID() != Integer.valueOf(userID)){
                 return false;
                 }
             }
         }
         return true;
     }
}
