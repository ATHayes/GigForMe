/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.DAO;

import com.gigForMe.model.Vote;
import java.util.ArrayList;

/**
 *
 * @author anthonyhayes
 */
public interface VoteDAO {
   public ArrayList<Vote> getAllVotes();
   public Vote getVote(int voteID);
   public Vote getVote(int userID, int bandID);
   public void insertVote(Vote vote);
   public void updateVote(Vote vote);
   public void deleteVote(int voteID);
}
