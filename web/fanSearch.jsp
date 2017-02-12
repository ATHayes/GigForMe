
<%@page import="com.gigForMe.utils.IConstants"%>
<%@page import="com.gigForMe.lang.Strings_Eng"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gig For Me - Search</title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/stylish-portfolio.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Angular.js -->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
        <script src="scripts/myApp.js"></script>
        <script src="scripts/managebands.js"></script>
  </head>

   <body id = "allBands">
        <div ng-app="myApp">
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
                            <small class = "hidden-xs"><%= Strings_Eng.STR_SEARCH%>  
                            </small>
                             
                            <small class = "hidden-xs float-right">
                                ${sessionScope.SKUSER.getFirstName()} ${sessionScope.SKUSER.getSurname()}
                            </small>

                        </h1>
                       
                   
                 <div ng-controller="MyController">
                    <div class ="row">
                        <div class ="col-lg-12">
                             <div class = "form-group">
                                  <label><%= Strings_Eng.STR_SEARCH_FOR_BAND%></label>
                                <input ng-model="searchText" class ="form-control" type = text></input>
                            </div>
                        </div>
                    </div>    
               
                <hr>
               
            
                    <table class="table table-hover" >
                        <thead>
                            <tr>
                                
                                <th><%= Strings_Eng.STR_BAND%></th>
                                <th><%= Strings_Eng.STR_VOTES%></th>
                                <th><%= Strings_Eng.STR_GENRE%></th>

                            </tr>
                        </thead>
                        <tbody>
                                <tr ng-repeat="b in bArray| filter:searchText">
                                    
                                    <td><a href="<%= IConstants.CONTEXT_PATH%><%= IConstants.SERVE_DETAILED_BAND_PAGE_BROWSING%>?bandID={{b.bandID}}">{{b.bandname}}</a> </td>
                                    <td>{{b.votes}}</td>
                                    <td>{{b.genre}}</td>
                                    
                                </tr>
                           

                        </tbody>
                    </table>

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

$(document).ready(function() {
    var trigger = $('.hamburger'),
    overlay = $('.overlay'),
    isClosed = false;
    trigger.click(function() {
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
    $('[data-toggle="offcanvas"]').click(function() {
        $('#wrapper').toggleClass('toggled');
    });
});

</script>
            
</body>

          
         
      

</html>
