import mongoose from 'mongoose';

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