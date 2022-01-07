const { ApolloServer, gql } = require('apollo-server');

const typeDefs = require('./schema.js')
const resolvers = require('./resolvers.js')



const server = new ApolloServer({
    typeDefs,
    resolvers,
});

server.listen({ port: process.env.PORT || 4000 }).then(({ url }) => {
    console.log(`graphQL api server running at ${url}`);
});