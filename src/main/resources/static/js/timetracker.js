function timetrackerValid()
{
var name =document.getElementById("name").value;
var cname =document.getElementById("cname").value;
var taskname =document.getElementById("taskname").value;
var description =document.getElementById("description").value;
var startdate =document.getElementById("startdate").value;
var enddate =document.getElementById("enddate").value;
var emplyeedetail =document.getElementById("emplyeedetail").value;
var dtt1=document.getElementById("sdt").value;
var dtt2=document.getElementById("sedt").value;
var dt1= new Date(startdate);
var dt2=new Date(enddate);
diff_hours(dt1, dt2);
if(name==""||cname==""||taskname==""||description==""||startdate==""||enddate==""||emplyeedetail=="")
{
alert("Enter the All the Details !!!");
return false;
}
else if(cname=="Select Client")
{
alert("Please select the client");
return false;
}
else if(startdate<dtt1||startdate>dtt2)
{
   alert("StartDate and End date should be within the project deadline");
   return false;	    
}
else if(enddate<dtt1||enddate>dtt2)
{
 alert("StartDate and End date should be within the project deadline");
 return false;
}
else 
{
alert("Time Tracker Added sucessfully");
return true;
}
}
function diff_hours(dt2, dt1) 
 {

  var diff =(dt2.getTime() - dt1.getTime()) / 1000;
  diff /= (60 * 60);
  document.getElementById("totaltime").value = Math.abs(Math.round(diff));
  
 }


function dateValidation()
{
var x = document.getElementById("name").value;
if(x!="")
{
$.ajax({
url: 'dash/'+x, 
async: true,
success: function(response) 
{    
var orgdate=response;
console.log(orgdate);
document.getElementById("sdt").value = orgdate;
}
});
$.ajax({
url: 'dash1/'+x, 
async: true,
success: function(response) 
{    
var orgenddate=response
console.log(orgenddate);
document.getElementById("sedt").value = orgenddate;
}
});
}
else 
{
document.getElementById("sdt").value = "";
document.getElementById("sedt").value = "";
}
}

function showpopuptime(event) 
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
    var f3 = document.getElementById("cname");
    var f4 = document.getElementById("taskname");
    var f5 = document.getElementById("description");
    var f6 = document.getElementById("startdate");
    var f7 = document.getElementById("enddate");
    var f8 = document.getElementById("emplyeedetail"); 
    f1.value = cells[0].innerHTML;
    f2.value = cells[1].innerHTML;
    f3.value = cells[2].innerHTML;
    f4.value = cells[3].innerHTML;
    f5.value = cells[4].innerHTML;
    f6.value = cells[5].innerHTML;
    f7.value = cells[6].innerHTML;
    f8.value = cells[7].innerHTML;


   
}


