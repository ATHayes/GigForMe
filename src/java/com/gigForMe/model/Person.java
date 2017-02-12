/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.model;

/**
 *
 * @author 110310587
 */
public class Person {

    public Person() {
    }

    public Person(String firstName, String surname, String DOB, String gender, String email, String signUpDate, String username, String password, String auth, int bandID, String imgName) {
        this.firstName = firstName;
        this.surname = surname;
        this.DOB = DOB;
        this.gender = gender;
        this.email = email;
        this.signUpDate = signUpDate;
        this.username = username;
        this.password = password;
        this.auth = auth;
        this.bandID = bandID;
        this.imgName = imgName;
    }

    public Person(int userID, String firstName, String surname, String DOB, String gender, String email, String signUpDate, String username, String password, String auth, int bandID, String imgName) {
        this.userID = userID;
        this.firstName = firstName;
        this.surname = surname;
        this.DOB = DOB;
        this.gender = gender;
        this.email = email;
        this.signUpDate = signUpDate;
        this.username = username;
        this.password = password;
        this.auth = auth;
        this.bandID = bandID;
        this.imgName = imgName;
    }

    private int userID;
    private String firstName;
    private String surname;
    private String DOB;
    private String gender;
    private String email;
    private String signUpDate;
    private String username;
    private String password;
    private String auth;
    private int bandID;
    private String imgName;

    

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the DOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the signUpDate
     */
    public String getSignUpDate() {
        return signUpDate;
    }

    /**
     * @param signUpDate the signUpDate to set
     */
    public void setSignUpDate(String signUpDate) {
        this.signUpDate = signUpDate;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the auth
     */
    public String getAuth() {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * @return the imgName
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * @param imgName the imgName to set
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**
     * @return the bandID
     */
    public int getBandID() {
        return bandID;
    }

    /**
     * @param bandID the bandID to set
     */
    public void setBandID(int bandID) {
        this.bandID = bandID;
    }

   

    
    
    
}
