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
app.use(bodyParser.urlencoded({extended:true}));

//host
var server = app.listen(3000, function(){
    var host = server.address().address;
    var port = server.address().port;

    console.log("App escuchando en http://%s:%s",host,port);
})

//db conection
mongoose.connect(PATH, { useMongoClient: true }, () => {
    console.log("DB is connected")
})

//////////////////////////////////SCHEMAS///////////////////////////////////////////

var userSchema = new mongoose.Schema({
    type: String,
    name: String,
    email: String,
    hash: String
})

var challengesSchema = new mongoose.Schema({
    type: String,
    sport: String,
    teamA: String,
    teamB: String
})


var newsSchema = new mongoose.Schema({
    type: String,
    title: String,
    subtitle: String
})

var teamsSchema = new mongoose.Schema({
    type: String,
    name: String,
    picture: String,
    members: Array
})

var resultSchema = new mongoose.Schema({
    type: String,
    typeResult: String,
    info: String,
    url: String
})

var sportsSchema =new mongoose.Schema({
    type: String,
    name: String,
    picture: String
})

//////////////////////////////////MODELS///////////////////////////////////////////

var userModel = mongoose.model("user", {
    type: String,
    name: String,
    email: String,
    hash: String
})

var challengesModel =mongoose.model("challenges", {
    type: String,
    sport: String,
    teamA: String,
    teamB: String
})


var newsModel = mongoose.model("news", {
    type: String,
    title: String,
    subtitle: String
})

var teamsModel = mongoose.model("teams", {
    type: String,
    name: String,
    picture: String,
    members: Array
})

var resultModel = mongoose.model("results", {
    type: String,
    typeResult: String,
    info: String,
    url: String
})

var sportsModel = mongoose.model("sports", {
    type: String,
    name: String,
    picture: String
})


///////////////////////////////////CRUD/////////////////////////////////////////////

//user crud
app.get("/user/login", function(req,res,next){
    var userEmail = req.query.email;
    var userHash = req.query.hash;
    if(req.query.email){
        if(req.query.hash){
            var user = mongoose.model('users', userSchema);
            user.find({ 'email': userEmail, 'hash': userHash }, 'name email', function (err, users) {
            if (err) return handleError(err);
            res.send(JSON.stringify(users))
            })
        }
        else{
            res.send(JSON.stringify("[{Empty Password}]"))
        }
    }
    else{
        res.send(JSON.stringify("[{Empty Email}]"))
    }
});

app.get("/user", function(req,res,next){
    var userEmail = req.query.email;
    if(req.query.email){
        var user = mongoose.model('users', userSchema);
        user.find({ 'email': userEmail}, 'name email', function (err, users) {
        if (err) return handleError(err);
        res.send(JSON.stringify(users))
        })
    }
    else{
        res.send(JSON.stringify("[{Empty email}]"))
    }
});

app.post("/user/register", function(req,res,next){
    var userEmail = req.query.email;
    var userHash = req.query.hash;
    var userName = req.query.name;
    if(req.query.email){
        if(req.query.hash){
            if(req.query.name){
                var newUser = {
                    type: "0",
                    name: userName,
                    email: userEmail,
                    hash: userHash
                }
                new userModel(newUser).save();
                res.send(JSON.stringify(newUser))
            }
            else{
                res.send(JSON.stringify("[{Empty name}]"))
            }
        }
        else{
            res.send(JSON.stringify("[{Empty hash}]"))
        }
    }
    else{
        res.send(JSON.stringify("[{Empty email}]"))
    }
});

app.post("/user", function(req,res,next){
    try{
        var userEmail = req.query.email;
        var userHash = req.query.hash;
        var user = mongoose.model('users', userSchema);
        user.find({ 'email': userEmail, 'hash': userHash }, 'name email', function (err, users) {
        if (err) return handleError(err);
        res.send(JSON.stringify(users))
        })
    }
    catch(err){
        res.send(JSON.stringify(err))
    }
});

app.put("/user", function(req,res,next){
    res.send("update user");
});

app.delete("/user", function(req,res,next){
    res.send("delete user");
});

//news crud
app.get("/news", function(req,res,next){
    res.send("read news");
});

app.post("/news", function(req,res,next){
    res.send("create news");
});

app.put("/news", function(req,res,next){
    res.send("update news");
});

app.delete("/news", function(req,res,next){
    res.send("delete news");
});

//challenges crud
app.get("/challenges", function(req,res,next){
    res.send("read challenges");
});

app.post("/challenges", function(req,res,next){
    res.send("create challenges");
});

app.put("/challenges", function(req,res,next){
    res.send("update challenges");
});

app.delete("/challenges", function(req,res,next){
    res.send("delete challenges");
});

//sports crud
app.get("/sports", function(req,res,next){
    res.send("read sports");
});

app.post("/sports", function(req,res,next){
    res.send("create sports");
});

app.put("/sports", function(req,res,next){
    res.send("update sports");
});

app.delete("/sports", function(req,res,next){
    res.send("delete sports");
});

//results crud
app.get("/results", function(req,res,next){
    res.send("read results");
});

app.post("/results", function(req,res,next){
    res.send("create results");
});

app.put("/results", function(req,res,next){
    res.send("update results");
});

app.delete("/results", function(req,res,next){
    res.send("delete results");
});

//teams crud
app.get("/teams", function(req,res,next){
    res.send("read teams");
});

app.post("/teams", function(req,res,next){
    res.send("create teams");
});

app.put("/teams", function(req,res,next){
    res.send("update teams");
});

app.delete("/teams", function(req,res,next){
    res.send("delete teams");
});
