
<%@page import="com.gigForMe.model.CommentBox"%>
<%@page import="com.gigForMe.utils.IConstants"%>
<%@page import="com.gigForMe.lang.Strings_Eng"%>
<%@page import="com.gigForMe.model.Person"%>
<%@page import="com.gigForMe.model.Band"%>
<%@page import="com.gigForMe.model.Vote"%>
<%@page import="com.gigForMe.model.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Gig For Me - Performer</title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/stylish-portfolio.css" rel="stylesheet">
        <link href="css/performance.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
   

    </head>
    <body id = "allBands">
        
        <!-- Modal Dialog for comments-->
        <div id="mod" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <form role="form" action="CommentOnBand" method="POST">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title"><%= Strings_Eng.COMMENT_DESC%>${sessionScope.SKTHISBAND.getBandname()}</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="comment"><%= Strings_Eng.COMMENT_COLON%></label>
                                <textarea class="form-control" rows="5" id="comment" name="content"></textarea>
                            </div>
                        </div>
                        <input type="hidden" name="bandID" value="${sessionScope.SKTHISBAND.getBandID()}" />
                        <div class="modal-footer">
                            <button class="btn btn-default" data-dismiss="modal"><%= Strings_Eng.BTN_BACK%></button>
                            <button class="btn btn-success" type="submit"><%= Strings_Eng.BTN_SUBMIT%></button>
                        </div>

                    </div>
                </form>

            </div>
        </div>
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
                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header logo"><%= Strings_Eng.APP_NAME%>

                                <small>
                                    ${sessionScope.SKTHISBAND.getBandname()}
                                </small> 
                                <small class = "hidden-xs float-right">
                                    ${sessionScope.SKUSER.getFirstName()} ${sessionScope.SKUSER.getSurname()}
                                </small>
                            </h1>  
                        </div>
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-md-7">
                            <a href="#">
                                <img class="img-responsive" src="<%= IConstants.IMAGE_PATH%>${sessionScope.SKTHISBAND.getImgName()}" alt="">
                            </a>
                        </div>
                        <div class="col-md-5">
                            <h3>${sessionScope.SKTHISBAND.getBandname()}</h3>
                            <p>${sessionScope.SKTHISBAND.getDescription()}</p>


                            <span class="button-checkbox">
                                <button type="button" class="btn" data-color="success"
                                        bandid = "${sessionScope.SKTHISBAND.getBandID()}"
                                        personid = "${sessionScope.SKUSER.getUserID()}"
                                        ><%= Strings_Eng.BTN_VOTE%></button>
                                <input type="checkbox" class="hidden"
                                       <c:if test = "${sessionScope.SKTHISBANDBOX.getVote().getVoted() == 'Yes'}">checked</c:if>
                                           />  

                                </span>
                                <br/>
                                <br/>
                                <a href = "<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_FAN_BAND_PAGE%>?page=1" 
                                   type="button" class="btn btn-default " 
                                   role = "button"> 
                                    <span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>
                                    <%= Strings_Eng.BTN_BACK_TO_BANDS %></a>  

                            </div>
                        </div>
                        <!-- /.row -->
                        <hr>
                        <div class="container">  
                            <div class="row">
                                <div class="col-md-6">
                                    <h3><%= Strings_Eng.COMMENT_PLURAL%>
                                        <button type="button" class="btn btn-info pull-right" data-toggle="modal" data-target="#mod">
                                             <span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
                                             <%= Strings_Eng.BTN_COMMENT%></button>

                                    </h3>
                                    <br>
                                    
                                <c:forEach items="${SKCOMMENTBOXES}" var="commentBox" end ="20">
                                    <div class="row">
                                        
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <div class="panel panel-default">
                                                <div class="panel-heading">
                                                    <strong>
                                                        <c:out value="${commentBox.getPerson().getFirstName()} ${commentBox.getPerson().getSurname()}"/>
                                                    </strong> <span class="text-muted"></span>
                                                </div>
                                                <div class="panel-body">
                                                    <p>${commentBox.getComment().getContent()}</p>

                                                </div><!-- /panel-body -->
                                            </div><!-- /panel panel-default -->
                                        </div>
                                    </div>
                                </c:forEach>
                                <!-- Trigger the comment modal dialog with a button -->
                                <!--                                <form action="FanBandsServlet" method="GET">
                                                                    <button class="btn btn-success" type="submit">Submit</button>
                                                                </form>-->
                            </div><!-- end comments -->
                            <!--Twitter-->
                            <div class= "col-md-6">
                                <a class="twitter-timeline" 
                                   data-widget-id="${sessionScope.SKTHISBAND.getTwitterUrl()}"></a>
                                <!--twitter-->
                                   <script>!function (d, s, id) {
                                        var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/.test(d.location) ?
                                                'http' : 'https';
                                        if (!d.getElementById(id)) {
                                            js = d.createElement(s);
                                            js.id = id;
                                            js.src = p + "://platform.twitter.com/widgets.js";
                                            fjs.parentNode.insertBefore(js, fjs);
                                        }
                                    }(document, "script", "twitter-wjs");</script> 
                            </div>   
                        </div><!-- /row -->

                        <!-- Footer -->
                        <footer>
                            <!-- /.row -->
                        </footer>
                    </div>
                </div>
            </div>
        
        </div>
        <!-- jQuery -->
        <script src="scripts/jquery.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="scripts/bootstrap.js"></script>
        <script src = "scripts/app.js"></script>
        
    </body>
</html>