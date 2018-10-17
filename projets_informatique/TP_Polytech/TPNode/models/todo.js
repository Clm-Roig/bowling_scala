const sqlite3 = require('sqlite3')
const db = new sqlite3.Database(':memory:')

db.serialize(() => {
    const sql = 'CREATE TABLE IF NOT EXISTS todos (id integer primary key, title, description)';
    db.run(sql);
    db.run('INSERT INTO todos(title, description) VALUES(?,?)', 'acheter oeufs', 'label rouge');
    db.run('INSERT INTO todos(title, description) VALUES(?,?)', 'faire la vaisselle', '');
    db.run('INSERT INTO todos(title, description) VALUES(?,?)', 'laver la voiture', 'frotter fort');
    db.run('INSERT INTO todos(title, description) VALUES(?,?)', 'faire ses devoirs', 'deadline : jeudi 53 juin 2050');
});

class Todo {
    constructor(id, title, descritpion) {
        this.id = id
        this.title = title
        this.description = description
    }

    static getAll(callback) {
        db.all('SELECT * FROM todos', callback)
    }
}

module.exports = Todo;
