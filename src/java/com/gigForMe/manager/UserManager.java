package com.gigForMe.manager;
import com.gigForMe.model.Person;
import com.gigForMe.DAO.PersonDAOImpl;
import com.gigForMe.DAO.VoteDAO;
import com.gigForMe.DAO.VoteDAOImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author bemerson
 */

/**
 * The Manager (or Service) class for Users
 * @author anthonyhayes
 */

public class UserManager {
    
    /** This will take a username and select from user table
     * This will return three possible statuses, login correct, 
     * unknown user or password incorrect
     * @param email
     * @param password
     * @return  
     */
    public Person loginUser(String email, String password){
        
        PersonDAOImpl userDAO = PersonDAOImpl.getInstance();
        Person user = userDAO.getUserByEmail(email);
        if (user.getPassword().equals(password)){
            return user;
        }
        else return null;
    }
    
    /**
     *
     * @param userID
     * @param bandID
     */
    public void voteForBand(int userID, int bandID){
        VoteDAO vDAO = VoteDAOImpl.getInstance();
        //Check if vote already exists
        //if vote is not null, change its state
        if (vDAO.getVote(bandID, userID) != null){
            //set voted = true
            //update the vote
        }
         
        //If vote doesn't exist, create it
        else{
            //create a new vote
            
            //set the vote to yes
        }
    } 
    
    /**
     *
     * @param user
     */
    public void modifyUser(Person user){
        PersonDAOImpl pDAO = PersonDAOImpl.getInstance();
        pDAO.updateUser(user);
    }
    
   
}
