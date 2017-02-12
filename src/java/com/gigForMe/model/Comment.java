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
public class Comment {

    public Comment() {
    }

    public Comment(int userID, int bandID, String content) {
        this.userID = userID;
        this.bandID = bandID;
        this.content = content;
    }

    public Comment(int commentID, int userID, int bandID, String content) {
        this.commentID = commentID;
        this.userID = userID;
        this.bandID = bandID;
        this.content = content;
    }
    private static final Logger LOG = Logger.getLogger(Comment.class.getName());

    private int commentID;
    private int userID;
    private int bandID;
    private String content;

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
     * @return the commentID
     */
    public int getCommentID() {
        return commentID;
    }

    /**
     * @param commentID the commentID to set
     */
    public void setCommentID(int commentID) {
        this.commentID = commentID;
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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
}
