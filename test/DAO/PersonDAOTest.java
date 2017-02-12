/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.gigForMe.DAO.PersonDAOImpl;
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
 * @author davidwalsh
 */
public class PersonDAOTest {
    
//    public PersonDAOTest() {
//    }
    
    @Test
    public static void testGet(){
        PersonDAOImpl cDAO = PersonDAOImpl.getInstance();
        Person person = cDAO.getUser(3);
        Assert.assertNotNull(person);
    }
    
    @Test
    public static void testInsert(){
        PersonDAOImpl cDAO = PersonDAOImpl.getInstance();
        Person person = new Person(
            "David",   //firstName
            "Walsh",   //surname
            "22/08/1994",   //DOB
            "Male",   //gender
            "123@345.COM",  //email
            "14/11/2015",  //signUpDate
            "Eagles",  //username 
            "mypassword",   //password
            "FAN",//permission 
             1,   //bandid
            "imagename"   //imgname
        );
        cDAO.insertUser(person);
        int pNo = cDAO.getUserByEmail(person.getEmail()).getUserID();
        //test each individual value
        Assert.assertEquals(cDAO.getUser(pNo).getGender(), person.getGender());
        Assert.assertEquals(cDAO.getUser(pNo).getUsername(), person.getUsername());
        Assert.assertEquals(cDAO.getUser(pNo).getEmail(),person.getEmail());
    }
    
    @Test
    public static void testModify(){
        PersonDAOImpl cDAO = PersonDAOImpl.getInstance();
        Person person = cDAO.getUser(3);
        //save the old value for use after
        String name = person.getUsername();
        person.setUsername("test");
        cDAO.updateUser(person);
        Assert.assertEquals(cDAO.getUser(3).getUsername(), "test");
        person.setUsername(name);
        cDAO.updateUser(person);
    }
  

    @Test
     public static void testGetAll(){
         ArrayList<Person> stockPersons;
         PersonDAOImpl aDAO = PersonDAOImpl.getInstance();
         ArrayList<Person> allPersons = aDAO.getAllUsers();
         String results = "";

         Assert.assertNotNull(allPersons.get(1));
         Assert.assertNotNull(allPersons.get(2));
     }
     
    @Test
    public static void testDelete(){
        PersonDAOImpl cDAO = PersonDAOImpl.getInstance();
        cDAO.deleteUser(5);
        Assert.assertNull(cDAO.getUser(5));
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
