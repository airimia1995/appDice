  'use strict';

    var ANGLE = {
        1: {
            x: -10,
            y: -10,
            z: 0
        },
        2: {
            x: -10,
            y: 260,
            z: 0
        },
        3: {
            x: 80,
            y: 0,
            z: 10
        },
        4: {
            x: 260,
            y: 0,
            z: -10
        },
        5: {
            x: 260,
            y: 0,
            z: 80
        },
        6: {
            x: -10,
            y: 170,
            z: 90
        }
    };

   
    var speed = 3000;
	var total = 0;
    var angleGenerator = function angleGenerator() {
        var factor = Math.floor(1 + Math.random() * 6);
        var _ANGLE$factor = ANGLE[factor];
        var x = _ANGLE$factor.x;
        var y = _ANGLE$factor.y;
        var z = _ANGLE$factor.z;
		total = total + factor;
        return {
            x: x + 3600,
            y: y + 3600,
            z: z + 3600
        };
    };

    var roll = function roll(list) {
    	var dices = Array.prototype.slice.call(document.querySelectorAll(list));
    	total = 0;
        dices.forEach(function (dice) {
            var _angleGenerator = angleGenerator();

            var x = _angleGenerator.x;
            var y = _angleGenerator.y;
            var z = _angleGenerator.z;

            dice.style.cssText = '\n            -webkit-transform: none;\n                    transform: none;\n        ';

            setTimeout(function () {
              
                dice.style.cssText = '\n                -webkit-transition-duration: ' + speed + 'ms;\n                        transition-duration: ' + speed/5 + 'ms;\n                -webkit-transform: rotateX(' + x + 'deg) rotateY(' + y + 'deg) rotateZ(' + z + 'deg);\n                        transform: rotateX(' + x + 'deg) rotateY(' + y + 'deg) rotateZ(' + z + 'deg);\n            ';
                
                }, 10);
            setTimeout(function () {
                
            }, 20);
        });
       
    };
    var user1Value;
    var user2Value;
    var modal = document.getElementById('myModal');
    var modal2 = document.getElementById('myModal2');
    function playGame(){
    	$('#win').attr("hidden", true);
    	$('#ctrl').attr("hidden", true);
    	
    	if(document.getElementById( 'status3' )) {
   		 $('#status3').text(" ");
   		 $('#status4').text(" ");
   		 $('#status5').text(" ");
   		
	
   	}
    	if(document.getElementById( 'error' )) {
      		 $('#error').text(" ");
   	
      	}
   	document.getElementById( 'status' ).innerHTML="";
   	document.getElementById( 'status2' ).innerHTML="";

    	
    	roll('.cubic');
    	   setTimeout(function () {
    		   document.getElementById( 'status' ).innerHTML = 'You rolled ' + total + '.';
           }, 700);
    	
    	user1Value = total;
    	setTimeout(function(){
    		roll('.cubic1');
    		   setTimeout(function () {
    	    		document.getElementById( 'status2' ).innerHTML = 'Computer rolled ' + total + '.';
               }, 700);
    		user2Value = total;
    		setTimeout(function () {
	    		
    			
    		if(user1Value > user2Value){
    			 $('#win').removeAttr('hidden');
    			modal.style.display = "block";
    			 document.getElementById( 'myModalContent' ).innerHTML="You won!"; 
        		}
    		else if(user1Value < user2Value){
    			
    			modal.style.display = "block";
   			 document.getElementById( 'myModalContent' ).innerHTML="Computer won!"; 
   			 
   			 }
    		else{
    			
    			modal.style.display = "block";
      			 document.getElementById( 'myModalContent' ).innerHTML="Equal";
      			 
        		}
    		$('#ctrl').attr("hidden", false);
    		
    		 }, 900);
    	var data = JSON.stringify({ 
            'userScore': user1Value,
            'computerScore':user2Value
          });
        
        $.ajax({
           
            type: "POST",
            url: "/",
            contentType: "application/json; charset=utf-8",
            data: data,
            processData:false,
            success: function(data) {},
            contentType: 'application/json'
          });
    	}, 1000);
    }
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
        if (event.target == modal2) {
            modal2.style.display = "none";
        }
    }

    $(document).ready(function() {
    	modal2.style.display = "block";
        $.active = false;
        $('body').bind('click keypress', function() { $.active = true; });
        checkActivity(60000, 2000, 0); 
    });

    function checkActivity(timeout, interval, elapsed) {
        if ($.active) {
            elapsed = 0;
            $.active = false;
           
        }
        if (elapsed < timeout) {
            elapsed += interval;
            setTimeout(function() {
                checkActivity(timeout, interval, elapsed);
            }, interval);
        } else {
        	
            window.location = '/logout';
            alert("You have been disconnected for timeout!!Reconnect to play again :)")
        }
    }

