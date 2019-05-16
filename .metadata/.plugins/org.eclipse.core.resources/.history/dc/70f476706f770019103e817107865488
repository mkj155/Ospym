$(document).ready(function() {
	if($("#idFormAutorizacion").length) {
		hideAllTabs();
		showTab(currentTab); // Display the current tab
		$("#FieldsRequired").hide();
		
		$('select').click(function() {
			$("#FieldsRequired").hide();
		})
	}
});

var currentTab = 0; // Current tab is set to be the first tab (0)

function showTab(n) {
	  // This function will display the specified tab of the form ...
	  var x = document.getElementsByClassName("tab");
	  x[n].style.display = "block";
}

function hideAllTabs() {
	var x = document.getElementsByClassName("tab");
	for(var i = 0; i < x.length; i++) {
		x[i].style.display = "none";
	}
}
	
function nextPrev(n) {
	// This function will figure out which tab to display
	var x = document.getElementsByClassName("tab");
	// Exit the function if any field in the current tab is invalid:
	if (n == 1 && !validateForm()) return false;
	// Hide the current tab:
	x[currentTab].style.display = "none";
	// Increase or decrease the current tab by 1:
	currentTab = currentTab + n;
	// if you have reached the end of the form... :
	if (currentTab >= x.length) {
		//...the form gets submitted:
		document.getElementById("regForm").submit();
    	return false;
	}

	// Otherwise, display the correct tab:
	showTab(currentTab);
}

function validateForm() {
	// This function deals with validation of the form fields
	var x, y, z, i, valid = true;
	x = document.getElementsByClassName("tab");
	y = x[currentTab].getElementsByTagName("input");
	z = x[currentTab].getElementsByTagName("select");
	// A loop that checks every input field in the current tab:
	for (i = 0; i < y.length; i++) {
		// If a field is empty...
		if (y[i].value == "") {
			// add an "invalid" class to the field:
			y[i].className += " invalid";
			
			// and set the current valid status to false:
			valid = false;
		}
	}
	
	for (i = 0; i < z.length; i++) {
		// If a field is empty...
		if (z[i].value == "") {
			// add an "invalid" class to the field:
			z[i].className += " invalid";
			
			// and set the current valid status to false:
			valid = false;
		}
	}
	
	if(!valid) {
		$("#FieldsRequired").show();
	}
		
	return valid; // return the valid status
}