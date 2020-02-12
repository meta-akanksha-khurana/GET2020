<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.metacubeParking.Vehicle" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
 <!-- <script src="index.js">
    </script> --> 
    <!-- <script language="JavaScript" type="text/JavaScript" src="../script/index.js"></script> -->
    <script>
    var currencyType = "INR";
    var price = [
        [5, 100, 500],
        [10, 200, 1000],
        [20, 500, 3500]
    ];
    var RATE = 1;
    var USD_RATE = 0.014;
    var YEN_RATE = 1.53;
    var vehicleType1;
    var vehicleType2;
    var selectedTypeRate = 1;
    var priceDaily;
    var priceMonthly;
    var priceYearly;
    var priceD;
    var priceM;
    var priceY;

   <%--  vehicleType1="<%=session.getAttribute("vehicleType")%>"; --%>
   function selectVehicleType() {
   vehicleType1=document.getElementById("vehicleType").value;
    if (vehicleType1 == "Cycle") {
        vehicleType2 = 0;
    } else if (vehicleType1 == "MotorCycle") {
        vehicleType2 = 1;
    } else if (vehicleType1 == "FourWheelers") {
        vehicleType2 = 2;
   }
   }
    
    function changeCurrency() {
    	selectVehicleType();
    	priceD = price[vehicleType2][0];
        priceM = price[vehicleType2][1];
        priceY = price[vehicleType2][2];
        var currencyType = document.getElementById("amount").value;
        document.getElementById("currType").value =currencyType;
        
		if(currencyType == "USD") {
			RATE = USD_RATE;
		} else if (currencyType == "YEN"){
			RATE = YEN_RATE;
		}
		document.getElementById("dailyPrice"+String(vehicleType2)).innerHTML = price[vehicleType2][0] * RATE + currencyType;
        document.getElementById("monthlyPrice"+String(vehicleType2)).innerHTML = price[vehicleType2][1] * RATE + currencyType;
        document.getElementById("yearlyPrice"+String(vehicleType2)).innerHTML = price[vehicleType2][2] * RATE+ currencyType;

        priceDaily = price[vehicleType2][0] * RATE;
        priceMonthly = price[vehicleType2][1] * RATE;
        priceYearly = price[vehicleType2][2] * RATE;
  	
    }
    
    
    function passDay() {
     	document.getElementById("finalAmount").value = priceDaily;
     	document.getElementById("passType").value = "daily";
     	
     	document.getElementById("recipt").innerHTML = "<h2>You have to pay " + priceDaily + currencyType;
     	
        document.getElementById("a2").style.display = "none";
        document.getElementById("passForm").submit();
        
    }

    function passMonth() {
     	document.getElementById("finalAmount").value = priceMonthly;
     	document.getElementById("passType").value = "monthly";

       
        document.getElementById("recipt").innerHTML = "<h1>You have to pay " + priceMonthly + currencyType;
        document.getElementById("a2").style.display = "none";
        document.getElementById("passForm").submit();
    }

    function passYear() {
     	document.getElementById("finalAmount").value = priceYearly;
     	document.getElementById("passType").value = "yearly";

       
        document.getElementById("recipt").innerHTML = "<h1>You have to pay " + priceYearly + currencyType;
        document.getElementById("a2").style.display = "none";
        

    }
    
    
</script>
<title>Insert title here</title>
</head>
<body>

<form id="passForm" action="PassServlet" method="post">
 <% 
 session = request.getSession();
 Vehicle vehicle= (Vehicle) session.getAttribute("vehicle");
 String type = vehicle.getType();
 %>
 <input id="vehicleType" name="vehicleType" type="text" value="<%=type%>" hidden>
 <input id="passType" name="passType" type="text" value="" hidden>
