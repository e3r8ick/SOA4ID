//require
var express = require("express")
var mongoose = require('mongoose');
var bodyParser = require("body-parser");

var app = express()

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));

//host
// app.listen("3010",()=>{
//     console.log("I just started listening!.")
// })
//
// var clothes = [
//     "pantalones",
//     "camisas",
//     "medias",
//     "gorras"
// ];
//
// app.get("/", function(req,res,next){
//     res.send("Hola mundo!!!");
// });
//
// app.post("/clothes",function(req,res,next){
//     if(req.body.cloth){
//         clothes.push(req.body.cloth);
//     }
//
//     res.send(JSON.stringify(clothes));
// });
//
// app.get("/clothes", function(req,res,next){
//     res.send(JSON.stringify(clothes));
// });

var conString = "mongodb://admin:admin123@ds115193.mlab.com:15193/sportec"
/**
 * Models
 */
var News = mongoose.model("news", {
    type: String,
    title: String,
    subtitle: String
})

var Users = mongoose.model("users", {
    type: String,
    name: String,
    email: String,
    hash: String
})


var dummyUser2 = {
    type: "0",
    name: "Erick Cordero Rojas",
    email: "eguicoro2@gmail.com",
    hash: "123456"
}

var dummyUser = {
    type: "1",
    title: "La Sele campeón del mundial de FIFA",
    subtitle: "Pinto lo logra esta vez"
}

mongoose.connect(conString, { useMongoClient: true }, () => {
    console.log("DB is connected")
    saveData()
})


function saveData() {
    var user = new Users(dummyUser2);
    var news = new News(dummyUser);
    user.save();
    news.save();
}
