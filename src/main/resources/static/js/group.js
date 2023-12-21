function groupValid(){
	
	var grpname=document.getElementById("name").value;
	var mem=document.getElementById("mem").value;
	if(grpname==""){
		alert("Enter the group name");
		return false;
		
	}
	else if(mem==""){
		alert("Please add Atleast one Member to the Group !!!");
		return false;
	}
	else 
	{
		alert("Group created sucessfully");
		return true;
	}
}

function showpopupgroup(event) 
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
    var f3 = document.getElementById("mem");
   
    
    f1.value = cells[0].innerHTML;
    f2.value = cells[1].innerHTML;
    f3.value = cells[2].innerHTML;
  
     
}