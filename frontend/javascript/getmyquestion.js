let myQuestions = document.getElementById("myQuestions")
userDetails = JSON.parse(sessionStorage.getItem("currentUserId"));


myQuestions.addEventListener("click", async function getAllTheQuestion() {
    try {


        let response = await fetch("http://localhost:8081/questions/user/" + userDetails.id);
        let data = await response.json();
        
        let elements = "";
        for (var question of data) {

            elements += `
            <tr>
            <td><a href="/html/answer.html?id=${question.id}"> <i class="bi bi-question-circle-fill"></i> ${question.questions}<a></td>
            <td>${question.detailedquestion}</td>
            <td><i class="bi bi-alarm-fill"></i> ${question.datetime}</td>
            
          </tr>
            `
        }
        document.getElementById("questionList").innerHTML = elements;
        console.log(elements);
    }
    catch (err) {

    }

});
