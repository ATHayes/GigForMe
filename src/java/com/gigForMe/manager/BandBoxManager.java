/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.manager;

import com.gigForMe.DAO.BandDAO;
import com.gigForMe.DAO.BandDAOImpl;
import com.gigForMe.DAO.PersonDAO;
import com.gigForMe.DAO.PersonDAOImpl;
import com.gigForMe.DAO.VoteDAO;
import com.gigForMe.DAO.VoteDAOImpl;
import com.gigForMe.model.Band;
import com.gigForMe.model.BandBox;
import com.gigForMe.model.Person;
import com.gigForMe.model.Vote;
import static java.lang.Math.ceil;
import java.util.ArrayList;

/**
 * A class to gather each band and the user's votes into a single container
 * This is used to create the list of bands with pictures and the option to vote
 * @author anthonyhayes
 */
public class BandBoxManager {

    /**
     *
     * @param allBandsList
     * @param thisPerson
     * @return
     */
    public static ArrayList<BandBox> convertToBoxList(ArrayList<Band> allBandsList, Person thisPerson){
     BandDAO bandDAO = BandDAOImpl.getInstance();
     VoteDAO vDAO = VoteDAOImpl.getInstance();
     ArrayList<BandBox> allBandBoxes = new ArrayList();
     PersonDAO pDAO = PersonDAOImpl.getInstance();
 
     
     for (Band band: allBandsList){
            Vote vote = null;
            try{
                vote = vDAO.getVote(thisPerson.getUserID(), band.getBandID());
                Integer.valueOf(vote.getVoteID());
            }catch(Exception ex){
                Vote newVote = new Vote(thisPerson.getUserID(),band.getBandID(), "No");
                vDAO.insertVote(newVote);
                vote = newVote;
            }
           BandBox newBox = new BandBox(band, vote,thisPerson);
           allBandBoxes.add(newBox);
     }
    return allBandBoxes;
    }
    
    /**
     * Create a band box using a band and person object
     * @param band
     * @param thisPerson
     * @return
     */
    public static BandBox convertToBandBox(Band band, Person thisPerson){
     BandDAO bandDAO = BandDAOImpl.getInstance();
     VoteDAO vDAO = VoteDAOImpl.getInstance();
     BandBox bandBox = null;
     PersonDAO pDAO = PersonDAOImpl.getInstance();
 
        Vote vote = null;
            try{
                vote = vDAO.getVote(thisPerson.getUserID(), band.getBandID());
                Integer.valueOf(vote.getVoteID());
            }catch(Exception ex){
                Vote newVote = new Vote(thisPerson.getUserID(),band.getBandID(), "No");
                vDAO.insertVote(newVote);
                vote = newVote;
            }
     bandBox = new BandBox(band, vote,thisPerson);
     return bandBox;
     }
     
    /**
     * Divide an arraylist (like an array of BandBoxes) by a certain number
     * Used to figure out how many pages of bands are needed
     * By default the number of bands is 9 per page, but this can be changed
     * 
     * @param list
     * @param boxesPerPage
     * @return
     */
    public static int dividePages(ArrayList list, int boxesPerPage){
         int pages;
         double numBoxes = list.size();
         double unrounded = (numBoxes/boxesPerPage);
         pages = (int) ceil(unrounded);
         return pages;
     }
}
