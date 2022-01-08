let submit = document.getElementById("submit");
let emailid = document.getElementById("email");
let password = document.getElementById("password");
let emailError = document.getElementById("emailError");
let passworderror = document.getElementById("password");
error.style.display = "none";
submit.addEventListener("click",  function (){forLogin(); });
async function forLogin(){
    try {
        let user = {
        
            
            email: emailid.value,
            password:password.value
            
            };
            var options = {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(user)
            };
        
        let response = await fetch("http://localhost:8081/users/login",options);
        console.log(response);
        let userDetails = await response.json();
        console.log(userDetails);
        if (response.status == 200) {  
           window.location.href="/html/Q&A.html";
          sessionStorage.setItem("currentUserId",JSON.stringify(userDetails));
        }
        else if (response.status == "401") {
            console.log("Login failed");
            error.style.display = "block";
            error.innerText = "Enter Correct Credentials";
        }
        else if (response.status == "404") {
            error.style.display = "block";
            error.innerText = "Enter E-mail and Password";
        }
    }catch(err)
    {
        error.style.display = "block";
         error.innerText = "Server is facing an issue. Try after sometime. Sorry For Inconvenience";
    }


}

    

    