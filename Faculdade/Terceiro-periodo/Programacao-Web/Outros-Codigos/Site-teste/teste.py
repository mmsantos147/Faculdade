import flask
import sqlite3
from flask import Flask, render_template, request

app = Flask(__name__)
db = sqlite3.connect("instance/db.sqlite")


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

    return render_template("register.html") 

app.run(debug=True)
