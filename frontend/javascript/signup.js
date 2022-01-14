
let name1 = document.getElementById("name");
let mobilenumber = document.getElementById("mobilenumber");
let email = document.getElementById("email");
let password = document.getElementById("password");
let pannumber = document.getElementById("pannumber")

let nameerror = document.getElementById("nameError");
let mobilenumbererror = document.getElementById("mobilenumberError");
let emailerror = document.getElementById("emailError");
let passworderror = document.getElementById("passwordError");
let pannumbererror = document.getElementById("pannumberError")
let valid = true;

success.style.display = "none";
error.style.display = "none";

function onClickingButton() {
    let nameValid = true;
    let mobilenumberValid = true;
    let emailValid = true;
    let passwordValid = true;
    let pannumberValid = true;

    if (name1.value == "") {
        nameerror.innerText = "name is mandatory"
        nameValid = false;
    }
    else if (!name1.value.match(/[a-zA-Z][a-zA-Z ]*/)) {
        nameerror.innerText = "only characters are allowed"
        nameValid = false;
    }
    if (mobilenumber.value == "") {
        mobilenumbererror.innerText = "mobile number is mandatory"
        mobilenumberValid = false;
    }
    else if (!mobilenumber.value.match(/[1-9][0-9]{9}/)) {
        mobilenumbererror.innerText = "only numbers are allow"
        emailValid = false;
    }

    if (email.value == "") {
        emailerror.innerText = "email is mandatory"
        emailValid = false;
    }
    else if (!email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)) {
        emailerror.innerText = "give an proper format"
        emailValid = false;
    }
    if (password.value == "") {
        passworderror.innerText = "Password is mandatory"
        passwordValid = false;
    }
    else if (!password.value.match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$/)) {
        passworderror.innerText = "one special,number,charchacter are present and minimum length of the password is 8"
        passwordValid = false;
    }

    

    if (pannumber.value == "") {
        pannumbererror.innerText = "Pan number  is mandatory"
        pannumberValid = false;
    }
    else if (!pannumber.value.match(/[A-Z]{5}[0-9]{4}[A-Z]{1}/)) {
        pannumbererror.innerText = "Give in proper format like ABCDE1234F"
        pannumberValid = false;
    }

    if(nameValid==true && mobilenumberValid==true && emailValid==true && passwordValid==true && pannumberValid==true )
    {
        console.log("good job")
        addCustomer()
    }
}




async function addCustomer() {
    let customer = {

        name: name1.value,
        mobile: mobilenumber.value,
        email: email.value,
        password: password.value,
        pannumber: pannumber.value
    };
    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(customer)
    };

    let response = await fetch("http://localhost:8081/users", options);
    console.log(response);
    if (response.status == 200) {
        clearFormData();
        success.style.display = "block";
        success.innerText = "Customer Added Successfully go to login page";


    }
    else {

        error.style.display = "block";
        error.innerText = "Failed to add employee. Retry or report to site administrator."

        clearFormData();

    }
    function clearFormData() {
        name1.value = "",
            mobilenumber.value = "",
            email.value = "",
            password.value = "",
            pannumber.value = ""
    }



};
