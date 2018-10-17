const express = require("express")
const port = 4444
const app = express()
const Todo = require("./models/todo")

app.get("/", (request, response) => {

    Todo.getAll( (err, todos) => {
        response.format({
            json: () => {
                response.status(200).json(todos)
            },
            html: () => {
                response.render('./todos.ejs', {todos: todos})
            }
        })
    })
})

app.post("/", (request, reponse) => {

})

app.listen(port)
