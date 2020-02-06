<%@page import="java.sql.*"%>
<%@page import="com.servlet.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>





<%
List<Student> rs = (ArrayList<Student>)request.getAttribute("students");
if(rs.size()==0){
	%>
<div
	class="no-result-div dflex-align-item-center dflex-justify-content-center">No
	Student Found</div>
<% 
}
else{
	%>
<table border=1>
	<tr>
		<th>FirstName</th>
		<th>LastName</th>
		<th>FatherName</th>
		<th>Email</th>
		<th>Class</th>
		<th>Age</th>
	</tr>
	<% 
for(int i=0;i< rs.size();i++){
	
    %>

	<tr>
		<td><%=rs.get(i).getFirstName()%></td>
		<td><%=rs.get(i).getLastName()%></td>
		<td><%=rs.get(i).getFatherName()%></td>
		<td><%=rs.get(i).getEmail()%></td>
		<td><%=rs.get(i).getClassOfStudent()%></td>
		<td><%=rs.get(i).getAge()%></td>
	</tr>



	<%
}
}
	%>

</table>
