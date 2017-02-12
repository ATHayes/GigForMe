/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.model;

import static com.gigForMe.utils.StringUtils.cutToLastSpace;

/**
 *
 * @author 110310587
 */
public class Band implements Comparable<Band>{

    public Band(int bandID, String bandname, String genre, String email, String cancelled, String imgName, String description, String twitterUrl) {
        this.bandID = bandID;
        this.bandname = bandname;
        this.genre = genre;
        this.email = email;
        this.cancelled = cancelled;
        this.imgName = imgName;
        this.description = description;
        this.twitterUrl = twitterUrl;
    }

  
    private int bandID;
    private String bandname;
    private String genre;
    private String email;
    private String cancelled;
    private String imgName;
    private String description;
    private String twitterUrl;
    private int votes = 0;

    public Band(String bandname, String genre, String email, String cancelled, String imgName, String description, String twitterUrl) {
        this.bandname = bandname;
        this.genre = genre;
        this.email = email;
        this.cancelled = cancelled;
        this.imgName = imgName;
        this.description = description;
        this.twitterUrl = twitterUrl;
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
     * @return the name
     */
    public String getBandname() {
        return bandname;
    }

    /**
     * @param bandname the name to set
     */
    public void setBandname(String bandname) {
        this.bandname = bandname;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
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
     * @return the cancelled
     */
    public String getCancelled() {
        return cancelled;
    }

    /**
     * @param cancelled the cancelled to set
     */
    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * @return the imgName
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * @param imgName the imgUrl to set
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return cutToLastSpace(description, 200)+ "...";
    }
    
   
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the twitterUrl
     */
    public String getTwitterUrl() {
        return twitterUrl;
    }

    /**
     * @param twitterUrl the twitterUrl to set
     */
    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    /**
     * @return the votes
     */
    public int getVotes() {
        return votes;
    }

    /**
     * @param votes the votes to set
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }
    
    //compare method for sort - http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
    public int compareTo(Band compareBand) {
		int compareVotes = ((Band) compareBand).getVotes(); 
		//descending order
		return compareVotes - this.votes;
		
	}	
}
