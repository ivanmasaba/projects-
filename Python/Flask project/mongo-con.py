import json
from flask import Flask, request, jsonify
from flask_mongoengine import MongoEngine

app = Flask(__name__)

app.config['MONGODB_SETTINGS'] = {
    'db' : 'school',
    'host' : 'localhost',
    'port' : '27017'
}

db = MongoEngine()
db.init_app(app)

class User(db.Document):
    name = db.StringField()
    def to_json(self):
        return { "name" : self.name }
@app.route('/', methods=['GET'])
def query_records():
    name = request.args.get('name')
    user = User.objects(name=name).first()
    if not user:
        return jsonify({'error' : 'Data not found'})
    else:
        return jsonify(user.to_json())


    if __name__ == '__main__':
        app.run(debug=True)
