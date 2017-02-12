/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boxes;


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
import java.util.ArrayList;
import org.testng.annotations.Test;

/**
 *
 * @author anthonyhayes
 */
public class BandBoxTest {
    @Test
    public static void testGetBandBox(){
     BandDAO bandDAO = BandDAOImpl.getInstance();
     VoteDAO vDAO = VoteDAOImpl.getInstance();
     ArrayList<Band> allBandsList = bandDAO.getAllBands();
     ArrayList<BandBox> allBandBoxes = new ArrayList();
     PersonDAO pDAO = PersonDAOImpl.getInstance();
     Person thisPerson = pDAO.getUser(1);
 
     
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
           BandBox newBox = new BandBox(band, vote, thisPerson);
           allBandBoxes.add(newBox);
     }
    }
}
      
     
     
//       try{
//        //loop through comments, add that comment and user to the comment box
//        for (int i = 1; i <= 2; i++) {
//            //new variables every time - https://stackoverflow.com/questions/19843506/why-does-my-arraylist-contain-n-copies-of-the-last-item-added-to-the-list
//            BandBox tempBox = new BandBox();
//            Band tempBand = allCommentsForBand.get(i-1);
//            Person tempPerson = personDAO.getUser(tempComment.getUserID());
//            tempBox.setComment(tempComment);
//            tempBox.setPerson(tempPerson);
//            commentBoxes.add(tempBox);
//        }
//        
//       Assert.assertNotNull(commentBoxes.get(0));
//       Assert.assertNotNull(commentBoxes.get(1));
//        }
//        catch (Exception ex){
//           ex.printStackTrace(System.out);    
//        }
//    
//     for (BandBox b: allBandBoxes){
//         if (b.getVote() != null){
//             System.out.println(b.getBand().getBandname() + "and vote" );
//         }
//         else{
//             System.out.println(b.getBand().getBandname());
//         }
//     }
 

