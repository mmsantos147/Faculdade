function register() {
    const request = new XMLHttpRequest;
    const email = document.getElementById("inputEmail").value;
    const password = document.getElementById("inputPassword").value;
    const cemail = document.getElementById("inputcEmail").value;
    const cpassword = document.getElementById("inputcPassword").value;
    const name = document.getElementById("inputName").value;
    const cpf = document.getElementById("inputCpf").value;

    request.open("POST", "/register?name=" + name + "&cpf=" + cpf + "&email=" + email + "&password=" + password);
    request.send();
}

function login() {
    const request = new XMLHttpRequest;
    const email = document.getElementById("inputEmail").value;
    const password = document.getElementById("inputPassword").value;

    request.open("POST", "/login?email=" + email + "&password=" + password);
    request.send();
}