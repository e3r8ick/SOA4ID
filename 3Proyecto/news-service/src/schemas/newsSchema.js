export default `
  type news {
    _id: String!
    type: String!,
    title: String!,
    subtitle: String!,
    sport: String!
  }

  type Query {
    allNews: [news!]!
  }

  type Mutation {
    createNews(title: String!, subtitle: String!, sport: String!): news!
    getNews(title: String!): news!
    updateNews(_id: String!,title: String!, subtitle: String!, sport: String!): news!
  }

`;
