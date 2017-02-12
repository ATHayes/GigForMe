/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author BEmerson
 */
public class SetupDb {

    Logger logger = Logger.getLogger(DBManager.class.getName());
    
//    void createTables() {
//        DBManager dmbgr = new DBManager();
//        Connection con = dmbgr.getConnection();
//    }
//
//    void insertSetupData() {
//        DBManager dmbgr = new DBManager();
//        Connection con = dmbgr.getConnection();  
//    }

    public void showData() {   
        Statement stmt;
        DBManager dmbgr = new DBManager();
        Connection con = dmbgr.getConnection();
        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("select * from USERDATA");
            //System.out.println("\n-------------------------------------------------");

            while (results.next()) {
                int id = results.getInt(1);
                String email = results.getString(2);
                String password = results.getString(3);
                String fName = results.getString(4);
                String lName = results.getString(5);
                String userType = results.getString(6);
                //logger.info(id + "\t\t" + email + "\t\t" + password + "\t\t" + fName + "\t\t" + lName + "\t\t" + userType);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            logger.log(Level.SEVERE, null,sqlExcept);
        }

        try {
            stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("select * from INSTRUMENTS");

            System.out.println("\n-------------------------------------------------");

            while (results.next()) {
                int id = results.getInt(1);
                String userName = results.getString(2);
                String fName = results.getString(1);
                String lName = results.getString(6);
                //logger.info(id + "\t\t" + userName + "\t\t" + fName + "\t\t" + lName);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            logger.log(Level.SEVERE, null,sqlExcept);
        }
    }
    
  

    public void executeSqlScript(Connection conn, File inputFile) {

        // Delimiter
        String delimiter = ";";

        // Create scanner
        Scanner scanner;
        try {
            scanner = new Scanner(inputFile).useDelimiter(delimiter);
        } catch (FileNotFoundException e1) {
            logger.log(Level.SEVERE, null, e1);
            return;
        }

        // Loop through the SQL file statements 
        Statement currentStatement = null;
        while (scanner.hasNext()) {

            // Get statement 
            String rawStatement = scanner.next();
            try {
                // Execute statement
                currentStatement = conn.createStatement();
                currentStatement.execute(rawStatement);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, null, e);
            } finally {
                // Release resources
                if (currentStatement != null) {
                    try {
                        currentStatement.close();
                    } catch (SQLException e) {
                        logger.log(Level.SEVERE, null, e);;
                    }
                }
                currentStatement = null;
            }
        }
    }

}
