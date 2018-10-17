const express = require('express')
const app = express()
const bodyparser = require('body-parser')
const fs = require('fs')
const path = require('path')

// Config
app.set('view engine', 'pug')
app.set('views', process.argv[3])

// Middlewares
//app.use(require('stylus').middleware(process.argv[3]))
app.use(bodyparser.urlencoded({extended: false}))
app.use(express.static(process.argv[3] || path.join(__dirname, 'public')))

app.get('/home', function(req, res) {
	res.render('index', {date: new Date().toDateString()})
})

app.get('/books', function(req, res) {
	fs.readFile(process.argv[3], function(err, data) {
		let book = JSON.parse(data)
		res.json(book)
	})
})

app.get('/search', function(req, res){
	res.send(req.query)
})

app.post('/form', function(req, res) {
	res.send(req.body.str.split('').reverse().join(''))
})

app.put('/message/:id', function(req, res) {
	let hash = require('crypto')
		.createHash('sha1')
		.update(new Date().toDateString() + req.params.id)
		.digest('hex')
	res.send(hash)
})

app.listen(process.argv[2])
