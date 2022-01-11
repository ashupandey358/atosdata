let myQuestions = document.getElementById("myQuestions")
userDetails = JSON.parse(sessionStorage.getItem("currentUserId"));

myQuestions.addEventListener("click", async function getAllTheQuestion() {
    try {


        let response = await fetch("http://localhost:8081/questions/user/" + userDetails.id);
        let data = await response.json();
        console.log(data);
        let elements = "";
        for (var question of data) {

            elements += `
            <tr>
            <td>${question.questions}</td>
            <td>${question.datetime}</td>
            <td>1</td>
          </tr>
            `
        }
        document.getElementById("questionList").innerHTML = elements;
        console.log(elements);
    }
    catch (err) {

    }

});