<div id="a1">
<div id="a2">
<input id="finalAmount" name="finalAmount" type="text" value="" hidden>
<input id="currType" name="currType" type="text" value="" hidden>
<select id="amount" onchange="changeCurrency()">
					<option disabled selected>Change Currency</option>
					<option value="INR">INR</option>
					<option value="USD">USD</option>
					<option value="YEN">YEN</option>
				</select><br />

		<%/* if(session.getAttribute("vehicleType").equals("Cycle"))*/
			if(type.equals("Cycle")){
		%>
 
		<div id="passCycle">
			<fieldset>
				<legend>
					<b>Select Pass</b>
				</legend>
				<h1>Cycle</h1>
				<br />
				<br />
				<br /> <span id="error"></span>
				<div class="flex-container">
					<div class="card">
						<h1>1 Day</h1>
						<p id="dailyPrice0">Choose Currency</p>
						<p>
							<button class="cardButton" value="Make Pass" onClick="passDay()">Make
								Pass</button>
						</p>

					</div>

					<div class="card">
						<h1>1 Month</h1>
						<p id="monthlyPrice0">Choose Currency</p>
						<p>
							<button class="cardButton" value="Make Pass"
								onClick="passMonth()">Make Pass</button>
						</p>

					</div>

					<div class="card">
						<h1>1 Year</h1>
						<p id="yearlyPrice0">Choose Currency</p>
						<p>
							<button class="cardButton" value="Make Pass" onClick="passYear()">Make
								Pass</button>
						</p>
					</div>
				</div>
			</fieldset>
		</div>

		<% }
		/* else if(session.getAttribute("vehicleType").equals("MotorCycle")) */
		else if(type.equals("MotorCycle"))
            		{%>
		<div id="passMotorCycle">
			<fieldset>
				<legend>
					<b>Select Pass</b>
				</legend>
				<h1>MotorCycle</h1>
				
				<br />
				<br /> <span id="error1"></span>
				<div class="flex-container">
					<div class="card">
						<h1>1 Day</h1>
						<p id="dailyPrice1">Choose Currency</p>
						<p>
							<button class="cardButton" value="Make Pass" onClick="passDay()">Make
								Pass</button>
						</p>
					</div>

					<div class="card">
						<h1>1 Month</h1>
						<p id="monthlyPrice1">Choose Currency</p>
						<p>
							<button class="cardButton" value="Make Pass"
								onClick="passMonth()">Make Pass</button>
						</p>
					</div>

					<div class="card">
						<h1>1 Year</h1>
						<p id="yearlyPrice1">Choose Currency</p>
						<p>
							<button class="cardButton" value="Make Pass" onClick="passYear()">Make
								Pass</button>
						</p>
					</div>


				</div>
			</fieldset>
		</div>


		<%}
		/* else if(session.getAttribute("vehicleType").equals("FourWheelers")) */
		else if(type.equals("FourWheelers"))
            	{%>

		<div id="passFourWheelers">
			<fieldset>
				<legend>
					<b>Select Pass</b>
				</legend>
				<h1>Four Wheeler</h1>
				
				<br />
				<br />
				<div class="flex-container">
					<div class="card">
						<h1>1 Day</h1>
						<p id="dailyPrice2">Choose Currency</p>
						<p>
							<button class="cardButton" value="Make Pass" onClick="passDay()">Make
								Pass</button>
						</p>
					</div>

					<div class="card">
						<h1>1 Month</h1>
						<p id="monthlyPrice2">Choose Currency</p>
						<p>
							<button class="cardButton" value="Make Pass"
								onClick="passMonth()">Make Pass</button>
						</p>
					</div>

					<div class="card">
						<h1>1 Year</h1>
						<p id="yearlyPrice2">Choose Currency</p>
						<p>
							<button class="cardButton" value="Make Pass" onClick="passYear()">Make
								Pass</button>
						</p>
					</div>


				</div>
			</fieldset>
		</div>
		</div>
		<%} %>
		<br>

		</div>
	</form>
<h1 id="recipt"></h1>
	
</body>
</html>