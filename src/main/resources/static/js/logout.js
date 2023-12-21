function logout()
{
    var r= confirm ("Are you sure you what to logout");
    if(r==true)
    	{
    	    return true;
    	}
    else(r==false)
    {
    	return false;
    }
}


function  deleteClient()
{
var r= confirm ("Are you sure you what to delete");
if(r==true)
{
 return true;
}
else(r==false)
{
  return false;
}
}


function changePassword()
{
    var op = document.getElementById("oldpass1").value;
    var np = document.getElementById("newpass").value;
    var cp = document.getElementById("conpass").value;
    var oldpass = document.getElementById("oldpass").innerText;
    console.log(oldpass)
    console.log(op)
    if(op==""||np==""||cp=="")
    {
      alert("All the details are mandatory");
      return false;
       
    }
    else if(op!=oldpass)
    {
         alert("Old Password Does Not Match With Our Records!!!!");
         return false;
    }
    else if(op==np)
    {
      alert("The old password and new password must not be same!!!!");
      return false;
    }
    else if(np!=cp)
    {
       alert("New Password and Confirm Password must be same!!!");
       return false;
    }
    else 
    {
       alert("Password Updated Successfully Please Logout and Login !!!!! ");
       return true;
    }
    
    

}


function statePop()
{
 var x = document.getElementById("countryId").value;
$('#state1Id').empty();
$.ajax({
url: 'countryId/'+x,
dataType: "json", 
success: function(response) 
{   
getNumber(response,x);
}
});
function getNumber(id,name)
{
var tony=id;
$.ajax({
url: 'stateWithId/'+tony,
dataType: "json", 
success: function(response) 
{   
$.each(response, function(k, v) {
data='<option value="' + v.name + '">' + v.name + '</option>'
$(data).appendTo('#state1Id');
});
}
});
}
}
function getCity()
{
$('#cityId').empty();
var y = document.getElementById("state1Id").value;
$.ajax({
url: 'stateId/'+y,
dataType: "json", 
success: function(response) 
{   
console.log(response)
indhuma(response)
}
});
function indhuma(f)
{
console.log(f);
 $.ajax({
url: 'cityWithId/'+f,
dataType: "json", 
success: function(response) 
{   
console.log(response)
$.each(response, function(k, v) {
data='<option value="' + v.name + '">' + v.name + '</option>'
$(data).appendTo('#cityId');
});
}
});
}

}





$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});











