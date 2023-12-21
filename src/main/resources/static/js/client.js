function clientValid()
{
	var cname=document.getElementById("name").value;
	var email=document.getElementById("email").value;
	var contactno=document.getElementById("contactno").value;
	var ponum=document.getElementById("ponum").value;
	var poamount=document.getElementById("poamount").value;
	var jobtitle=document.getElementById("jobtitle").value;
	var spoc=document.getElementById("spoc").value;
	var address=document.getElementById("address").value;
	var country=document.getElementById("countryId").value;
	var state=document.getElementById("stateId").value;
	var city=document.getElementById("cityId").value;
	var pincode=document.getElementById("pincode").value;
	var cintinno=document.getElementById("cintinno").value;
	var emailreg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var regx = /^[6-9]\d{9}$/ ;
	if(cname==""||email==""||contactno==""||ponum==""||jobtitle==""||spoc==""||address==""||country==""||state==""||city==""||pincode==""||cintinno=="")
	{
		alert(" Please fill all the details!!!! ");
		return false;
		
	}
	else if(contactno<0||ponum<0||poamount<0||pincode<0||cintinno<0)
	{
	   alert("Contact Number,Po Number,Po Amount ,Pincode, CINTIN No Cannot be Negative");
	   return false;
	}
	else if(emailreg.test(email)==false)
   {
   alert("Enter the Valid Email Id");
   return false; 
   }
	else if(contactno.length<10||contactno.length>10||regx.test(contactno)==false){
		alert("please Enter the valid Contact Number");
		return false;
	}
	
	else if(pincode.length>6||pincode.length<6){
		alert("Please enter the valid pincode");
		return false;
	}
	else if(country=="Select Country"||state=="Select State"||city=="Select City"){
		alert("Please Select Country ,state and City");
		return false;
	}
	else
	{
		alert("Client Added Sucessfully");
		return true;
	}
}




function showpopup(event) 
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
    var f3 = document.getElementById("email");
    var f4 = document.getElementById("contactno");
    var f5 = document.getElementById("ponum");
    var f6 = document.getElementById("poamount");
    var f7 = document.getElementById("jobtitle");
    var f8 = document.getElementById("spoc");
    var f9 = document.getElementById("address");
    var f10 =document.getElementById("countryId");
    var f11 =document.getElementById("stateId");
    var f12 =document.getElementById("cityId");
    var f13 =document.getElementById("pincode");
    var f14 =document.getElementById("cintinno");
 
    
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
   
}