
<%@page import="com.gigForMe.utils.IConstants"%>
<%@page import="com.gigForMe.lang.Strings_Eng"%>
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
        <!-- Angular.js scripts -->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
        <script src="scripts/myApp.js"></script>
        <script src="scripts/managebands.js"></script>
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
                        <!-- Page Heading -->
                        <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">
                                    Bands <small>Search, edit and add new bands</small>
                                    <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.ADD_BAND_PAGE%>" class="btn btn-primary btn-lg pull-right">
                                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                        Add New Band</a>
                                </h1>
                            </div>
                        </div>

                        <br>
                        <div ng-controller="MyController">
                            <div class ="row">
                                <div class ="col-lg-12">
                                    <div class = "form-group">
                                        <label>Search for Band:</label>
                                        <input ng-model="searchText" class ="form-control" type = text></input>
                                    </div>
                                </div>
                            </div>    

                            <table class="table table-hover" >
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Band Name</th>
                                        <th>Total Votes</th>
                                        <th>Genre</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr ng-repeat="b in bArray| filter:searchText">
                                        <td scope="row">{{b.bandID}}</td>
                                        <td>{{b.bandname}}</td>
                                        <td>{{b.votes}}</td>
                                        <td>{{b.genre}}</td>
                                        <td>{{b.email}}</td>
                                        <td><a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_EDIT_BAND_PAGE%>?bandID={{b.bandID}}">Edit band</a> </td>
                                        <td> 
                                        <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.DELETE_BAND_SERVLET%>?bandID={{b.bandID}}" >
                                            <span class="glyphicon glyphicon-trash"></span> 
                                          </a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div><!-- /#page-wrapper -->
            </div><!-- /#wrapper -->
        </div> <!-- myApp -->
                        
        <!-- jQuery -->
        <script src="scripts/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="scripts/bootstrap.js"></script>

    </body>

</html>
