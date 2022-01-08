let myQuestions = document.getElementById("myQuestions")
let tabled = document.getElementById("transactionTable");
userDetails = JSON.parse(sessionStorage.getItem("currentUserId"));

myQuestions.addEventListener("click", async function getAllTheQuestion() {
    try {
        
        
        let response = await fetch("http://localhost:8081/questions/"+userDetails.id);
        let data = await response.json();
        console.log(data);
        let element = "";
        for (var question of data) {

            element += `
            <tr>
            <td>${question.questions}</td>
            <td>${question.datetime}</td>
            <td>1</td>
          </tr>
            `
        }
        document.getElementById("questionList").innerHTML = element;
        console.log(element);
    }
    catch (err) {

    }

});
