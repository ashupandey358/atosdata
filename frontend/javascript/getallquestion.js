let allQuestions = document.getElementById("allQuestions")

allQuestions.addEventListener("click", async function getAllTheQuestion() {
    try {
        
        
        let response = await fetch("http://localhost:8081/questions");
        let data = await response.json();
        console.log(data);
        let element = "";
        for (var question of data) {

            element += `
            <tr>
            <td><a href="/html/answer.html?id=${question.id}"> <i class="bi bi-question-circle-fill"></i> ${question.questions}</td>
            <td>${question.detailedquestion}</td>
            <td> <i class="bi bi-alarm-fill"></i> ${question.datetime}</td>
        
          </tr>
            `
        }
        document.getElementById("questionList").innerHTML = element;
        console.log(element);
    }
    catch (err) {

    }

});
