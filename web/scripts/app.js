/* 
* Hamburger Menu for Fan Gig For Me pages
* 
* Used on all fan pages
* Source: http://bootsnipp.com/snippets/featured/fancy-sidebar-navigation
*/

//hamburger menu
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





/* 
* Vote Checkboxes
*
* Looks like a button, works like a checkbox
* When a change is made, an AJAX call is made to vote servlet
* Vote servlet will then update the database
* 
* Source: http://bootsnipp.com/snippets/featured/jquery-checkbox-buttons
*/
$(function () {
    $('.button-checkbox').each(function () {
       
        // Settings
        var $widget = $(this),
            $button = $widget.find('button'),
            $checkbox = $widget.find('input:checkbox'),
            color = $button.data('color'),
            settings = {
                on: {
                    icon: 'glyphicon glyphicon-check'
                },
                off: {
                    icon: 'glyphicon glyphicon-unchecked'
                }
            };

        // Event Handlers
        $button.on('click', function () {
            $checkbox.prop('checked', !$checkbox.is(':checked'));
            $checkbox.triggerHandler('change');
            updateDisplay();
            var $pID = $(this).attr('personid');
            var $bID = $(this).attr('bandid');
            
            var isChecked = $checkbox.is(':checked');
            if (isChecked) {
              // Asynchronous call to Vote Servlet - voted yes
                $.ajax({
                    type: 'Get',
                    url: 'VoteServlet',
                    data: {personID: $pID, bandID: $bID, voted: "Yes"}
                });
            }
            // Asynchronous call to Vote Servlet - voted no
            else {
                  $.ajax({
                    type: 'Get',
                    url: 'VoteServlet',
                    data: {personID: $pID, bandID: $bID, voted: "No"}
                });
            }
            
        });
        // Change the appearance of the button
        $checkbox.on('change', function () {
            updateDisplay();
        });

        // Change button state (voted or not voted)
        function updateDisplay() {
            var isChecked = $checkbox.is(':checked');

            // Set the button's state
            $button.data('state', (isChecked) ? "on" : "off");

            // Set the button's icon
            $button.find('.state-icon')
                .removeClass()
                .addClass('state-icon ' + settings[$button.data('state')].icon);

            // Update the button's color
            if (isChecked) {
                $button
                    .removeClass('btn-default')
                    .addClass('btn-' + color + ' active');
            
                    
            }
            else {
                $button
                    .removeClass('btn-' + color + ' active')
                    .addClass('btn-default');
                    
            }


        }

        // Initialization
        function init() {
            updateDisplay();
            // Inject the icon if applicable
            if ($button.find('.state-icon').length == 0) {
                $button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i> ');
            }
        }
        init();
    });
});