<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.metacubeParking.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
form{
	padding:10%;
}
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
<%

	Employee employee=(Employee)request.getAttribute("employee");

if(employee==null)
	{
%>
<div
	class="no-result-div dflex-align-item-center dflex-justify-content-center">No
	Employee Found</div>
<%
}
	else{
		%>
		<%-- <label>Name:<%=employee.getName() %></label><br>
		<label>Employee Id:<%=employee.getEmployeeId() %></label><br>
		<label>Gender:<%=employee.getGender() %></label><br>
		<label>Email Id:<%=employee.getEmail() %></label><br>
		<label>Password:<%=employee.getPassword() %></label><br>
		<label>Contact:<%= employee.getContact()%></label><br>
		<label>Organization:<%=employee.getOrganization() %></label><br>
		<!-- <a href ="viewFriends.jsp" ><input type="button" value="Back"></a> --> --%>
		
		<div class="v1">
		<form>
		<fieldset>
		<table>
		
		<tr>
		<th>Name:</th>
		<td><%=employee.getName() %></td>
		</tr>
		
		<tr>
		<th>Gender:</th>
		<td><%=employee.getGender() %></td>
		</tr>
		
		<tr>
		<th>Email Id:</th>
		<td><%=employee.getEmail() %></td>
		</tr>
		
		<tr>
		<th>Password:</th>
		<td><%=employee.getPassword() %></td>
		</tr>
		
		<tr>
		<th>Contact:</th>
		<td><%= employee.getContact()%></td>
		</tr>
		
		<tr>
		<th>Organization:</th>
		<td><%=employee.getOrganization() %></td>
		</tr>
		</table>
<%}

	%>
		
</body>
</html>