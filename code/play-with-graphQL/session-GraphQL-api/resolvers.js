
const sessions = require('./data/sessions.json')


module.exports = {
    Query: {
        sessions: () => {
            //..
            return sessions
        },
        sessionById: (parent, args) => {
            let { id } = args;
            return sessions.find(session => session.id === Number.parseInt(id))
        }
    }
}