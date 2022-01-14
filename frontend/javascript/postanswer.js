// const urlParams = new URLSearchParams(window.location.search);
// const currentQuestionId = urlParams.get('id');
userDetails = JSON.parse(sessionStorage.getItem("currentUserId"));
questionDetails = JSON.parse(sessionStorage.getItem("questionUserId"));
let answer = document.getElementById("answer")
let click = document.getElementById("answers")
success.style.display = "none";
error.style.display = "none";
click.addEventListener("click", async function postAnswer() {
    console.log(userDetails.name.value)
    try {
        if (answer.value != "") {

            let answers = {
                answer: answer.value,
                name: userDetails.name,
                questionid: {
                    id: questionDetails.id,
                    questions: questionDetails.questions,
                    detailedquestion: questionDetails.detailedquestion,
                    datatime: questionDetails.datatime,
                    user: {
                        id: userDetails.id,
                        name: userDetails.name,
                        mobile: userDetails.mobile,
                        email: userDetails.email,
                        password: userDetails.password,
                        pannumber: userDetails.pannumber
                    }
                }
            }
                ;
            var options = {
                method: 'POST',
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(answers)
            };

            let response = await fetch("http://localhost:8081/answers", options);
            if (response.status == 200) {
                success.style.display = "block";
                success.innerText = "Thank you for your response..";
                clearFormData();
            }


        }
        else {
            error.style.display = "block";
            error.innerText = "Mandatory to fill answer filled"

            clearFormData();
        }

    } catch (err) {
        error.style.display = "block";
        error.innerText = "Failed to post question. Retry or report to site administrator."

        clearFormData();
    }
    function clearFormData() {
        answer.value=""

    }
});