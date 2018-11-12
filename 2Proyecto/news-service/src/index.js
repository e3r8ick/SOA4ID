import express from 'express';

import News from './models/newsModel';

import { graphiqlExpress, graphqlExpress } from 'apollo-server-express';
import { makeExecutableSchema } from 'graphql-tools';

import typeDefs from './schemas/newsSchema';
import resolvers from './resolvers';

var connectionMongo = require('./connectionMongo');

const app = express();

const schema = makeExecutableSchema({
  typeDefs,
  resolvers
});

// settings
app.set('port', process.env.PORT || 3000);

app.use('/news', express.json(), graphqlExpress({
  schema,
  context: {
    News
  }
}))

app.use('/graphiql', graphiqlExpress({
  endpointURL: '/news'
}));

// start the server
app.listen(app.get('port'), () => {
  console.log('server on port', app.get('port'));
});
