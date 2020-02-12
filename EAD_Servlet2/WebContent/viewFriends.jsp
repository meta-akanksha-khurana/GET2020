<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.metacubeParking.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="style.css"> -->
<style type="text/css">
table {

  border-collapse: collapse;
  width: 70%;
}

th, td {
  text-align: center;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>
<title>Insert title here</title>
</head>
<body>
<%
//response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("id") == null) {
response.sendRedirect("login.jsp");
}
else{
	
%>
<table border=1 align="center">
	<tr>
		<th>Employee Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Gender</th>
		<th>Contact</th>
		<th>Organization</th>
	</tr>

<%
List<Employee> friendsList=(ArrayList<Employee>)request.getAttribute("friends") ;
for(int i=0;i< friendsList.size();i++){
%>
<tr>
		<td><%=friendsList.get(i).getEmployeeId()%></td>
		<td><%=friendsList.get(i).getName()%></td>
		<td><%=friendsList.get(i).getEmail()%></td>
		<td><%=friendsList.get(i).getGender()%></td>
		<td><%=friendsList.get(i).getContact()%></td>
		<td><%=friendsList.get(i).getOrganization()%></td>
	</tr>
	<td><a href="showProfileServlet?empId=<%=friendsList.get(i).getEmployeeId()%>">Show Profile</a><br></td>



	<%
}
}	%>

</table>
</body>
</html>