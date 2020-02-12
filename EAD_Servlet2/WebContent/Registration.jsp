<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<script>
function register(){
	var name = document.getElementById('empName');
	    var regex = /^[a-zA-Z ]{2,30}$/;
	    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	    var pass = /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/;
	    var phoneno = /^[0-9]{10}$/;
	    var email = document.getElementById("emailId").value;
	    var password = document.getElementById("pswd").value;
	    var confirmPassword = document.getElementById("confirmPswd").value;
	    var contact = document.getElementById("contact").value;
	    var flag = true;
	    if (!regex.test(name.value)) {
	        document.getElementById("comment").innerHTML = "<span>Name should be correct.<span>";
	        flag = false;
	    }
	    if (!emailPattern.test(email)) {
	        document.getElementById("comment1").innerHTML = "<span>Email should be correct.<span>";
	        flag = false;
	    }
	    if (!pass.test(password)) {
	        document.getElementById("comment2").innerHTML = "<span>Password should be in correct format.<span>";
	        flag = false;
	    }
	    if (!phoneno.test(contact)) {
	        document.getElementById("comment3").innerHTML = "<span>Contact should be in correct format.<span>";
	        flag = false;
	    }
	    if (confirmPassword != password) {
	        document.getElementById("comment4").innerHTML = "<span> Password is not same!Enter again.<span>";
	        flag = false;
	    }

	    return flag;
	}

</script>
<title>Registration form</title>
</head>
<body>
	<center>
		<h1>Metacube Parking System</h1>
	</center>
	<div>
		<form id="empRegistrationForm" action="register" method="post" >

			<fieldset id="fieldset1">

				<legend>
					<b> Employee Registration Form </b>
				</legend>


				<label> Name <br /> <input id="empName" type="text"
					name="Name" placeholder="Name" required>
				</label><br /> 
				<span id="comment" style="color: red;"></span><br>
				<label>Gender <br /> <input type="radio" name="Gender" value="Male" required>Male
				 <input	type="radio" name="Gender" value="Female" required>Female
				</label><br /> 
				<label>Email <br /> <input type="email" name="Email" placeholder="Email Id" id="emailId" required>
				</label><br /> 
				<span id="comment1" style="color: red;"></span><br> 
				<label> Password <br /> <input type="password" name="Password"
					placeholder="Password" id="pswd" required>
				</label><br />
				 <span id="comment2" style="color: red;"></span><br> 
				 <label> Confirm Password <br /> <input type="password"
					placeholder="Confirm Password" id="confirmPswd" required>
				</label><br />
				 <span id="comment4" style="color: red;"></span><br>
				<label> Contact Number <br /> <input type="text" name="Contact"
					placeholder="Contact Number" id="contact" required>
				</label><br />
			    <span id="comment3" style="color: red;"></span><br>
				<label>Organization</label><br> <select name="Organization" id="org">
					<option disabled selected>Select organization</option>
					<option value="Metacube">Metacube</option>
					<option value="Infosys">Infosys</option>
					<option value="IntimeTec">IntimeTec</option>
					<option value="Mtx">Mtx</option>
				</select><br>
				 <input type="submit" value="Next" onclick="return register()"> 
				 <a href="login.jsp" > <input type="button"
					value="Login"   ></a>

			</fieldset>
		</form>
	</div>
</body>
</html>