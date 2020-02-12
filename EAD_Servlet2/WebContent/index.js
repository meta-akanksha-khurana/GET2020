function register(){
var name = document.getElementById('empName')
    var regex = /^[a-zA-Z ]{2,30}$/;
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    var pass = /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/;
    var phoneno = /^[0-9]{10}$/;
    var email = document.getElementById("Email").value;
    var password = document.getElementById("pswd").value;
    var confirmPassword = document.getElementById("confirmPswd").value;
    var contact = document.getElementById("contact").value;
    var flag = true;
    if (!regex.test(name.value)) {
        document.getElementById("comment").innerHTML = "<span>Name should be correct.<span>";
        flag = false;
    }
    if (!emailPattern.test(email)) {
        document.getElementById("comment1").innerHTML = "<span>Email should be correct.<span>";
        flag = false;
    }
    if (!pass.test(password)) {
        document.getElementById("comment2").innerHTML = "<span>Password should be in correct format.<span>";
        flag = false;
    }
    if (!phoneno.test(contact)) {
        document.getElementById("comment3").innerHTML = "<span>Contact should be in correct format.<span>";
        flag = false;
    }
    if (confirmPassword != password) {
        document.getElementById("comment4").innerHTML = "<span> Password is not same!Enter again.<span>";
        flag = false;
    }

    return flag;
    /*if (flag) {
        document.getElementById('fieldset1').innerHTML = "<h1>you are registered now.Your Registration Id is " + generateID();
        document.getElementById("vehicleDiv").style.display = "block";
        document.getElementById("vehicleBlock").style.display = "none";
    }*/
}