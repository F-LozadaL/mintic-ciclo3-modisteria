const login = () => {
    const username = document.getElementById("user").value;
    const password = document.getElementById("password").value;

    if (username == "") {
        showError("Username is required");
        return;
    }
    if (password == "") {
        showError("Password is required");
        return;
    }

    const body = {
        "username": username,
        "password": password
    };
    postToLogin(body);


};

const postToLogin = async (bodyObject) => {
    const url = "/api/login";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        const user = await response.json();

        localStorage.setItem("loggedUser", JSON.stringify(user));
        
        alert("Bienvenido "+user.username+"!", "success");
        
        await new Promise(r => setTimeout(r, 2000));

        window.location.href = "/cart";
    } else {
        const message = await response.text();
        showError(message);
    }
};

const showError = (message) => {
    alert(message, "danger");
}

const alert = (message, type) => {
    document.getElementById("errorBox").innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '</div>'
    ].join('')
}