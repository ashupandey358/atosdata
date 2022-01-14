let question = document.getElementById("question");
let detailedQuestion = document.getElementById("detailedQuestion");
let submit = document.getElementById("submit");
userDetails = JSON.parse(sessionStorage.getItem("currentUserId"));
success.style.display = "none";
error.style.display = "none";
submit.addEventListener("click", async function postQuestion() {
    try {
        var today = new Date();
        var date = today.getDate() + '-' + (today.getMonth() + 1) + '-' + today.getFullYear();
        var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
        var dateTime = date + ' ' + time;


        let question1 =
        {
            questions: question.value,
            detailedquestion: detailedQuestion.value,
            user: {
                id: userDetails.id,
                name: userDetails.name,
                mobile: userDetails.mobile,
                email: userDetails.email,
                password: userDetails.password,
                pannumber: userDetails.pannumber
            },
            datetime: dateTime
        }
        var options = {
            method: 'POST',
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(question1)
        };

        if (question.value == "" && detailedQuestion.value == "") {

            error.style.display = "block";
            error.innerText = "Queston and detailedquestion is mandatory to fill"

            clearFormData();

        }
        if (question.value != "" && detailedQuestion.value != "") {
            let response = await fetch("http://localhost:8081/questions", options);
            if (response.status == 200) {
                clearFormData();
                success.style.display = "block";
                success.innerText = "Thanks for using our services we will try to do it as soon as possible";
            }

        }
    } catch (err) {
        error.style.display = "block";
        error.innerText = "Failed to post question. Retry or report to site administrator."

        clearFormData();
    }

    function clearFormData() {
        question.value = "",
            detailedQuestion.value = ""

    }
});