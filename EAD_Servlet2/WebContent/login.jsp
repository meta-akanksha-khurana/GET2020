<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="LoginServlet" method="post">
		<div class="login">
			<h1>METACUBE PARKING SYSTEM</h1>
			<fieldset>
				<legend>
					<b> Login </b>
				</legend>
				<form action="login" method="get">
					<input type="email" name="email" placeholder="Username"
						required="required" /> <input type="password" name="password"
						placeholder="Password" required="required" />
					<%
						if (request.getAttribute("message") != null) {
					%>
					<p class="login-error M0"><%=request.getAttribute("message")%></p>
					<%
						}
					%>
					<button type="submit" value="submit">Login</button>
				</form>
			</fieldset>
		</div>
	</form>
</body>
</html>