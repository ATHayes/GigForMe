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
public class BandBox {
    
    public BandBox(Band band, Vote vote, Person person) {
        this.band = band;
        this.vote = vote;
        this.person = person;
    }

    public BandBox(Band band) {
        this.band = band;
    }
    private Band band;
    private Vote vote;
    private Person person;
    
    //given a user and a list of bands
    //iterate through the band, making a band box of that band, t vote

    /**
     * @return the band
     */
    public Band getBand() {
        return band;
    }

    /**
     * @param band the band to set
     */
    public void setBand(Band band) {
        this.band = band;
    }

    /**
     * @return the vote
     */
    public Vote getVote() {
        return vote;
    }

    /**
     * @param vote the vote to set
     */
    public void setVote(Vote vote) {
        this.vote = vote;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }
    
}
