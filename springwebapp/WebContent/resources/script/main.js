/**
 * 
 */

function onLoad(){
	
	$("#confirmpassword").keyup(checkMatch);
	
	$("#details").submit(canSubmit);
	
	
}

function canSubmit(){
	var password = $("#password").val();
	var confirmpassword = $("#confirmpassword").val();
	if(password != confirmpassword){
		alert("Password do not match");
		return false;
	}else {
		return true;
	}
}

function checkMatch(){
	var password = $("#password").val();
	var confirmpassword = $("#confirmpassword").val();
	if(confirmpassword.length > 1){
	if(password == confirmpassword){
		$("#matchpass").text("Password Matches");
		$("#matchpass").addClass("valid");
		$("#matchpass").removeClass("error");
	}else {
		$("#matchpass").text("Password do not macth");
		$("#matchpass").addClass("error");
		$("#matchpass").removeClass("valid");
	}
}
}
$(document).ready(onLoad);