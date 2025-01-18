const apiBaseUrl = "http://localhost:8080/bookPanel";

function addBook(event) {
    event.preventDefault();

    const book = {
        title: document.getElementById("title").value,
        author: document.getElementById("author").value,
        date: document.getElementById("date").value,
        publishing_house: document.getElementById("publishing_house").value,
        isbn: document.getElementById("isbn").value
    };

    fetch(`${apiBaseUrl}/addBook`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(book)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(() => {
            alert("Dodano Ksiazkę!");
            loadBooks();
        })
        .catch(error => console.error("Error adding Book:", error));
}

document.getElementById("addBookForm").addEventListener("submit", addBook);
