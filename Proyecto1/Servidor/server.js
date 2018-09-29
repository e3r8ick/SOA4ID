//Globals
var SERVER = "mongodb"
var DBUSER = "admin"
var DBPASSWORD = "admin123"
var CONECTION = "@ds115193.mlab.com:15193"
var DB = "sportec"
var PATH = SERVER + "://" + DBUSER + ":" + DBPASSWORD + CONECTION + "/" + DB

//require
var express = require("express")
var mongoose = require('mongoose');
var bodyParser = require("body-parser");

var app = express()

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:false}));

//host
app.listen("3010",()=>{
     console.log("I just started listening!.")
})

//db conection
mongoose.connect(PATH, { useMongoClient: true }, () => {
    console.log("DB is connected")
})

///////////////////////////////////CRUD/////////////////////////////////////////////

app.get("/user", function(req,res,next){
    if(req.body.cloth){
        clothes.push(req.body.cloth);
    }
         res.send(JSON.stringify(clothes));
     });

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
