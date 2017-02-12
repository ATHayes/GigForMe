/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.DAO;

import com.gigForMe.model.Person;
import java.util.ArrayList;

/**
 *
 * @author anthonyhayes
 */
public interface PersonDAO {
   public ArrayList<Person> getAllUsers();
   public Person getUser(int personID);
   public Person getUserByEmail(String email);
   public void insertUser(Person person);
   public void updateUser(Person person);
   public void deleteUser(int personID);
}
