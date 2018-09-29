//Globals
var SERVER = "mongodb"
var DBUSER = "admin"
var DBPASSWORD = "admin123"
var CONECTION = "@ds115193.mlab.com:15193"
var DB = "sportec"
var PATH = SERVER + "://" + DBUSER + ":" + DBPASSWORD + CONECTION + "/" + DB

//db conection
export function dbConnect(){
    mongoose.connect(PATH, { useMongoClient: true }, () => {
        console.log("DB is connected")
    })
}
