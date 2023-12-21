function taskValid()
{
	var name =document.getElementById("name").value;
	var pname =document.getElementById("projectname").value;
	var cname =document.getElementById("cname").value;
	var taskowner =document.getElementById("taskowner").value;
	var contactno =document.getElementById("contactno").value;
	var email =document.getElementById("email").value;
	var emailreg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	
    if(name==""||pname==""||cname==""||taskowner==""||contactno==""||email=="")
   {
    	alert("Please enter all the details");
    	return false;
   }
   else if(emailreg.test(email)==false)
   {
   alert("Enter the Valid Email Id");
   return false; 
   }
   else if(cname=="Select Client")
   {
    	alert("Please Select the client name");
    	return false;
    }
    else if(contactno.length>10||contactno.length<10)
    {
    	alert("Please Enter the Valid Contact Number");
    	return false;
    }
    
    else
    {
    	alert("Task Added created Sucessfully");
    	return true;
    }
}

 
function autoPop()
{
 var x = document.getElementById("taskowner").value;
if(x!="")
{
$.ajax({
url: 'podash2/'+x,
dataType: "json", 
async: true,
success: function(response) 
{    
document.getElementById("contactno").value = response;
}
});
$.ajax({
url: 'podash3/'+x,
async: true,
success: function(response) 
{    
document.getElementById("email").value = response;
}
});
}
else 
{
document.getElementById("contactno").value = "";
document.getElementById("email").value = "";
}
 
 }
 
 function showpopuptask(event) 
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
    var f3 = document.getElementById("projectname");
    var f4 = document.getElementById("cname");
    var f5 = document.getElementById("taskowner");
    var f6 = document.getElementById("contactno");
    var f7 = document.getElementById("email");

    f1.value = cells[0].innerHTML;
    f2.value = cells[1].innerHTML;
    f3.value = cells[2].innerHTML;
    f4.value = cells[3].innerHTML;
    f5.value = cells[4].innerHTML;
    f6.value = cells[5].innerHTML;
    f7.value = cells[6].innerHTML;
   
}
 
 
 
 
 
 
 
