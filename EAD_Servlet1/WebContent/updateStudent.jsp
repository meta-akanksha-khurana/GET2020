<%@ page import="java.sql.ResultSet"%>
<%@ page import="com.servlet.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update student details</title>
</head>
<body>
	<form id="studentRegistrationForm" action="updateStudent" method="post">
		<fieldset>
			<h2 id="registrationMessage">Edit Details</h2>
			<%
			Student student = (Student)request.getAttribute("student");
            %>

			<input id="firstName" type="text" name="FirstName"
				placeholder="First Name" value="<%=student.getFirstName()%>"
				required /></br> <input id="lastName" type="text" name="LastName"
				placeholder="Last Name" value="<%=student.getLastName()%>" required /></br>
			<input id="fatherName" type="text" name="FatherName"
				placeholder="Father Name" value="<%=student.getFatherName()%>"
				required /></br> <input id="emailId" type="email" name="Email"
				placeholder="e-mail Id" value="<%=student.getEmail()%>" readonly
				required /></br> <input id="classOfStudent" type="text" name="Class"
				placeholder="Enter Class" value="<%=student.getClassOfStudent()%>"
				required /></br> <input id="age" type="number" name="Age"
				placeholder="Enter Age" value="<%=student.getAge()%>" required /></br> <input
				id="submitButton" type="submit" value="Submit" />
		</fieldset>
	</form>

</body>
</html>