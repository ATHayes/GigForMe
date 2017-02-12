/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.utils;

import com.gigForMe.connection.ConnectionStrings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BEmerson
 */
public class DBManager {

    Logger logger = Logger.getLogger(DBManager.class.getName());

    void loadJDBCDriver() {
        try {
            Class.forName(IConstants.DB_DRIVER);
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    void checkConnection() {
        loadJDBCDriver();
        Connection dbConnection = null;
        String strUrl = ConnectionStrings.DB_URL;
        try {
            dbConnection = DriverManager.getConnection(strUrl);
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, null, sqle.getStackTrace());
        }
    }

    public Connection getConnection() {
        loadJDBCDriver();
        Connection dbConnection = null;
        String strUrl = ConnectionStrings.DB_URL;
        try {
//            dbConnection = DriverManager.getConnection(strUrl, IConstants.DB_USER, IConstants.DB_PASS);
            dbConnection = DriverManager.getConnection(strUrl, ConnectionStrings.DB_USER, ConnectionStrings.DB_PASS);
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, null, sqle.getStackTrace());
            System.out.println(sqle.getMessage());
            System.out.println("------nope");
        }
        return dbConnection;
    }

}
