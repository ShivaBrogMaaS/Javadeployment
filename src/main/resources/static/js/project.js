function projectValid(){
	var name =document.getElementById("name").value;
	var prodes =document.getElementById("projectDesc").value;
	var cname =document.getElementById("cname").value;
	var cspoc =document.getElementById("clientspoc").value;
	var intspoc =document.getElementById("internalspoc").value;
	var ponum =document.getElementById("ponum").value;
	var noofemp =document.getElementById("noofemployee").value;
	var promang =document.getElementById("Access").value;
	var startdate =document.getElementById("projectstartDate").value;
	var enddate =document.getElementById("projectExpEndDate").value;
	var teammem =document.getElementById("teamname").value;
    if(name==""||prodes==""||cname==""||cspoc==""||intspoc==""||ponum==""||noofemp==""||promang==""||startdate==""||enddate==""||teammem=="")
  {
    	alert("Please enter all the details");
    	return false;
   }
    
    else if(startdate==enddate){
    	alert("Start date and End date cannot be same");
    	return false;
    }
    else if(noofemp<0)
    {
      alert("No of Employees Cannot be Negative!!!");
      return false;
    }
    else{
    	alert("Project created Sucessfully");
    	return true;
    }


}

//To disable the Previous date...
$(function(){
    var dtToday = new Date();
    console.log(dtToday);
    var month = dtToday.getMonth()+1 ;
    console.log(month)
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    var maxDate = year + '-' + month + '-' + day;
    $('#projectstartDate').attr('min', maxDate);
});
$(function(){
    var dtToday = new Date();
    console.log(dtToday);
    var month = dtToday.getMonth()+1 ;
    console.log(month)
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    var maxDate = year + '-' + month + '-' + day;
    $('#projectExpEndDate').attr('min', maxDate);
});



function poNumber()
{
var x = document.getElementById("cname").value;
if(x!="")
{
$.ajax({
url: 'podash/'+x,
dataType: "json", 
async: true,
success: function(response) 
{    
document.getElementById("ponum").value = response;
}
});
$.ajax({
url: 'podash1/'+x,
async: true,
success: function(response) 
{    
document.getElementById("clientspoc").value = response;
}
});
}
else 
{
document.getElementById("ponum").value = "";
document.getElementById("clientspoc").value = "";
}
}



function showpopupproject(event) 
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
    var f3 = document.getElementById("projectDesc");
    var f4 = document.getElementById("cname");
    var f5 = document.getElementById("clientspoc");
    var f6 = document.getElementById("internalspoc");
    var f7 = document.getElementById("ponum");
    var f8 = document.getElementById("noofemployee");
    var f9 = document.getElementById("Access");
    var f10 =document.getElementById("projectstartDate1");
    var f11 =document.getElementById("projectExpEndDate2");
    var f12 =document.getElementById("teamname");

 
    
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

   
}













