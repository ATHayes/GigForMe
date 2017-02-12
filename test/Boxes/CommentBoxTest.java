/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boxes;

import com.gigForMe.DAO.BandDAOImpl;
import com.gigForMe.DAO.CommentDAOImpl;
import com.gigForMe.DAO.PersonDAOImpl;
import com.gigForMe.model.Band;
import com.gigForMe.model.Comment;
import com.gigForMe.model.CommentBox;
import com.gigForMe.model.Person;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author anthonyhayes
 */
public class CommentBoxTest {
    
    public CommentBoxTest() {
  
    }
    @Test
    public static void CommentBox(){
          
        BandDAOImpl bandDAO = BandDAOImpl.getInstance();
        PersonDAOImpl personDAO = PersonDAOImpl.getInstance();
        CommentDAOImpl commentDAO = CommentDAOImpl.getInstance();
        
        // get the band from the parameter bandID
        String bandID = "1";
        Band band = bandDAO.getBand(Integer.valueOf(bandID));
        
        //Array list for comment and comment boxes
        ArrayList<Comment> allCommentsForBand = commentDAO.getAllBandComments(band);
        ArrayList<CommentBox> commentBoxes = new ArrayList<>();
        
        System.out.println(allCommentsForBand.size());
        try{
        //loop through comments, add that comment and user to the comment box
        for (int i = 1; i <= 2; i++) {
            //new variables every time - https://stackoverflow.com/questions/19843506/why-does-my-arraylist-contain-n-copies-of-the-last-item-added-to-the-list
            CommentBox tempBox = new CommentBox();
            Comment tempComment = allCommentsForBand.get(i-1);
            Person tempPerson = personDAO.getUser(tempComment.getUserID());
            tempBox.setComment(tempComment);
            tempBox.setPerson(tempPerson);
            commentBoxes.add(tempBox);
        }
        
       Assert.assertNotNull(commentBoxes.get(0));
       Assert.assertNotNull(commentBoxes.get(1));
        }
        catch (Exception ex){
           ex.printStackTrace(System.out);    
        }
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
