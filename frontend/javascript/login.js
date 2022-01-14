let submit = document.getElementById("submit");
let emailid = document.getElementById("email");
let password = document.getElementById("password");
let emailError = document.getElementById("emailError");
let passworderror = document.getElementById("password");
error.style.display = "none";
submit.addEventListener("click", async function forLogin(){
    try{
        let user = {
        
            
            email: emailid.value,
            password:password.value
            
            };
            var options = {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(user)
            };
        if (emailid.value =="" && password.value=="") {
            error.style.display = "block";
            error.innerText = "Enter E-mail and Password";
            }
        
        
        else if (emailid.value !="" && password.value!="") {  
            let response = await fetch("http://localhost:8081/users/login",options);
            let userDetails = await response.json();
            if(response.status==200)
            {
             window.location.href="/html/Q&A.html";
             sessionStorage.setItem("currentUserId",JSON.stringify(userDetails));
            }
            else if(response.status!=200)
            {
                error.style.display = "block";
                error.innerText = "Enter Correct Credentials";
            }
        }
    }catch (err){
        error.style.display = "block";
        error.innerText = "Enter Correct Credentials";
    }  
    
});
    

    