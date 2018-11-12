// importamos la función de crear un servidor del módulo nativo HTTP
const { createServer } = require('http');
// importamos express
const express = require('express');
// imporatmos los middlewares body-parser, cors, compression y morgan
const bodyParser = require('body-parser');
const cors = require('cors');
const compression = require('compression');
const morgan = require('morgan');
// imporatmos nuestro middleware para combinar express con GraphQL y GraphiQL para tener el IDE
const { graphqlExpress, graphiqlExpress } = require('graphql-server-express');
// importamos una de las herramientas que nos provee `graphql-tools`, ya vamos a ver que hace
const { makeExecutableSchema } = require('graphql-tools');

// imporatmos nuestro modelo
const { Todo } = require('./connectionSQL');
// nuestro esquema
const typeDefs = require('./schema/usersSchema');
// nuestros resolvers
const resolvers = require('./resolver');

// definimos en constantes nuestras variables de entorno
const PORT = process.env.PORT || 3002;
const HOST = process.env.HOST || 'localhost';
const NODE_ENV = process.env.NODE_ENV || 'development';

// creamos una función asíncrona autoejecutable para poder usar Async/Await
(async () => {
	    // creamos una aplicación de express y un servidor HTTP apartir de esta
    const app = express();
	const server = createServer(app);

	// usamos 3 los middlewares que importamos
	app.use(cors());
	app.use(compression());
	app.use(morgan('common'));

    // combinamos nuestro esquema (`typeDefs`) y nuestros resolvers para crear un schema ejecutable
    const schema = makeExecutableSchema({ typeDefs, resolvers });

	// definimos la URL `/graphql` que usa los middlewares `body-parser` y el `graphqlExpress`// usando el esquema ejecutable que creamos
	app.use('/users', bodyParser.json(), graphqlExpress({ schema }));

    // si no estamos en producción
    if (NODE_ENV !== 'production') {
		// usamos el middleware `graphiqlExpress` para crear la URL `/ide` donde cargamos GraphiQL// este IDE va a consumir datos de la URL `/graphql` que creamos antes y `/subscriptions`
		app.use('/graphiql', graphiqlExpress({
			endpointURL: '/users',
		}));
	}

	// iniciamos el servidor en el puerto y host que obtuvimos por variables de entorno
	server.listen(PORT, HOST, error => {
        // luego mostramos un simple log indicando la URL donde corre el servidor
        console.log('> Server running on http://%s:%d', HOST, PORT)
	});
})();