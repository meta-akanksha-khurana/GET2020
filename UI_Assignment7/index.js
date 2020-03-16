var storedPrice = [];
var currencyType = "INR";
var price = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
var INR_RATE = 1;
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
var emp;


function validateEmpRegistration(Id) {
    if (event.key == "Enter") {
        if (Id == "empName") {
            if (validations(Id)) {
                document.getElementById("empNameDiv").style.display = "none";
                document.getElementById("genderLabel").innerHTML = "Hello " + emp + "! Can I know your gender";
                document.getElementById("genderDiv").style.display = "block";
            }

        } else if (Id == "emailId") {
            if (validations(Id)) {
                document.getElementById("emailDiv").style.display = "none";
                document.getElementById("pswdLabel").innerHTML = "Hello " + emp + "! Please enter password";
                document.getElementById("pswdDiv").style.display = "block";
            }

        } else if (Id == "pswd") {
            if (validations(Id)) {
                document.getElementById("pswdDiv").style.display = "none";
                document.getElementById("confirmPswdLabel").innerHTML = "Hello " + emp + "! Please confirm your password";
                document.getElementById("confirmPswdDiv").style.display = "block";
            }

        } else if (Id == "confirmPswd") {
            if (validations(Id)) {
                document.getElementById("confirmPswdDiv").style.display = "none";
                document.getElementById("contactLabel").innerHTML = "Hello " + emp + "! Can I know your contact number";
                document.getElementById("contactDiv").style.display = "block";
                document.getElementById("submitDiv").style.display = "block";
            }
        }
    }
}

function validateGender() {

    document.getElementById("genderDiv").style.display = "none";
    document.getElementById("emailLabel").innerHTML = "Hello " + emp + "! Can I know your Email";
    document.getElementById("emailDiv").style.display = "block";
}

function generateID() {
    return Math.random().toString(36).substr(2, 9);
}

function register() {
    var phoneno = /^[0-9]{9,}$/;
    var contact = document.getElementById("contact").value;
    var flag = true;
    if (!phoneno.test(contact)) {
        document.getElementById("comment3").innerHTML = "<span>Contact should be in correct format.<span>";
        flag = false;
    }
    if (flag) {
        document.getElementById("employeeDiv").style.display = "none";
        document.getElementById('empMessage').innerHTML = "you are registered now.Your Registration Id is " + generateID();
        document.getElementById("vehicleDiv").style.display = "block";
    }
}



function validations(Id) {
    var regex = /^[a-zA-Z ]{2,30}$/;
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

    switch (Id) {
        case "empName":
            emp = document.getElementById("empName").value;
            if (!regex.test(emp)) {
                document.getElementById("comment").innerHTML = "<span>Name should be correct.<span>";
                return false;
            }
            return true;
            break;

        case "emailId":
            var email = document.getElementById("emailId").value;
            if (!emailPattern.test(email)) {
                document.getElementById("comment1").innerHTML = "<span>Email should be correct.<span>";
                return false;
            }
            return true;
            break;

        case "pswd":
            return passwordValidation();
            break;

        case "confirmPswd":
            var password = document.getElementById("pswd").value;
            var confirmPassword = document.getElementById("confirmPswd").value;
            if (confirmPassword != password) {
                document.getElementById("comment2").innerHTML = "<span> Password is not same!Enter again.<span>";
                return false;
            }
            return true;
            break;
    }


}

function passwordValidation() {
    var password = document.getElementById("pswd").value;
    var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
    var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");

    if (password.match(strongRegex)) {
        document.getElementById("pswd").style.borderColor = "green";
        document.getElementById("pswd").style.borderWidth = "3px";
        document.getElementById("pswd").style.backgroundColor = "white";
        document.getElementById("pswd").style.color = "black";
        return true;
    } else if (password.match(mediumRegex)) {
        document.getElementById("pswd").style.borderColor = "orange";
        document.getElementById("pswd").style.borderWidth = "3px";
        document.getElementById("pswd").style.backgroundColor = "white";
        document.getElementById("pswd").style.color = "black";
        return false;
    } else {
        document.getElementById("pswd").style.borderColor = "red";
        document.getElementById("pswd").style.borderWidth = "3px";
        document.getElementById("pswd").style.backgroundColor = "white";
        document.getElementById("pswd").style.color = "black";
        return false;
    }
}

function validateVehicle(Id) {
    if (event.key == "Enter") {
        if (Id == "vehicleName") {
            document.getElementById("vehicleNameDiv").style.display = "none";
            document.getElementById("vehicleTypeLabel").innerHTML = "Select your vehicle type";
            document.getElementById("vehicleTypeDiv").style.display = "block";

        } else if (Id == "vehicleType") {
            document.getElementById("vehicleTypeDiv").style.display = "none";
            document.getElementById("vehicleNumberLabel").innerHTML = "Please enter your vehicle number";
            document.getElementById("vehicleNumberDiv").style.display = "block";
        } else if (Id == "vehicleNumber") {
            document.getElementById("vehicleNumberDiv").style.display = "none";
            document.getElementById("vehicleIdentificationLabel").innerHTML = "Please enter some identification";
            document.getElementById("vehicleIdentificationDiv").style.display = "block";
        }

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
    document.getElementById("fieldset2").innerHTML = "<h1>Vehicle Registered!<br>";
    document.getElementById("a1").style.display = "block";
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



function selectVehicleType() {
    vehicleType1 = document.getElementById("vehicleType").value;
    if (vehicleType1 == "Cycle") {
        vehicleType2 = 0;
    } else if (vehicleType1 == "MotorCycle") {
        vehicleType2 = 1;
    } else if (vehicleType1 == "FourWheelers") {
        vehicleType2 = 2;
    }
}

function changeCurrency() {
    priceD = price[vehicleType2][0];
    priceM = price[vehicleType2][1];
    priceY = price[vehicleType2][2];
    currencyType = document.getElementById("amount").value;

    var RATE = INR_RATE;
    if (currencyType == "USD") {
        RATE = USD_RATE;
    } else if (currencyType == "YEN") {
        RATE = YEN_RATE;
    }
    document.getElementById("dailyPrice" + String(vehicleType2)).innerHTML = price[vehicleType2][0] * RATE + currencyType;
    document.getElementById("monthlyPrice" + String(vehicleType2)).innerHTML = price[vehicleType2][1] * RATE + currencyType;
    document.getElementById("yearlyPrice" + String(vehicleType2)).innerHTML = price[vehicleType2][2] * RATE + currencyType;

    priceDaily = price[vehicleType2][0] * RATE;
    priceMonthly = price[vehicleType2][1] * RATE;
    priceYearly = price[vehicleType2][2] * RATE;

}


function passDay() {
    document.getElementById("recipt").innerHTML = "<h2>You have to pay " + priceDaily + currencyType;
    document.getElementById("a2").style.display = "none";
}

function passMonth() {
    document.getElementById("recipt").innerHTML = "<h1>You have to pay " + priceMonthly + currencyType;
    document.getElementById("a2").style.display = "none";
}

function passYear() {
    document.getElementById("recipt").innerHTML = "<h1>You have to pay " + priceYearly + currencyType;
    document.getElementById("a2").style.display = "none";
}