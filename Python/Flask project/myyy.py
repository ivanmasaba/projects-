from flask import Flask
from flask_mysql_connector import MySQL
app = Flask(__name__)

app.config['MySQL_HOST'] = 'localhost'
app.config['MySQL_USER'] = 'ivan'
app.config['MySQL_PASSWORD'] = '12345'
app.config['MySQL_DB'] = 'login'

mysql = MySQL(app)

sql = 'select * from log'

@app.route('/new_cursor')
def new_cursor():
    cur = mysql.new_cursor(dictionary=True)
    cur.execute(sql)
    output = cur.fetchall()

    return str(output)


    if __name__ == __main__:
            app.run(debug=True)
