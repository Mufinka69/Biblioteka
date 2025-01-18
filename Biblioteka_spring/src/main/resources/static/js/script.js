const apiBaseUrl = "http://localhost:8080/userPanel";

function addUser(event) {
    event.preventDefault();

    const user = {
        login: document.getElementById("login").value,
        password: document.getElementById("password").value,
        email: document.getElementById("email").value,
        phoneNumber: document.getElementById("phoneNumber").value,
        roleID: 1
    };

    fetch(`${apiBaseUrl}/addUser`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(() => {
            alert("Dodano użytkownika!");
            loadUsers();
        })
        .catch(error => console.error("Error adding user:", error));
}


function deleteUser(userID) {
    fetch(`${apiBaseUrl}/users/${userID}`, {
        method: "DELETE"
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(users => {
            alert("Użytkownik został usunięty!");
            loadUsers();
        })
        .catch(error => console.error("Error deleting user:", error));
}

document.getElementById("addUserForm").addEventListener("submit", addUser);
