function validation(){
	if(!nameValidation()){
		return false;
	} else if(!emailValidation(document.signupform)){
		return false;
	} else if(!passwordValidation(document.signupform)){
		return false;
	} else if(!confirmPasswordValidation()){
		return false;
	} else if(!contactValidation()){
		return false;
	} else if(document.signupform.Company.value == "None"){
		alert("Select Company");
		document.signupform.Company.focus();
		return false;
	}
	return true;
}

function loginValidation(){
	if(!emailValidation(document.loginForm)){
		return false;
	} else if(!passwordValidation(document.loginForm)){
		return false;
	}
	return true;
}

function nameValidation(){
	var myform = document.signupform;
	var inputAplphabets = /^[A-Za-z]+$/;
	if(myform.firstName.value.length < 2){
		alert("First Name should be atleast of 2 characters");
		myform.firstName.focus();
		return false;
	}  else if(!myform.firstName.value.match(inputAplphabets)){
		alert("First Name should only contain Alphabets");
		myform.firstName.focus();
		return false;
	} else if(myform.lastName.value.length < 2){
		alert("Last Name should be atleast of 2 characters");
		myform.lastName.focus();
		return false;
	} else if(!myform.lastName.value.match(inputAplphabets)){
		alert("Last Name should only contain Alphabets");
		myform.lastName.focus();
		return false;
	}
	return true;
}

function emailValidation(myform){
	var myEmail = myform.email;
	var noOfAt = myEmail.value.indexOf("@");
	var noOfDot = myEmail.value.lastIndexOf(".");
	if(noOfAt < 1 || noOfDot - noOfAt < 2){
		alert("Enter Valid EmailId");
		myEmail.focus();
		return false;
	} else if(myEmail.value.length - noOfDot < 2){
		alert("Enter Valid EmailId");
		myEmail.focus();
		return false;
	} else if(myEmail.value.length < 6){
		alert("Enter Valid EmailId");
		myEmail.focus();
		return false;
	}
	return true;
}

function passwordValidation(myform){
	var myPassword = myform.password;
	if(!/[a-z]/.test(myPassword.value)){
		alert("Password should contain atleast one LowerCase Alphabet");
		myPassword.focus();
		return false;
	} else if(!/[A-Z]/.test(myPassword.value)){
		alert("Password should contain atleast one UpperCase Alphabet");
		myPassword.focus();
		return false;
	} else if(!/[0-9]/.test(myPassword.value)){
		alert("Password should contain atleast one Numeric Character");
		myPassword.focus();
		return false;
	} else if(myPassword.value.length < 8){
		alert("Password should contain atleast 8 characters");
		myPassword.focus();
		return false;
	}
	return true;
}

function confirmPasswordValidation(){
	if(document.signupform.password.value != document.signupform.confirmPassword.value){
		alert("Confirm Password should match Password");
		document.signupform.confirmPassword.focus();
		return false;
	}
	return true;
}

function contactValidation(){
	var myContact = document.signupform.contact;
	if(myContact.value.length < 8){
		alert("Contact No. should be of atleast length 8");
		myContact.focus();
		return false;
	}
	return true;
}