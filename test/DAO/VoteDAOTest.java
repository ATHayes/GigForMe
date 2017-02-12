/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.gigForMe.DAO.VoteDAOImpl;
import com.gigForMe.model.Vote;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author davidwalsh
 */
public class VoteDAOTest {
    
    public VoteDAOTest() {
    }

   @Test
    public static void testGet(){
        VoteDAOImpl cDAO = VoteDAOImpl.getInstance();
        Vote vote = cDAO.getVote(1);
        Assert.assertNotNull(vote);
    }
    
    @Test
    public static void testInsert(){
        VoteDAOImpl cDAO = VoteDAOImpl.getInstance();
        Vote vote = new Vote(1,1, "No");
        cDAO.insertVote(vote);
        vote = cDAO.getVote(1,1);
        Assert.assertNotNull(cDAO.getVote(vote.getBandID(),vote.getUserID()));
    }
    
    @Test
    public static void testModify(){
        VoteDAOImpl cDAO = VoteDAOImpl.getInstance();
        Vote vote = cDAO.getVote(1,1);
        vote.setVoted("No");
        cDAO.updateVote(vote);
        Assert.assertEquals(cDAO.getVote(vote.getVoteID()).getVoted(), "No");
    }
  

    

    @Test
     public static void testGetAll(){
         ArrayList<Vote> stockVotes;
         VoteDAOImpl aDAO = VoteDAOImpl.getInstance();
         ArrayList<Vote> allVotes = aDAO.getAllVotes();
         Assert.assertNotNull(allVotes.get(1));
         Assert.assertNotNull(allVotes.get(2));
     }
     
    @Test
    public static void testDelete(){
        VoteDAOImpl cDAO = VoteDAOImpl.getInstance();
        Vote vote = new Vote(1000,1000, "Yes");
        cDAO.insertVote(vote);
        cDAO.deleteVote(vote.getVoteID());
        Assert.assertNull(cDAO.getVote(vote.getVoteID()));
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
