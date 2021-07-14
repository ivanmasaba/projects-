# this is the authentication page

from flask import Blueprint, render_template, url_for, request, redirect
from werkzeug.security import generate_password_hash
from .models import User
from . import db


auth = Blueprint('auth', __name__)

# create the signup page
@auth.route('/signup')
def signup():
    return render_template('signup.html')

# function to handle signup
@auth.route('/signup', methods=['POST'])
def sign_post():
    email = request.form.get('email')
    name = request.form.get('name')
    password = request.form.get('password')

    # print this output in the terminal
    #print(email, name, password + " has signed up ")

    user = User.query.filter_by(email=email).first()
    
    if user:
        print('user already exists..')
    else:
        new_user = User(email=email, name=name, password=generate_password_hash(password, method='sha256'))
        db.session.add(new_user)
        db.session.commit()

    # after user has signed up, redirect user to the login page
    return redirect(url_for('auth.login'))

# create the login page
@auth.route('/login')
def login():
    return render_template('login.html')

@auth.route('/login', methods=['POST'] )
def login_post():
    email = request.form.get('email')
    password = request.form.get('password')

    # print this output in the terminal
    print(email, password + " has logged in ")

    return redirect(url_for('main.profile'))

@auth.route('/logout')
def logout():
    return render_template('index.html')