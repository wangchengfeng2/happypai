/**
 * 
 */

$(document).ready(function() {


	$("#addBtn").click(function() {
		$("#mydiv").append("<br><input class='label_input' /><input class='input_input'  />");
	alert($(".input_input").prev().val());

	});
	
	$(".label_input").blur(function() {
		

	var name=$(".input_input").prev().val();
	$(".input_input").attr("name",name);  
	});

});
