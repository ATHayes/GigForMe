
<%@page import="com.gigForMe.utils.IConstants"%>
<%@page import="com.gigForMe.lang.Strings_Eng"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--        [if lt IE 9]>
                    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
                    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
                <![endif]-->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
        <script src="scripts/myApp.js"></script>
        
        <script src="scripts/myController.js"></script>
    </head>

    <body>
        <div ng-app="myApp">
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
                    <!--Drop down menu-->
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
                                    Users <small>Search, edit and add new users</small>
                                    <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.ADD_USER_PAGE%>" class="btn btn-success btn-lg pull-right">
                                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                        <%= Strings_Eng.BTN_ADD_USER%></a>
                                </h1>
                            </div>
                        </div>
                        <br>
                        <div ng-controller="MyController">
                            <div class ="row">
                                <div class ="col-lg-12">
                                    <div class = "form-group">
                                        <label>Search for User:</label>
                                        <input ng-model="searchText" class ="form-control" type = text></input>
                                    </div>
                                </div>
                            </div>    
                            <table class="table table-hover" >
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>DOB</th>
                                        <th>Gender</th>
                                        <th>Email</th>
                                        <th>Type</th>
                                    </tr>
                                </thead>
                                <tbody>
<!--                   
                                    <!--Angular.js ng-repeat - Like <c foreach> in JSTL, but done with javascript-->
                                    <tr ng-repeat="p in pArray| filter:searchText">
                                        <td scope="row">{{p.userID}}</td>
                                        <td>{{p.firstName}}</td>
                                        <td>{{p.surname}}</td>
                                        <td>{{p.DOB}}</td>
                                        <td>{{p.gender}}</td>
                                        <td>{{p.email}}</td>
                                        <td>{{p.auth}}</td>
                                        <td><a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_EDIT_USER_PAGE%>?userID={{p.userID}}">Edit</a> </td>
                                        <td>
                                        <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.DELETE_USER_SERVLET%>?userID={{p.userID}}" >
                                            <span class="glyphicon glyphicon-trash"></span> 
                                          </a>
                                        </td>
                                        
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /#page-wrapper -->
            </div>
            <!-- /#wrapper -->
        </div> 
        <!-- jQuery -->
        <script src="scripts/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="scripts/bootstrap.js"></script>
      
    </body>

</html>
