from flask import Blueprint, render_template, url_for

# render_template() - is used to work with html files in python

main = Blueprint('main', __name__)

# goto init(index page) and add this main variable so that its accessed

# create the home page
@main.route('/') # this is the home or index page('/')
def index():
    return render_template('index.html')

# create the profile page
@main.route('/profile') # this function routes you or takes you to the profiles page
def profile():
    return render_template('profile.html')