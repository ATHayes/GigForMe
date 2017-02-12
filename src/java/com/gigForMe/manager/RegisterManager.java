/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.manager;

import com.gigForMe.utils.IConstants;
import com.gigForMe.DAO.PersonDAOImpl;
import com.gigForMe.model.Person;

/**
 * This class handles user registration
 * @author 110310587
 */
public class RegisterManager {
      
    /**
     * This will register a new user
     * @param firstName
     * @param surname
     * @param DOB
     * @param gender
     * @param email
     * @param signUpDate
     * @param username
     * @param password
     */
    public void registerUser(String firstName, String surname, String DOB, String gender, String email,
        String signUpDate, String username, String password, String authorisation){
        PersonDAOImpl personDAO = PersonDAOImpl.getInstance();
        Person newPerson = new Person(
            firstName,   //firstName
            surname,     //surname
            DOB,        //DOB
            gender,     //gender
            email,       //email
            signUpDate,  //signUpDate
            username,    //username 
            password,    //password
            authorisation,        //auth
            -1,         //bandid
            IConstants.DEFAULT_USER_IMG_NAME   //imgName
            );
        personDAO.insertUser(newPerson);
        }
    }
