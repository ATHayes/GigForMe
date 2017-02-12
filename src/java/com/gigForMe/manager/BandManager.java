/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.manager;

import com.gigForMe.DAO.BandDAOImpl;
import com.gigForMe.DAO.VoteDAOImpl;
import com.gigForMe.model.Band;
import com.gigForMe.model.Vote;

import java.util.ArrayList;

/**
 * The Manager (or Service) class for Bands
 * @author anthonyhayes
 */
public class BandManager {
     private static BandManager instance = new BandManager();

   //make the constructor private so that this class cannot be
   //instantiated
   private BandManager(){}
   BandDAOImpl bDAO = BandDAOImpl.getInstance();
   //Get the only object available

    /**
     * Singleton - Returns the single instance of BandManager.
     * @return
     */
       public static BandManager getInstance(){
      return instance;
   }    

    /**
     * Returns an ArrayList of all Band Objects in the database
     * @return
     */
    public ArrayList<Band> getAllBands(){
         //get all the bands
         
         ArrayList<Band> allBands = bDAO.getAllBands();
         //get all the votes
         VoteDAOImpl vDAO = VoteDAOImpl.getInstance();
         ArrayList<Vote> allVotes = vDAO.getAllVotes();
         
         //assign votes to band
         for (Band b: allBands){
             for (Vote v: allVotes){
                 if (b.getBandID() == v.getBandID() && v.getVoted().toUpperCase().equals("YES")){
                     b.setVotes(b.getVotes() + 1);
                 }
             }
         }
         
      
        
        return allBands;
    }

    /**
     * Updates the Band object
     * @param band
     */
    public void updateBand(Band band) {
        bDAO.updateBand(band);
    }

    public void insertBand(Band band) {
        bDAO.insertBand(band);
    }

    public void deleteBand(Integer bandID) {
        bDAO.deleteBand(bandID);
    }

//    public ArrayList<Band> getAllBandsForUser(Person person) {
//        ArrayList<Band> allBands = getAllBands();
//        ArrayList<BandBox> allBandBoxes = BandBoxManager.convertToBoxList(allBands, person);
//        ArrayList 
//        for (BandBox bb: allBandBoxes){
//            if (bb.getVote().getUserID().equals(person.getUserID())){
//                
//            }
//        }
//        
//        return bandsForUser;
//    }
}
