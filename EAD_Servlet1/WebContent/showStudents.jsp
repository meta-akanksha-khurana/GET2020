<%@page import="java.sql.*"%>
<%@page import="com.servlet.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>


<%
		//System.out.println("status is:"+request.getParameter("status"));
		if(Integer.parseInt(request.getParameter("status")) == 1){
		%>
<tr>

	<th>
		<form action="searchByClassController" method="post">
			<label>Filter Class</label> <select name="classOfStudent">
				<%
						for (int i = 1; i <= 12; i++) {
					%>
				<option value="<%=i%>"><%=i%></option>
				<%
						}
					%>
			</select> <input type="submit" value="Filter" />
		</form>
	</th>
</tr>
<%
		}
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
List<Student> rs = (ArrayList<Student>)request.getAttribute("listStudent");

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
	<td><a href="updateStudentServlet?email=<%=rs.get(i).getEmail()%>">Update</a><br></td>



	<%
}
	%>

</table>
