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
