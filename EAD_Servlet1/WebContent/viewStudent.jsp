<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Request Details</h1>
		<div>
			<%
			ResultSet rs = (ResultSet)request.getAttribute("students");
			if(!rs.next()) {
		%>
			<div
				class="no-result-div dflex-align-item-center dflex-justify-content-center">No
				Student Found</div>
			<% 
			} else {
			rs.beforeFirst();
			while(rs.next()) {
		%>
			<div>
				<div class="request-item-info-container">
					<div class="request-label-info-container dflex">

						<div class="dflex-align-item-center">
							<label class="form-label">First Name :</label> <span
								class="info-val"><%=rs.getString("firstName") %></span>
						</div>
					</div>

					<div class="request-label-info-container dflex">
						<div class="dflex-align-item-center">
							<label class="form-label">Last Name :</label> <span
								class="info-val"><%=rs.getString("lastName") %></span>
						</div>

						<div class="dflex-align-item-center">
							<label class="form-label">Father Name :</label> <span
								class="info-val"><%=rs.getString("fatherName") %></span>
						</div>
					</div>

					<div class="request-label-info-container dflex">
						<div class="dflex-align-item-center">
							<label class="form-label">Email :</label> <span class="info-val"><%=rs.getString("email") %></span>
						</div>
						<div class="dflex-align-item-center">
							<label class="form-label">Class :</label> <span class="info-val"><%=rs.getString("class") %></span>
						</div>

						<div class="dflex-align-item-center">
							<label class="form-label">Age :</label> <span class="info-val"><%=rs.getString("Age") %></span>
						</div>
					</div>
				</div>

			</div>
			<%
					}
			}
				%>
		</div>
	</div>

</body>
</html>