/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gigForMe.utils;

import static com.gigForMe.utils.IConstants.FAN_HOME_PAGE;
import java.util.ArrayList;

/**
*
 * @author bemerson
 */
public interface IConstants {
    // Turn JSP Filter authenticatation (page redirection) on or off
    // Authentication looks for "admin" or "user" in the url - will redirect to login if invalid user
    public static boolean AUTHORISATION = false;
    
    // Context path (the name of the application)
    // Change this if you decide to change the name of the application - it is appended to all servlet calls
//    public static final String CONTEXT_PATH = "/GigForMe";
    public static final String CONTEXT_PATH = "";
    // Users
    public static final String USER_TYPE_ADMIN = "ADMIN";
    public static final String USER_TYPE_GENERAL_USER = "FAN";
    public static final String DEFAULT_USER_IMG_NAME = "defaultUser.jpg";
    
    // Shared pages
    public static final String LOGIN_PAGE = "/login.html";
    public static final String REGISTER_PAGE = "/register.html";
    public static final String LOGOUT_SERVLET = "/LogOutServlet";
    
    // Fan web pages
    public static final String FAN_HOME_PAGE = "/fanHome.jsp";
    public static final String FAN_BAND_PAGE = "/fanBands.jsp";
    public static final String FAN_BAND_PAGE_DETAILED = "/fanBandDetailed.jsp";
    public static final String FAN_SEARCH_PAGE = "/fanSearch.jsp";
    public static final String FAN_PROFILE_PAGE = "/fanProfile.jsp";
    
    // Fan web page servlets
//    public static final String SERVE_FAN_BAND_PAGE = "/FanBandsServlet";
    public static final String SERVE_FAN_BAND_PAGE = "/FanBandsServlet";
    public static final String SERVE_FAN_HOME_PAGE = "/ServeFanHomePage";
    
    //Version of the detailed band page for browsing
    public static final String SERVE_DETAILED_BAND_PAGE_BROWSING = "/FanBandDetailedServlet";
    //Version of the detailed band page for search
    
    
    public static final String SERVE_ADMIN_PROFILE_PAGE = "/ServeAdminProfile";
    // Admin pages
    public static final String ADMIN_HOME_PAGE = "/adminHome.jsp";
    public static final String ADMIN_DASHBOARD_PAGE = "adminHome.jsp";
    public static final String ADMIN_HOME_PAGE_SERVLET = "DashboardServlet";
    public static final String MANAGE_BANDS_PAGE = "/adminManagebands.jsp";
    public static final String ADD_BAND_PAGE = "/adminAddBand.jsp";
    public static final String EDIT_BAND_PAGE = "/adminEditBand.jsp";
    public static final String ADD_USER_PAGE = "/adminAddUser.jsp";
    public static final String MANAGE_USERS_PAGE = "/adminManageusers.jsp";
    public static final String EDIT_USER_PAGE = "/adminEditUser.jsp";
    
    // "SERVE_X_Y" - servlet that gets information before displaying a particular page to the user
    public static final String SERVE_EDIT_USER_PAGE = "/ServeEditUserPage";
    public static final String SERVE_EDIT_BAND_PAGE = "/ServeEditBandPage";

    // Database Settings
    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    
    //Database Servlets
    public static final String DELETE_USER_SERVLET = "/DeleteUserServlet";
    public static final String DELETE_BAND_SERVLET = "/DeleteBandServlet";
    // File Paths

    public static final String IMAGE_PATH = "https://s3-eu-west-1.amazonaws.com/gigforme/images/";
    
    // Session Keys
    public static final String SESSION_KEY_USER = "SKUSER";
    public static final String SESSION_KEY_ALL_USERS = "SKALLUSERS";
    public static final String SESSION_KEY_ALL_BANDS = "SKALLBANDS";
    public static final String SESSION_KEY_THIS_BANDBOX = "SKTHISBANDBOX";
    public static final String SESSION_KEY_ALL_BANDBOXES = "SKALLBANDBOXES";
    public static final String SESSION_KEY_THIS_BAND = "SKTHISBAND";
    public static final String SESSION_KEY_BAND_COMMENTS = "SKBANDCOMMENTS";
    public static final String SESSION_KEY_COMMENT_BOXES = "SKCOMMENTBOXES";
    public static final String SESSION_KEY_PAGE_NO = "SKPAGENO";
    public static final String SESSION_KEY_THIS_PERSON ="SKTHISPERSON";
    
    // Console colours
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    // Session Keys
    public static final String VOTE_YES = "Yes";
    public static final String VOTE_NO = "No";
    
    // General
    public static final String SESSION_KEY_NUM_PAGES = "SKNUMPAGES";
    public static final String SESSION_KEY_NUM_COMMENTS = "SKNUMCOMMENTS";
    
    public static final String SESSION_KEY_All_BANDS = "SKALLBANDS";
    public static final String SESSION_KEY_NUM_FANS = "SKNUMFANS";
    public static final String SESSION_KEY_NUM_ADMINS = "SKNUMADMINS";
    public static final String SESSION_KEY_NUM_VOTES = "SKNUMVOTES";

}
