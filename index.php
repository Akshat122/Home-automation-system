
﻿<!DOCTYPE html>
<!--TheFreeElectron 2015, http://www.instructables.com/member/TheFreeElectron/ -->

<html>
    <head>
        <meta charset="utf-8" />
        <title>Raspberry Pi Gpio</title>
    </head>
 
    <body style="background-color: Black;">
    <!-- On/Off button's picture -->
	<?php
	$val_array = array(0,0,0,0,0,0,0,0);
	//this php script generate the first page in function of the file
	for ( $i= 0; $i<8; $i++) {
		//set the pin's mode to output and read them
		system("gpio mode ".$i." out");
		exec ("gpio read ".$i, $val_array[$i], $return );
	}
	//for loop to read the value
	$i =0;
	for ($i = 0; $i < 8; $i++) {
		//if off
		if ($val_array[$i][0] == 0 ) {
			echo ("<img id='button_".$i."' src='data/img/red/red_".$i.".jpg' onclick='change_pin (".$i.");'/>");
		}
		//if on
		if ($val_array[$i][0] == 1 ) {
			echo ("<img id='button_".$i."' src='data/img/green/green_".$i.".jpg' onclick='change_pin (".$i.");'/>");
		}	 
	}
	exec("gpio mode 0 out");
exec("gpio mode 1 out");
exec("gpio mode 2 out");
exec("gpio mode 3 out");
exec("gpio mode 4 out");
exec("gpio mode 5 out");
exec("gpio mode 6 out");
exec("gpio mode 7 out");
exec("gpio mode 8 out");

if (isset($_GET['led1'])) {
        if($_GET['led1'] == 1) {
                exec("gpio write 0 1");// pin 0 in wiring pi is gpio 17
        } else {
                exec("gpio write 0 0");
        }
}
if(isset($_GET['led2'])) {
        if($_GET['led2'] == 1) {
                exec("gpio write 1 1");// pin 2 in wiring pi is gpio 27
        } else {
                exec("gpio write 1 0");
        }
}
if(isset($_GET['led3'])) {
        if($_GET['led3'] == 1) {
                exec("gpio write 2 1");// pin 2 in wiring pi is gpio 27
        } else {
                exec("gpio write 2 0");
        }
}
if(isset($_GET['led4'])) {
        if($_GET['led4'] == 1) {
                exec("gpio write 3 1");// pin 2 in wiring pi is gpio 27
        } else {
                exec("gpio write 3 0");
        }
}if(isset($_GET['led5'])) {
        if($_GET['led5'] == 1) {
                exec("gpio write 4 1");// pin 2 in wiring pi is gpio 27
        } else {
                exec("gpio write 4 0");
        }
}
if(isset($_GET['led6'])) {
        if($_GET['led6'] == 1) {
                exec("gpio write 5 1");// pin 2 in wiring pi is gpio 27
        } else {
                exec("gpio write 5 0");
        }
}
if(isset($_GET['led7'])) {
        if($_GET['led7'] == 1) {
                exec("gpio write 6 1");// pin 2 in wiring pi is gpio 27
        } else {
                exec("gpio write 6 0");
        }
}
if(isset($_GET['led8'])) {
        if($_GET['led8'] == 1) {
                exec("gpio write 7 1");// pin 2 in wiring pi is gpio 27
        } else {
                exec("gpio write 7 0");
        }
}
$url1=$_SERVER['http://192.168.1.6/'];
header("Refresh: 5; URL=$url1");
	?>
	 
	<!-- javascript -->
	<script src="script.js"></script>
    </body>
</html>
