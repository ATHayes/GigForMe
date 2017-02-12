/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.model;

import java.util.logging.Logger;

/**
 *
 * @author anthonyhayes
 */
public class Vote {

    public Vote(int voteID, int userID, int bandID, String voted) {
        this.voteID = voteID;
        this.userID = userID;
        this.bandID = bandID;
        this.voted = voted;
    }

    public Vote(int userID, int bandID, String voted) {
        this.userID = userID;
        this.bandID = bandID;
        this.voted = voted;
    }

    private int voteID;
    private int userID;
    private int bandID;
    private String voted;

    
    private static final Logger LOG = Logger.getLogger(Vote.class.getName());

    /**
     * @return the voteID
     */
    public int getVoteID() {
        return voteID;
    }

    /**
     * @param voteID the voteID to set
     */
    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }

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

    /**
     * @return the voted
     */
    public String getVoted() {
        return voted;
    }

    /**
     * @param voted the voted to set
     */
    public void setVoted(String voted) {
        this.voted = voted;
    }

}
