module.exports = `
  type sports {
    _id: String!
    type: String!,
    name: String!,
  }

  type Query {
    allSports: [sports!]!
  }

  type Mutation {
    createSport(name: String!): sports!
    getSport(name: String!): sports!
  }

`;
