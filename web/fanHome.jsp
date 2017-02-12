
<%@page import="com.gigForMe.utils.IConstants"%>
<%@page import="com.gigForMe.lang.Strings_Eng"%>
<%@page import="com.gigForMe.model.Person"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title><%= Strings_Eng.FAN_HOME_TITLE %></title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/stylish-portfolio.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    </head>

    <body id = "allBands">
        <div id="wrapper">
            <div class="overlay"></div>
            <!-- Sidebar -->
            <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
                <ul class="nav sidebar-nav">
                    <li class="sidebar-brand">
                        <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_FAN_HOME_PAGE %>" >
                            <%= Strings_Eng.APP_NAME%>
                        </a>
                    </li>
                    <li>
                        <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_FAN_HOME_PAGE%>"><%= Strings_Eng.FAN_MENU_HOME%></a>
                    </li>
                    <li>
                        <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_FAN_BAND_PAGE%>?page=1"><%= Strings_Eng.FAN_MENU_BANDS%></a>
                    </li>
                    <li>
                        <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.FAN_SEARCH_PAGE%>"><%= Strings_Eng.FAN_MENU_SEARCH%></a>
                    </li>
                    <li>
                        <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.LOGOUT_SERVLET%>"><%= Strings_Eng.FAN_MENU_LOGOUT%></a>
                    </li>

                </ul>
            </nav>
            <!-- /#sidebar-wrapper -->
            <div id="page-content-wrapper">
                <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                    <span class="hamb-top"></span>
                    <span class="hamb-middle"></span>
                    <span class="hamb-bottom"></span>
                </button>
                <div class = "visible-xs visible-sm">
                    <br/>
                    <br/>
                </div>
                <!-- Page Content -->
                <div class="container mainfeature">

                    <h1 class="page-header logo"><%= Strings_Eng.APP_NAME%>
                        <small class = "hidden-xs"><%= Strings_Eng.WELCOME%>
                        </small>

                        <small class = "hidden-xs float-right">
                            ${sessionScope.SKUSER.getFirstName()} ${sessionScope.SKUSER.getSurname()}
                        </small>

                    </h1>
                    <div class="row spaceontop">
                        <!-- Left column -->
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <!-- Left column first row-->
                            
                           
                            
                            <div class="row ">
                                <div class ="col-lg-1"></div>
                                <div class="col-lg-10">
                                   
                                    <div class="text-center">
                                         <p class ="lead"><%= Strings_Eng.BROWSE_DESC %></p>
                                        <a class="btn btn-lg btn-success" href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_FAN_BAND_PAGE%>?page=1" role="button">
                                            <span class="glyphicon glyphicon-picture" aria-hidden="true"></span> <%= Strings_Eng.BTN_BROWSE_BAND%></a>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Left column second row-->
                            <div class="row spaceontop"> 
                                <div class ="col-lg-1"></div>
                                <div class="col-lg-10">
                                    <div class="text-center">
                                         <p class ="lead"><%= Strings_Eng.SEARCH_DESC %></p>
                                        <a class="btn btn-lg btn-info" href="<%= IConstants.CONTEXT_PATH%><%= IConstants.FAN_SEARCH_PAGE%>" role="button">
                                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                             <%= Strings_Eng.BTN_SEARCH_BAND%></a>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Left column third row-->
                            <div class="row spaceontop">
                                <div class ="col-lg-1"></div>
                                <div class="col-lg-10">
                                    
                                </div>
                            </div>
                            <br>
                        </div>
                    <!-- Right column -->
                    <div class="col-lg-6 col-md-6 col-sm-12">
                        <div class="panel panel-default paddright">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-line-chart fa-fw"></i> <%= Strings_Eng.TOP_10_DESC %></h3>
                            </div>
                            <div class="panel-body">

                                <div class="list-group">
                                   <c:forEach items="${SKALLBANDS}" begin="0" end="9" var = "band"> 
                                            <a href="#" class="list-group-item">
                                                <span class="badge">Votes: ${band.votes}</span>
                                                <i class="fa fa-fw "></i> ${band.bandname}
                                            </a>
                                   </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>                        
                    </div>
               </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="scripts/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="scripts/bootstrap.js"></script>
    <!-- Custom Theme JavaScript -->
    <script>

        $(document).ready(function () {
            var trigger = $('.hamburger'),
                    overlay = $('.overlay'),
                    isClosed = false;
            trigger.click(function () {
                hamburger_cross();
            });
            function hamburger_cross() {
                if (isClosed == true) {
                    overlay.hide();
                    trigger.removeClass('is-open');
                    trigger.addClass('is-closed');
                    isClosed = false;
                } else {
                    overlay.show();
                    trigger.removeClass('is-closed');
                    trigger.addClass('is-open');
                    isClosed = true;
                }
            }
            $('[data-toggle="offcanvas"]').click(function () {
                $('#wrapper').toggleClass('toggled');
            });
        });

    </script>
</body>





</html>
