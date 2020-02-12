<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.metacubeParking.Employee" %>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
form{
	padding:10%;
	padding-bottom: 3%
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

tr:hover {background-color:#f5f5f5;}

#b1{
margin:0px 600px;
}
</style>
<title>Insert title here</title>
</head>
<body>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
/*response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0"); */
if(session.getAttribute("id") == null) {
response.sendRedirect("login.jsp");
}
else{

Employee emp=(Employee)request.getAttribute("employee");
	if(emp==null)
	{
%>
<div
	class="no-result-div dflex-align-item-center dflex-justify-content-center">No
	Employee Found</div>
<%
}
	else{
		%>
		<div class="v1">
		<form>
		<fieldset>
		<table>
		
		<tr>
		<th>Name:</th>
		<td><%=emp.getName() %></td>
		</tr>
		
		<tr>
		<th>Gender:</th>
		<td><%=emp.getGender() %></td>
		</tr>
		
		<tr>
		<th>Email Id:</th>
		<td><%=emp.getEmail() %></td>
		</tr>
		
		<tr>
		<th>Password:</th>
		<td><%=emp.getPassword() %></td>
		</tr>
		
		<tr>
		<th>Contact:</th>
		<td><%= emp.getContact()%></td>
		</tr>
		
		<tr>
		<th>Organization:</th>
		<td><%=emp.getOrganization() %></td>
		</tr>
		</table>
		</fieldset>
		</form>
		<div id="b1">
		<a href="EditEmployeeServlet"><input type="button" value="Edit"></a>
		<a href="FriendsServlet?empId=<%=emp.getEmployeeId()%>&organization=<%=emp.getOrganization()%>"><input type="button" value="Friends"></a> 
		</div>
		<a href="LogOutServlet" > <button class="btn btn-primary" style="position: absolute;left: 70%;top:10%;">Logout</button> </a><br>
		
		</div> 
	     
		<%
		}
}
	%>
		
	
</body>
</html>