<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.metacubeParking.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>
<%-- <%if (session.getAttribute("Id") == null) {
	String site = new String("Registration.jsp");
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", site);
	}%> --%>
	<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("id") == null) {
	response.sendRedirect("login.jsp");
	}
	else{%>
<form action="editEmployee" method="post">
<fieldset>
			<h2 id="registrationMessage">Edit Details</h2>
			<%
			Employee emp= (Employee)request.getAttribute("employee");
            %>

			<input id="empId" type="text" name="empId" value="<%=(emp.getEmployeeId()).toString() %>" hidden></br>
			<input id="Name" type="text" name="Name"
				placeholder="FullName" value="<%=emp.getName()%>"
				required /></br>
				<input id="Gender" type="text" name="Gender"
				placeholder="Gender" value="<%=emp.getGender()%>"
				required /></br>
			 <input id="emailId" type="email" name="Email"
				placeholder="e-mail Id" value="<%=emp.getEmail()%>" readonly
				required /></br> <input id="Password" type="password" name="Password"
				placeholder="Password" value="<%=emp.getPassword()%>"
				required /></br>
				<input id="Contact" type="text" name="Contact" value="<%=emp.getContact() %>"required/><br>
				<input id="Organization" type="text" name="Organization" value="<%=emp.getOrganization() %>"required/><br>
				<input id="submitButton" type="submit" value="Submit" />
				
		</fieldset>

</form>
<%} %>
</body>
</html>