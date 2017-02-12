
<%@page import="com.gigForMe.utils.IConstants"%>
<%@page import="com.gigForMe.lang.Strings_Eng"%>
<%@page import="com.gigForMe.model.Person"%>
<%@page import="com.gigForMe.model.Band"%>
<%@page import="com.gigForMe.model.Vote"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <title><%= Strings_Eng.FAN_BANDS_TITLE%></title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/stylish-portfolio.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <meta HTTP-EQUIV="expires" CONTENT="0">
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">

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
                    <!-- Page Header -->
                    <div class="row">
                        <div class="col-lg-12">
                          
                            <h1 class="page-header logo"><%= Strings_Eng.APP_NAME%>
                            <small><%= Strings_Eng.FAN_BANDS_DESC%>
                            </small>
                                
                            <small class = "float-right hidden-xs">
                                <% Person user = (Person)session.getAttribute(IConstants.SESSION_KEY_USER); %>
                                <%= user.getFirstName() %>
                                
                                <%= user.getSurname() %>
                            </small>
                            </h1>
                            
                        </div>
                    </div>
                   
                    <!-- /.row -->
                    <!-- Projects Row -->
                    <!--Parse the page number for use in calculations-->
                   <fmt:parseNumber var="pageNo" type="number" value="${SKPAGENO}" />
                   <!--set the page offset equal to the page number less one, by 9, so the first item of the second page would be number 9-->
                   <c:set var="pageOffset" scope="session" value="${(pageNo-1) *9}"/>
                   <!--source of loop: http://stackoverflow.com/questions/6099066/how-to-loop-over-something-a-specified-number-of-times-in-jstl-->
                    
                   <!--Loop for 3 rows, then loop 3 times in that row for each individual band -->
                   <!--Also offset for each page by 9. Yeah it's a complex loop -->
                   <c:forEach begin="0" end="2" varStatus="loop"> 
                    <div class="row">
                        <c:forEach items="${SKALLBANDBOXES}" begin="${(loop.index*3)+pageOffset}" end="${(loop.index *3)+2+pageOffset}" var="bandBox">
                        
                       <form role="form" action="FanBandServlet" method="POST">
                        <div class="col-sm-12 col-md-4 col-lg-4 portfolio-item ">
                             <!--pass this band's url to the detailed band page servlet-->
                            <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_DETAILED_BAND_PAGE_BROWSING %>?bandID=${bandBox.getBand().getBandID()}">
                                <img class="img-responsive" src="<%= IConstants.IMAGE_PATH%>${bandBox.getBand().getImgName()}" alt="">
                            </a>
                            <h3>
                            <!-- Pass this band's url to the detailed band page servlet-->
                            <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_DETAILED_BAND_PAGE_BROWSING %>?bandID=${bandBox.getBand().getBandID()}">
                                <c:out value="${bandBox.getBand().getBandname()}"/></a>
                            </h3>
                            <p><c:out value="${bandBox.getBand().getShortDescription()}"/></p>
                            <div class = "blockspan">
                            <span class="button-checkbox" >
                                  <button type="button" class="btn pull-right" data-color="success"
                                  bandid = "${bandBox.getBand().getBandID()}"
                                  personid = "${bandBox.getPerson().getUserID()}"
                                          ><%= Strings_Eng.BTN_VOTE%></button>
                                  <input type="checkbox" class="hidden"
                                         <c:if test = "${bandBox.getVote().getVoted() == 'Yes'}">checked</c:if>
                                  />  
                                  
                              </span>
                            </div>
                            
                        </div>
                        </form> 
                       <div class = "visible-xs visible-sm">
                           <br/>
                           <br/>
                           <hr>
                           <br/>
                           <br/>
                           
                       </div>    
                        </c:forEach>
                        <!--LOOOP HERE -->
                       
                    </div>
                   </c:forEach>
                   
                    <hr>
                    <!-- Pagination -->
                    <div class="row text-center">
                        <div class="col-lg-12">
                            <ul class="pagination">
                                <li>
                                    <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_FAN_BAND_PAGE%>?page=1">&laquo;</a>
                                </li>
                                <c:forEach begin="1" end="${SKNUMPAGES}" varStatus="loop"> 
                               <!--check if the current page number is active-->
                                <li class= "<c:if test="${SKPAGENO == loop.index}">active</c:if>">
                                    <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_FAN_BAND_PAGE%>?page=${loop.index}">${loop.index}</a>
                                </li>
                                
                                </c:forEach>
                                <li>
                                    <a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_FAN_BAND_PAGE%>?page=${SKNUMPAGES}">&raquo;</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
        
          <!--      <footer class = "indexfooter">
                <div class = "container indexfooter">
                   
                    <footer>
                        <div class="row">
                            <div class="col-lg-12">
                                <p>Copyright &copy; Your Website 2014</p>
                            </div>
                        </div>
                  
                    </footer>
                </div>
      
            </footer>
            </div> -->

            <!-- jQuery -->
            <script src="scripts/jquery.js"></script>
            <!-- Bootstrap Core JavaScript -->
            <script src="scripts/bootstrap.js"></script>
            <!-- Custom Theme JavaScript -->
            <script src ="scripts/app.js"</script>
            
            </script>
        </body>
    </html>