
var express = require("express")
var mongoose = require('mongoose');
var app = express()
app.listen("3010",()=>{
    console.log("I just started listening!.")
})


var conString = "mongodb://admin:admin123@ds115193.mlab.com:15193/sportec"
/**
 * Models
 */
var User = mongoose.model("User", {
    firstName: String,
    lastName: String,
    hash: String
})


mongoose.connect(conString, { useMongoClient: true }, () => {
    console.log("DB is connected")
})


var dummyUser = {
    firstName: "Erick",
    lastName: "Cordero",
    hash: "123456"
}

mongoose.connect(conString, { useMongoClient: true }, () => {
    console.log("DB is connected")
    saveData()
})


function saveData() {
    var user = new User(dummyUser);
    user.save();
}
