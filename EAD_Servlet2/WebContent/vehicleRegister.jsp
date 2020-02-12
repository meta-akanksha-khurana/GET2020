<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "com.metacubeParking.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css"></link>
    <script src="index.js">
    </script>
<title>Insert title here</title>
</head>
<body>
<div id="vehicleDiv">
<%/* Employee employee = (Employee)request.getAttribute("employee"); */

%>
        <form id="vehicleDetails" action="vehicleRegistration" method="post">
            <fieldset id="fieldset2">
                <legend><b>Vehicle Details</b></legend>
                <label>Vehicle Name <br/> <input id="vehicleName" type="text" placeholder="Vehicle Name" name="VehicleName" required ></label><br/>
                <label> Vehicle Type </label><br/> <select name="VehicleType" id="vehicleType">
                <option value="Cycle">Cycle</option>
                <option value="MotorCycle">MotorCycle</option>
                <option value="FourWheelers">Four Wheelers</option>
            </select></br>
                <label> Vehicle Number <br/> <input type="text" name="VehicleNumber" placeholder="Vehicle Number" ></label><br/>
                <label>Employee Id <br/> <input type="number" name="EmployeeId" placeholder="Employee Id" value="<%=session.getAttribute("empId")%>" readonly /></label><br/>
                <label>Identification <br/> <textarea placeholder="Identification" name="Identification"></textarea> </label><br/>
                <input type="submit" value="Next" >
            </fieldset>

        </form>
    </div><br><br>
</body>
</html>