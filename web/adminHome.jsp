
<%@page import="com.gigForMe.utils.IConstants"%>
<%@page import="com.gigForMe.lang.Strings_Eng"%>
<%@page import="com.gigForMe.model.Person"%>
<%@page import="com.gigForMe.model.Band"%>
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

        <!-- Angular Charts CSS -->
        <link href="css/angular-chart.css" rel="stylesheet">

        <!-- Custom Fonts -->
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
                <div class="container ">
                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                <%= Strings_Eng.STR_DASHBOARD%> <small><%= Strings_Eng.DASHBOARD_DESC%> </small>
                            </h1>
                            <br>
                            <ol class="breadcrumb">
                                <li class="active">
                                    <i class="fa fa-line-chart"></i> <%= Strings_Eng.STR_STATISTICS%>
                                </li>
                            </ol>
                        </div>
                    </div>
                    <!-- /.row -->



                    <div class="row">

                        <div class="col-lg-3 col-md-6">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <i class="fa fa-users fa-5x"></i>
                                        </div>
                                        <div class="col-xs-9 text-right">
                                            <div class="huge">${sessionScope.SKNUMFANS}</div>
                                            <div><%= Strings_Eng.STR_TOTAL_FANS%></div>
                                        </div>
                                    </div>
                                </div>
                                <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.MANAGE_USERS_PAGE%>">
                                    <div class="panel-footer">
                                        <span class="pull-left"><%= Strings_Eng.STR_VIEW_DETAILS%></span>
                                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="panel panel-yellow">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <i class="fa fa-gavel fa-5x"></i>
                                        </div>
                                        <div class="col-xs-9 text-right">
                                            <div class="huge">${sessionScope.SKNUMADMINS}</div>
                                            <div>Total Admins</div>
                                        </div>
                                    </div>
                                </div>
                                <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.MANAGE_USERS_PAGE%>">
                                    <div class="panel-footer">
                                        <span class="pull-left"><%= Strings_Eng.STR_VIEW_DETAILS%></span>
                                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                            </div>

                        </div>

                        <div class="col-lg-3 col-md-6">
                            <div class="panel panel-red">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <i class="fa fa-star fa-5x"></i>
                                        </div>
                                        <div class="col-xs-9 text-right">
                                            <div class="huge">${sessionScope.SKALLBANDS.size()}</div>
                                            <div>Total Bands</div>
                                        </div>
                                    </div>
                                </div>
                                <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.MANAGE_BANDS_PAGE%>">
                                    <div class="panel-footer">
                                        <span class="pull-left"><%= Strings_Eng.STR_VIEW_DETAILS%></span>
                                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="panel panel-green">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <i class="fa fa-thumbs-up fa-5x"></i>
                                        </div>
                                        <div class="col-xs-9 text-right">
                                            <div class="huge">${sessionScope.SKNUMVOTES}</div>
                                            <div>Total Votes Made</div>
                                        </div>
                                    </div>
                                </div>
                                <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.MANAGE_BANDS_PAGE%>">
                                    <div class="panel-footer">
                                        <span class="pull-left"><%= Strings_Eng.STR_VIEW_DETAILS%></span>
                                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                            </div>

                        </div>



                    </div>
                    <!-- /.row -->

                    <div class="padd">

                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><i class="fa fa-list fa-fw"></i> Most Popular Bands</h3>
                                </div>
                                <div class="panel-body row">
                                  
                                    <div class="list-group col-lg-4">
                                        <c:forEach items="${SKALLBANDS}" begin="0" end="9" var = "band"> 
                                            <a href="#" class="list-group-item">
                                                <span class="badge">${band.votes}</span>
                                                <i class="fa fa-fw "></i> ${band.bandname}
                                            </a>
                                        </c:forEach>
                                    </div>
                                     <div class="list-group col-lg-4">
                                        <c:forEach items="${SKALLBANDS}" begin="10" end="19" var = "band"> 
                                            <a href="#" class="list-group-item">
                                                <span class="badge">${band.votes}</span>
                                                <i class="fa fa-fw "></i> ${band.bandname}
                                            </a>
                                        </c:forEach>
                                    </div>
                                     <div class="list-group col-lg-4">
                                        <c:forEach items="${SKALLBANDS}" begin="20" end="29" var = "band"> 
                                            <a href="#" class="list-group-item">
                                                <span class="badge">${band.votes}</span>
                                                <i class="fa fa-fw "></i> ${band.bandname}
                                            </a>
                                        </c:forEach>
                                    </div>
                                 
                                </div>

                            </div>
                        </div>
                        

                        <!-- /.row -->

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- /#page-wrapper -->

            </div>
            <!-- /#wrapper -->

     
            <!-- jQuery -->
            <script src="scripts/jquery.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="scripts/bootstrap.js"></script>

            <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
            <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
            <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

            
    </body>

</html>
