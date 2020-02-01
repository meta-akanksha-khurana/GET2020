var currencyType = "INR";
var price = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
var USD_RATE = 0.014;
var YEN_RATE = 1.53;
var vehicleType1;
var vehicleType2;
var selectedTypeRate = 1;
var priceDaily;
var priceMonthly;
var priceYearly;


function generateID() {
    return Math.random().toString(36).substr(2, 9);
}

function register() {

    var name = document.getElementById('empName')
    var regex = /^[a-zA-Z ]{2,30}$/;
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    var pass = /^[a-zA-Z0-9]{8,14}$/;
    var phoneno = /^[0-9]{10}$/;
    var email = document.getElementById("emailId").value;
    var password = document.getElementById("pswd").value;
    var contact = document.getElementById("contact").value;
    var flag = true;
    if (!regex.test(name.value)) {
        document.getElementById("comment").innerHTML = "<span>Name shoud be correct.<span>";
        flag = false;
    }
    if (!emailPattern.test(email)) {
        document.getElementById("comment1").innerHTML = "<span>Email shoud be correct.<span>";
        flag = false;
    }
    if (!pass.test(password)) {
        document.getElementById("comment2").innerHTML = "<span>Password shoud be in correct format.<span>";
        flag = false;
    }
    if (!phoneno.test(contact)) {
        document.getElementById("comment3").innerHTML = "<span>Contact shoud be in correct format.<span>";
        flag = false;
    }

    if (flag) {
        document.getElementById('empRegistrationForm').innerHTML = "<h1>you are registered now.Your Registration Id is " + generateID();
    }
}

function vehicleRegistration() {
    var e = document.getElementById("vehicleType");
    vehicleType = e.options[e.selectedIndex].value;
    vehicleType1 = document.getElementById("vehicleType").value;


    if (vehicleType1 == "Cycle") {
        vehicleType2 = 0;
    } else if (vehicleType1 == "MotorCycle") {
        vehicleType2 = 1;
    } else if (vehicleType1 == "FourWheelers") {
        vehicleType2 = 2;
    }
    document.getElementById("vehicleDetails").innerHTML = "<h1>Vehicle Registered!<br>";
    if (vehicleType == "Cycle") {

        document.getElementById("passCycle").style.display = "block";
        document.getElementById("passMotorCycle").style.display = "none";
        document.getElementById("passFourWheelers").style.display = "none";
    } else if (vehicleType == "MotorCycle") {

        document.getElementById("passCycle").style.display = "none";
        document.getElementById("passMotorCycle").style.display = "block";
        document.getElementById("passFourWheelers").style.display = "none";
    } else if (vehicleType == "FourWheelers") {

        document.getElementById("passCycle").style.display = "none";
        document.getElementById("passMotorCycle").style.display = "none";
        document.getElementById("passFourWheelers").style.display = "block";
    }
}





