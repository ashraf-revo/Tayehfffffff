 function formValidation()  
{    
     
     var fname = document.myform.First_name; 
	 var lname = document.myform.Last_name;  
     var uadd = document.myform.address;   
     var uphone = document.myform.phone;  
     var uemail = document.myform.email;
	 var passid = document.myform.password;
	 var uage = document.myform.age;      
      
if(passid_validation(passid,7,12))  
{  
if(allLetter(fname))  
{  
if(alLetter(lname))  
{  
  
if(allnumeric(uphone))   
{ 
if(isnumeric(uage))  
{ 
if(ValidateEmail(uemail))  
{  
  
}  
}   
}  
}   
}  
   
  
return false;  
}  
 
function passid_validation(passid,mx,my)  
{  
var passid_len = passid.value.length;  
if (passid_len == 0 ||passid_len >= my || passid_len < mx)  
{  
alert("Password should not be empty / length be between "+mx+" to "+my);  
passid.focus();  
return false;  
}  
return true;  
}
function allLetter(fname)  
{   
var letters = /^[A-Za-z]+$/;  
if(uname.value.match(letters)||uname.value!="")  
{  
return true;  
}  
else  
{  
alert('your name must have alphabet characters only');  
uname.focus();  
return false;  
}  
function alLetter(lname)  
{   
var letters = /^[A-Za-z]+$/;  
if(uname.value.match(letters) ||lname.value!="")  
{  
return true;  
}  
else  
{  
alert('your name must have alphabet characters only');  
uname.focus();  
return false;  
}  
}  function ValidateEmail(uemail)  
{  
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
if(uemail.value.match(mailformat))  
{  
return true;  
}  
else  
{  
alert("You have entered an invalid email address!");  
uemail.focus();  
return false;  
}  
} 
function allnumeric(uphone)  
{   
var numbers = /^[0-9]+$/;  
if(uphone.value.match(numbers))  
{  
return true;  
}  
else  
{  
alert('your phone must have numeric characters only');  
uzip.focus();  
return false;  
} 
function isnumeric(uage)  
{   
var numbers = /^[0-9]+$/;  
if(uage.value.match(numbers))  
{  
return true;  
}  
else  
{  
alert('your age must have numeric characters only');  
uzip.focus();  
return false;  
}  
}   }}}