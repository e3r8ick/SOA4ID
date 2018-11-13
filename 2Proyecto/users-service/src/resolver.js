// importamos uuid para crear nuestros ID únicos
const uuid = require('uuid/v4');
// nos traemos nuestro modelo Todo
const { usersModel } = require('./connectionSQL');

const resolvers = {
    Query: {
      allUsers(){
        return usersModel.findAll();
      }
    },
    Mutation: {
      createUser: async (parent, args, { Users }) => {
        const user = await new Users(args).save();
        user._id = user._id.toString();
        user.type = "4";
        return user;
      }
    },
    Mutation: {
      getUser: async (parent, args, { Users }) => {
        console.log(args);
        const user = await Users.find(args);
        return user;
      }
    },
    Mutation: {
      updateUser: async (parent, args, { Userss }) => {
        console.log(args);
        const users = await Userss.find(args);
        users._id = users._id.toString();
        users.name = args.name;
        users.hash = args.hash;
        users.email = args.email;
        return users;
      }
    }
  }

  module.exports = resolvers;