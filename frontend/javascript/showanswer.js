questionDetails = JSON.parse(sessionStorage.getItem("questionUserId"));

async function getAccounts() {
    try {

        let response = await fetch("http://localhost:8081/answers/" + questionDetails.id);
        let answers = await response.json();
        
        let elements = "";
        for (let i=0; i<answers.length; i++) {
            elements += `
           <hr class="mt-4"></hr>
         
         <div class="card border border-dark">
            <div class="card-body">
                <h4 class="card-title"> <i class="bi bi-person-circle"></i> ${answers[i].name}</h4>
                <hr class="mt-2"></hr>
                <h6>Answer</h6>
                <p class="card-text text-muted">${answers[i].answer}</p>

            </div>
        </div> 
    </div>
           `

        }

        document.getElementById("ashu").innerHTML = elements;
        
    }
    catch (err) {
        console.log("error");
    }
    
}
getAccounts();