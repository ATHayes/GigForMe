/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.gigForMe.DAO.BandDAOImpl;
import com.gigForMe.model.Band;
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
public class BandDAOTest{
    
    public BandDAOTest() {
    }
    
    @Test
    public static void testGet(){
        BandDAOImpl cDAO = BandDAOImpl.getInstance();
        Band band = cDAO.getBand(3);
        Assert.assertNotNull(band);
    }
    
    @Test
    public static void testInsert(){
        BandDAOImpl cDAO = BandDAOImpl.getInstance();
        Band band = new Band("S-Club 7", "Pop", "MEGA1234", "false", "defaultBand.jpg", "This record was created by the band unit test.", "Twitter_url");
        cDAO.insertBand(band);      
    }
    
    @Test
    public static void testModify(){
        BandDAOImpl cDAO = BandDAOImpl.getInstance();
        Band band = cDAO.getBand(3);
        // Save the old value for use after
        String name = band.getBandname();
        band.setBandname("test");
        cDAO.updateBand(band);
        Assert.assertEquals(cDAO.getBand(3).getBandname(), "test");
        band.setBandname(name);
        cDAO.updateBand(band);
    }
  

    

    @Test
     public static void testGetAll(){
         ArrayList<Band> stockBands;
         BandDAOImpl aDAO = BandDAOImpl.getInstance();
         ArrayList<Band> allBands = aDAO.getAllBands();
         String results = "";

         Assert.assertNotNull(allBands.get(1));
         Assert.assertNotNull(allBands.get(2));
     }
     
    @Test
    public static void testDelete(){
        BandDAOImpl cDAO = BandDAOImpl.getInstance();
        cDAO.deleteBand(37);
        Assert.assertNull(cDAO.getBand(37));
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
