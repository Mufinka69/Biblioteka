function przejdz_na(link){
    window.location.href = link;
}

function przejdz_na_tel(link){
        const nrTelefonu = document.querySelector('input[type="text"]').value;


        if (nrTelefonu) {
            window.location.href = link + "?nrTelefonu=" + encodeURIComponent(nrTelefonu);

        } else {
            alert("Proszę podać numer telefonu!");
        }
}

function getQueryParam(param) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param);
}

function wypozycz(bookID){
    const nrTelefonu = getQueryParam('nrTelefonu');
    if (nrTelefonu) {
        console.log("Numer telefonu użytkownika: " + nrTelefonu + "  " + bookID);
        fetch('http://localhost:8080/userPanel/phone/' + nrTelefonu).then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();

        }).then(function(data) {

            let userId;
            console.log(data.userId);
            userId = data.userId;
            const loan = {
                    bookID: bookID,
                    userID: userId
                };
            fetch('http://localhost:8080/loanPanel/addLoan', {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(loan)
            })
    })
    }else {
        console.log("Numer telefonu nie został podany");
    }
}

function pokazKomunikat(input) {
    var tekst = document.getElementById(input).value;
    alert(tekst);
}
