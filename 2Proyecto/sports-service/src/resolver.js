// importamos uuid para crear nuestros ID únicos
const uuid = require('uuid/v4');
// nos traemos nuestro modelo Todo
const { sportsModel } = require('./connectionSQL');

const resolvers = {
    Query: {
      allSports(){
        return sportsModel.findAll();
      }
    },
    Mutation: {
      createSport: async (parent, args, { Sports }) => {
        const sport = await new Sports(args).save();
        sport._id = sport._id.toString();
        sport.type = "4";
        return sport;
      }
    },
    Mutation: {
      getSport: async (parent, args, { Sports }) => {
        console.log(args);
        const sport = await Sports.find(args);
        return sport;
      }
    }
  }

  module.exports = resolvers;