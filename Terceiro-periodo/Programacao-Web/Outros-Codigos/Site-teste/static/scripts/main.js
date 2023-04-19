function register() {
    const request = new XMLHttpRequest;
    const name = document.getElementById("inputName").value;
    const cpf = document.getElementById("inputCPF").value;
    const email = document.getElementById("inputEmail").value;
    const password = document.getElementById("inputPassword").value;
    const cemail = document.getElementById("inputCEmail").value;
    const cpassword = document.getElementById("inputCPassword").value;
    if (email == cemail && password == cpassword) {
        request.open("POST", "/register?name=" + name + "&cpf=" + cpf + "&email=" + email + "&password=" + password);
        request.send();
        alert("Cadastro feito com sucesso")
    } else {
        alert("Email ou senha não batem")
    }      
}

function login() {
    const request = new XMLHttpRequest;
    const email = document.getElementById("inputEmail").value;
    const password = document.getElementById("inputPassword").value;

    request.open("POST", "/login?email=" + email + "&password=" + password);
    request.send();
}