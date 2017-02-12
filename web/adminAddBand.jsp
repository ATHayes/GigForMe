
<%@page import="java.util.ArrayList"%>
<%@page import="com.gigForMe.utils.IConstants"%>
<%@page import="com.gigForMe.lang.Strings_Eng"%>
<%@page import="com.gigForMe.model.Person"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Gig For Me - Admin</title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href = "css/stylish-portfolio.css" rel = "stylesheet">
        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts  TESTO-->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div id="wrapper">
            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                     <a class="navbar-brand logo" href="<%= IConstants.CONTEXT_PATH%><%= IConstants.ADMIN_HOME_PAGE%>"><%= Strings_Eng.APP_NAME%></a>
                </div>
                <!-- Top Menu Items -->
                <ul class="collapse navbar-collapse nav navbar-right top-nav">
                    <li>
                        <a href='<%= IConstants.CONTEXT_PATH%><%= IConstants.ADMIN_HOME_PAGE%>'><%= Strings_Eng.ADMIN_MENU_HOME%></a>
                    </li>
                    <li>
                        <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.MANAGE_BANDS_PAGE%>"><%= Strings_Eng.ADMIN_MENU_BANDS%></a>
                    </li>
                    <li>
                        <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.MANAGE_USERS_PAGE%>"><%= Strings_Eng.ADMIN_MENU_USERS%></a>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${sessionScope.SKUSER.getFirstName()} ${sessionScope.SKUSER.getSurname()}<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_EDIT_USER_PAGE%>?userID=${sessionScope.SKUSER.getUserID()}"><i class="fa fa-fw fa-user"></i> Profile</a>
                            </li>
                            <li>
                                <a href="https://mail.google.com"><i class="fa fa-fw fa-envelope"></i> <%= Strings_Eng.ADMIN_MENU_INBOX%></a>
                            </li>
                            <!--  <li>
                                 <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                             </li> -->
                            <li class="divider"></li>
                            <li>
                                <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.LOGOUT_SERVLET%>">
                                    <i class="fa fa-fw fa-power-off"></i> <%= Strings_Eng.ADMIN_MENU_LOGOUT%>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>

            <div id="page-wrapper">
      <!-- Page Content -->
                <div class="container mainfeature adminprofile">
                   <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">
                                    <%= Strings_Eng.BTN_ADD_BAND %>
                                    <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.MANAGE_BANDS_PAGE%>" class="btn btn-primary btn-lg pull-right">
                                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                        <%= Strings_Eng.BTN_BACK_TO_SEARCH %></a>
                                </h1>

                            </div>
                        </div>
             
                    <br>

                    <div class="col-lg-12 well">
                        <div class="row">
                           
                            <form id="signupform" data-parsley-validate="" action="AddBandServlet" method="POST">
                               
                                <div class="col-lg-6">
                                    <div class="row">

                                        <div class="col-lg-12 form-group">
                                    <!--INSERT INTO BAND(BANDNAME, GENRE, EMAIL, CANCELLED, IMG_NAME, DESCRIPTION, TWITTER_URL)-->
                                            <label>Band Name</label>
                                            <input type="text" placeholder="Enter Band Name Here.." class="form-control" name="bandname"
                                                   data-parsley-required="true" data-parsley-maxlength="20" data-parsley-type="alphanum">
                                        </div>
                                    </div> 
                                    <div class="row">
                                        <div class="col-lg-12 form-group">
                                            <label>Genre</label>
                                            <input type="text" placeholder="Enter Genre Here.." class="form-control" name="genre"
                                                   data-parsley-required="true" data-parsley-maxlength="15"data-parsley-type="alphanum">
                                        </div>
                                    </div>  

                                   
                                    <div class =" row">
                                    <div class="col-lg-12 form-group">
                                        <label>Email Address</label>
                                        <input type="text" placeholder="Enter Email Address Here.." class="form-control" name="email"
                                               data-parsley-required="true" data-parsley-maxlength="50" data-parsley-type="email">
                                    </div> 
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-lg-12 form-group">
                                            <label>Description</label>
                                            <textarea rows = "7" placeholder="Enter Description Here.." class="form-control" name="description"
                                                      data-parsley-required="true" data-parsley-maxlength="250" data-parsley-minlength="6" data-parsley-type="alphanum"></textarea>
                                        </div> 
                                    </div>  
                                    <div class="row">
                                        <div class="col-lg-12 form-group">
                                            <label>Twitter Data-Widget-ID</label>
                                            <input type="text" placeholder="Enter Twitter Data-Widget-ID Here.." class="form-control" name="dataWidgetID"
                                                   data-parsley-required="true" data-parsley-maxlength="20" >
                                        </div> 
                                    </div>  
                                    <input type="submit" class="btn btn-default text-center" value="Submit"/>
                                    
                                </div>
                            </form> 
                            
                            <div class ="col-lg-6">
                                            <a href="#">
                                                  <img class="img-responsive" src="images/defaultBand.jpg" alt="">
                                                 </a>
                                <p>Image uploads are not supported in this version. Each new band will be given the default Gig For Me image shown above.</p>
                                        </div>
                        </div>
                    </div>


                </div>
            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="scripts/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="scripts/bootstrap.js"></script>

        <!-- Morris Charts JavaScript -->
        <script src="scripts/plugins/morris/raphael.min.js"></script>
        <script src="scripts/plugins/morris/morris.min.js"></script>
        <script src="scripts/plugins/morris/morris-data.js"></script>

    </body>

</html>
