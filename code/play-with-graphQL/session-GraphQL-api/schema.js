const { gql } = require('apollo-server');



const typeDefs = gql`

    type Query{
        sessions:[Session]
        sessionById(id:ID):Session
    }

    type Session {
        id: ID!
        title: String!
        description: String
        startsAt: String
        endsAt: String
        room: String
        day: String
        format: String
        track: String
        level: String
    }


`

module.exports = typeDefs