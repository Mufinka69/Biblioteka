const apiBaseUrl = "http://localhost:8080/bookPanel";


function add_book(event) {
    event.preventDefault();

    const book = {
        title: document.getElementById("title").value,
        author: document.getElementById("author").value,
        date: document.getElementById("date").value,
        isbn: document.getElementById("isbn").value
    };

    fetch('http://localhost:8080/bookPanel/addBook', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(book)
    })
    .then(response => {
        if (response.ok) {
            alert("Książka została dodana!");
            document.getElementById("addBookForm").reset();
        } else {
            alert("Wystąpił błąd podczas dodawania książki.");
        }
    })
    .catch(error => {
        console.error("Błąd:", error);
        alert("Wystąpił błąd!");
    });
}

//document.getElementById("loadUsers").addEventListener("click", loadUsers);
//document.getElementById("addUserForm").addEventListener("submit", addUser);