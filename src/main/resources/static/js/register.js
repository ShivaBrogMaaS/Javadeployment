function registerValid(){
	var name=document.getElementById("name").value;
	var pass=document.getElementById("password").value;
	var cp=document.getElementById("cp").value;
	var email=document.getElementById("email").value;
	var ce=document.getElementById("ce").value;
	var emailreg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	console.log(email.value);
	if(name==""||pass==""||email==""||ce==""||cp==""){
		alert("All the details are mandatory !!!");
		return false;
	}
    else if(email!=ce){alert("Email and Confirm Email Must be Same"); return false;}
	else if(emailreg.test(email)==false||emailreg.test(ce)==false){alert("Enter the Valid Email Id");return false; }
	else if(pass!=cp){alert("Password and Confirm Password Must be same"); return false;}
	else if(pass.length<4||cp.length<4){alert("Password must be greater than 4 Characters!!"); return false;}
	else { return true;}
}
