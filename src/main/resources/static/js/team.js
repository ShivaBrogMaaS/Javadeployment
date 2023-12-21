function  teamValid(){
	var name=document.getElementById("name").value;
	var email=document.getElementById("email").value;
	var phoneNo=document.getElementById("phoneNo").value;
	var gender=document.getElementById("gender").value;
	var qualification=document.getElementById("qualification").value;
	var designation=document.getElementById("designation").value;
	var department=document.getElementById("department").value;
	var address=document.getElementById("address").value;
	var country=document.getElementById("countryId").value;
	var state=document.getElementById("stateId").value;
	var city=document.getElementById("cityId").value;
	var reportingManager=document.getElementById("reportingManager").value;
	var skills=document.getElementById("skills").value;
	var experience=document.getElementById("experience").value;
	var mhr=document.getElementById("mhr").value;
	var idproof=document.getElementById("idproof").value;
	var emailreg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var regx = /^[6-9]\d{9}$/ ;
	if(name==""||email==""||qualification==""||designation==""||department==""||address==""||country==""||state==""||city==""||reportingManager==""||skills==""||experience==""
			||mhr==""||idproof==""){
		
		alert("Please fill all the details");
		return false;
	
	}
	else if(emailreg.test(email)==false)
   {
   alert("Enter the Valid Email Id");
   return false; 
   }
	else if(gender=="Select Gender"){
		alert("Please select the gender");
		return false;
	}
	else if (phoneNo.length>10||phoneNo.length<10||regx.test(phoneNo)==false){
		alert("Enter the Valid Phone Number");
		return false;
	}
	else if (country=="Select Country"||state=="Select State"||city=="Select City"){
		alert("Please Select Country ,State and City ");
		return false;
	}
	else
	{
		alert("Team Memeber Added Sucessfully");
		return true;
	}
}

function showpopupteam(event) 
{
	
document.getElementById("exampleModalLong").style.display = "block";
event = event || window.event; 
var target = event.target || event.srcElement;
while (target && target.nodeName != 'TR') 
{ 
target = target.parentElement;
}
var cells = target.cells; //cell collection 
if (!cells.length || target.parentNode.nodeName == 'THEAD') 
{
return;
}
    
    var f1=  document.getElementById("id");
    var f2 = document.getElementById("name");
    var f3 = document.getElementById("phoneNo");
    var f4 = document.getElementById("email");
    var f5 = document.getElementById("gender");
    var f6 = document.getElementById("qualification");
    var f7 = document.getElementById("designation");
    var f8 = document.getElementById("address");
    var f9 = document.getElementById("department");
    var f10 =document.getElementById("countryId");
    var f11 =document.getElementById("stateId");
    var f12 =document.getElementById("cityId");
    var f13 =document.getElementById("reportingManager");
    var f14 =document.getElementById("skills");
    var f15 =document.getElementById("experience");
    var f16 =document.getElementById("mhr");
    var f17 =document.getElementById("idproof");   
    f1.value = cells[0].innerHTML;
    f2.value = cells[1].innerHTML;
    f3.value = cells[2].innerHTML;
    f4.value = cells[3].innerHTML;
    f5.value = cells[4].innerHTML;
    f6.value = cells[5].innerHTML;
    f7.value = cells[6].innerHTML;
    f8.value = cells[7].innerHTML;
    f9.value = cells[8].innerHTML;
    f10.value = cells[9].innerHTML;
    f11.value = cells[10].innerHTML;
    f12.value = cells[11].innerHTML;
    f13.value = cells[12].innerHTML;
    f14.value = cells[13].innerHTML;
    f15.value = cells[14].innerHTML;
    f16.value = cells[15].innerHTML;
    f17.value = cells[16].innerHTML;

   
}


