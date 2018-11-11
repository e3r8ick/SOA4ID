import express from 'express';

import News from './models/newsModel';

import { graphiqlExpress, graphqlExpress } from 'apollo-server-express';
import { makeExecutableSchema } from 'graphql-tools';

import typeDefs from './schemas/newsSchema';
import resolvers from './resolvers';

import mongoose from 'mongoose';

const app = express();

//Globals
var SERVER = "mongodb"
var DBUSER = "admin"
var DBPASSWORD = "admin123"
var CONECTION = "@ds115193.mlab.com:15193"
var DB = "sportec"
var PATH = SERVER + "://" + DBUSER + ":" + DBPASSWORD + CONECTION + "/" + DB


mongoose.connect(PATH)
  .then(() => console.log('connected to db'))
  .catch(err => console.log(err));

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
