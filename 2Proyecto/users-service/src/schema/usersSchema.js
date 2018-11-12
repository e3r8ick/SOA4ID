module.exports = `
  type users {
    _id: String!
    type: String!,
    name: String!,
    email: String!,
    hash: String!
  }

  type Query {
    allUsers: [users!]!
  }

  type Mutation {
    createUser(name: String!,email: String!,hash: String!): users!
    getUser(email: String!): users!
  }

`;