function changeCurrency() {

    var currencyType = document.getElementById("amount").value;
    if (currencyType == "INR") {
        document.getElementById("dailyPrice").innerHTML = price[vehicleType2][0] + " INR";
        document.getElementById("monthlyPrice").innerHTML = price[vehicleType2][1] + " INR";
        document.getElementById("yearlyPrice").innerHTML = price[vehicleType2][2] + " INR";
        priceDaily = price[vehicleType2][0] + " INR";
        priceMonthly = price[vehicleType2][1] + " INR";
        priceYearly = price[vehicleType2][2] + " INR";

    } else if (currencyType == "USD") {
        document.getElementById("dailyPrice").innerHTML = (price[vehicleType2][0] * USD_RATE).toFixed(2) + " USD";
        document.getElementById("monthlyPrice").innerHTML = (price[vehicleType2][1] * USD_RATE).toFixed(2) + " USD";
        document.getElementById("yearlyPrice").innerHTML = (price[vehicleType2][2] * USD_RATE).toFixed(2) + " USD";
        priceDaily = (price[vehicleType2][0] * USD_RATE) + " USD";
        priceMonthly = (price[vehicleType2][1] * USD_RATE) + " USD";
        priceYearly = (price[vehicleType2][2] * USD_RATE) + " USD";

    } else if (currencyType == "YEN") {
        document.getElementById("dailyPrice").innerHTML = (price[vehicleType2][0] * YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("monthlyPrice").innerHTML = (price[vehicleType2][1] * YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("yearlyPrice").innerHTML = (price[vehicleType2][2] * YEN_RATE).toFixed(2) + " YEN";
        priceDaily = (price[vehicleType2][0] * YEN_RATE) + " YEN";
        priceMonthly = (price[vehicleType2][1] * YEN_RATE) + " YEN";
        priceYearly = (price[vehicleType2][2] * YEN_RATE) + " YEN";

    }

}

function changeCurrency1() {
    var currencyType = document.getElementById("amount1").value;


    if (currencyType == "INR1") {
        document.getElementById("dailyPrice1").innerHTML = price[vehicleType2][0] + " INR";
        document.getElementById("monthlyPrice1").innerHTML = price[vehicleType2][1] + " INR";
        document.getElementById("yearlyPrice1").innerHTML = price[vehicleType2][2] + " INR";
        priceDaily = price[vehicleType2][0] + " INR";
        priceMonthly = price[vehicleType2][1] + " INR";
        priceYearly = price[vehicleType2][2] + " INR";

    } else if (currencyType == "USD1") {

        document.getElementById("dailyPrice1").innerHTML = (price[vehicleType2][0] * USD_RATE).toFixed(2) + " USD";
        document.getElementById("monthlyPrice1").innerHTML = (price[vehicleType2][1] * USD_RATE).toFixed(2) + " USD";
        document.getElementById("yearlyPrice1").innerHTML = (price[vehicleType2][2] * USD_RATE).toFixed(2) + " USD";
        priceDaily = (price[vehicleType2][0] * USD_RATE).toFixed(2) + " USD";
        priceMonthly = (price[vehicleType2][1] * USD_RATE).toFixed(2) + " USD";
        priceYearly = (price[vehicleType2][2] * USD_RATE).toFixed(2) + " USD";

    } else if (currencyType == "YEN1") {
        document.getElementById("dailyPrice1").innerHTML = (price[vehicleType2][0] * YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("monthlyPrice1").innerHTML = (price[vehicleType2][1] * YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("yearlyPrice1").innerHTML = (price[vehicleType2][2] * YEN_RATE).toFixed(2) + " YEN";
        priceDaily = (price[vehicleType2][0] * YEN_RATE).toFixed(2) + " YEN";
        priceMonthly = (price[vehicleType2][1] * YEN_RATE).toFixed(2) + " YEN";
        priceYearly = (price[vehicleType2][2] * YEN_RATE).toFixed(2) + " YEN";
    }
}

function changeCurrency2() {
    var currencyType = document.getElementById("amount2").value;
    if (currencyType == "INR2") {
        document.getElementById("dailyPrice2").innerHTML = price[vehicleType2][0] + " INR";
        document.getElementById("monthlyPrice2").innerHTML = price[vehicleType2][1] + " INR";
        document.getElementById("yearlyPrice2").innerHTML = price[vehicleType2][2] + " INR";
        priceDaily = price[vehicleType2][0] + " INR";
        priceMonthly = price[vehicleType2][1] + " INR";
        priceYearly = price[vehicleType2][2] + " INR";

    } else if (currencyType == "USD2") {
        document.getElementById("dailyPrice2").innerHTML = (price[vehicleType2][0] * USD_RATE).toFixed(2) + " USD";
        document.getElementById("monthlyPrice2").innerHTML = (price[vehicleType2][1] * USD_RATE).toFixed(2) + " USD";
        document.getElementById("yearlyPrice2").innerHTML = (price[vehicleType2][2] * USD_RATE).toFixed(2) + " USD";
        priceDaily = (price[vehicleType2][0] * USD_RATE).toFixed(2) + " USD";
        priceMonthly = (price[vehicleType2][1] * USD_RATE).toFixed(2) + " USD";
        priceYearly = (price[vehicleType2][2] * USD_RATE).toFixed(2) + " USD";

    } else if (currencyType == "YEN2") {
        document.getElementById("dailyPrice2").innerHTML = (price[vehicleType2][0] * YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("monthlyPrice2").innerHTML = (price[vehicleType2][1] * YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("yearlyPrice2").innerHTML = (price[vehicleType2][2] * YEN_RATE).toFixed(2) + " YEN";
        priceDaily = (price[vehicleType2][0] * YEN_RATE).toFixed(2) + " YEN";
        priceMonthly = (price[vehicleType2][1] * YEN_RATE).toFixed(2) + " YEN";
        priceYearly = (price[vehicleType2][2] * YEN_RATE).toFixed(2) + " YEN";
    }
}

function passDay() {
    document.getElementById("recipt").innerHTML = "<h1>You have to pay " + priceDaily + "</h1>";
    document.getElementById("a2").style.display = "none";
}

function passMonth() {
    document.getElementById("recipt").innerHTML = "<h1>You have to pay " + priceMonthly;
    document.getElementById("a2").style.display = "none";
}

function passYear() {
    document.getElementById("recipt").innerHTML = "<h1>You have to pay " + priceYearly;
    document.getElementById("a2").style.display = "none";
}