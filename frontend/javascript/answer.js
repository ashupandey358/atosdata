const urlParams = new URLSearchParams(window.location.search);
const currentQuestionId = urlParams.get('id');

async function getAccounts() {
    try {

        let response = await fetch("http://localhost:8081/questions/" + currentQuestionId);
        let question = await response.json();
        sessionStorage.setItem("questionUserId",JSON.stringify(question));
        let value = "";
        value += `
         <i class="bi bi-question-circle-fill"></i> ${question.questions}
            `
        console.log(question);
        document.getElementById("question").innerHTML = value;
        document.getElementById("detailedquestion").innerHTML = question.detailedquestion;
    }
    catch (err) {
        console.log("error");
    }
}
getAccounts();