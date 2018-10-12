var mongoose = require('mongoose');

var userSchema = new mongoose.Schema({
    type: String,
    name: String,
    email: String,
    hash: String
})

module.exports = userSchema;
