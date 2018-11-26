// importamos sequelizeconst 
Sequelize = require('sequelize');

// SQL connection
const sequelize = new Sequelize('postgres://jhfhtpde:VSvplyou_vBjl_uXd7Mfa1ofIDPMAP3Z@tantor.db.elephantsql.com:5432/jhfhtpde');

// definimos nuestro modelo 
const sportsModel = sequelize.define(
	'sports',
	{
		_id: {
			type: Sequelize.UUID,
			primaryKey: true,
			unique: true,
		},
		type: {
			type: Sequelize.INTEGER,
		},
		name: {
			type: Sequelize.STRING,
		},
		
	},
	{
		indexes: [
			{
				unique: true,
				fields: ['_id'],
			},
		],
	}
);

// exportamos nuestra conexión a la base de datos y nuestro modelo
module.exports = {
	db: sequelize,
	sportsModel,
};