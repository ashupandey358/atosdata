let signin = document.getElementById("signin");
let name1 = document.getElementById("name");
let mobilenumber = document.getElementById("mobilenumber");
let email = document.getElementById("email");
let password = document.getElementById("password");
let pannumber = document.getElementById("pannumber")
let valid = true;

success.style.display = "none";
error.style.display = "none";

signin.addEventListener("click", async function addCustomer() {
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
        pannumber.value=""
}



});
