/* 
* Controller for the Admin Manage Bands page
*
* Gets all the bands with an AJAX (JSON) request on form load
* Puts this data on the scope
* This data can then be filtered on the client side using Angular
* (This is our search function)
*/
myApp.controller('MyController', function ($scope, $http) {
angular.element(document).ready(function () {
        refresh();
    });
 function refresh(){
     //alert("JS Works");
        $http({
            method: 'GET',
            url: 'GetAllBandsAJAXServlet'
        }).success(function (data, status, headers, config) {
            $scope.bArray = data;
            //alert("angular works");
        }).error(function (data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            alert("Ajax error - managebands.js");
        });
 }
   
});

