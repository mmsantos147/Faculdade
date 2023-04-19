import flask
import sqlite3
from flask import Flask, render_template, request

app = Flask(__name__)


@app.route("/")
def home():
    return render_template("teste.html")

@app.route("/login", methods = ["POST"])
def login():
    args = request.args
    email = args.get("email")
    password = args.get("password")
    return ("Success")

@app.route("/register", methods = ["POST", "GET"])
def register():
    args = request.args
    name = args.get("name")
    cpf = args.get("cpf")
    email = args.get("email")
    password = args.get("password")
    db = sqlite3.connect("Terceiro-periodo/Programacao-Web/Outros-Codigos/Site-teste/instance/db.sqlite")
    d = db.cursor()
    d.execute(
        "INSERT INTO customers VALUES (?,?,?,?)", (name, cpf, email, password)
    )
    db.commit()
    db.close()

    return render_template("register.html") 

@app.route("/regist")
def regist():
    return render_template("register.html")

@app.route("/reset")
def reset():
    db = sqlite3.connect("Terceiro-periodo/Programacao-Web/Outros-Codigos/Site-teste/instance/db.sqlite")
    d = db.cursor()
    d.execute(
       "drop table customers"
    )
    db.commit()
    db.execute(
        "create table customers (Name varchar(255), CPF int, Email varchar(255), Password varchar(255);)"
    )
    db.commit()
    db.close()
    return "OK"
app.run(debug=True)
