
const express = require('express')
const sessions = require('./data/sessions.json')

const app = express();


/*
Level-1 : resources
/api/sessions
Level-2 : Verbs
GET /api/sessions
GET /api/sessions/{id}
*/

app.get("/api/sessions", (req, res) => {
    res.json(sessions)
})

app.get("/api/sessions/:id", (req, res) => {
    res.json(sessions.find(session => session.id === Number.parseInt(req.params.id)))
})


app.listen(3000, () => {
    console.log("REST-api-server running at http://localhost:3000/");
})