
var conString = "mongodb://<dbuser>:<dbpassword>@ds115193.mlab.com:15193/sportec"
/**
 * Models
 */
var User = mongoose.model("User", {
    firstName: String,
    lastName: String
})


mongoose.connect(conString, { useMongoClient: true }, () => {
    console.log("DB is connected")
})


var dummyUser = {
    firstName: "Sibeesh",
    lastName: "Venu"
}

mongoose.connect(conString, { useMongoClient: true }, () => {
    console.log("DB is connected")
    saveData()
})


function saveData() {
    var user = new User(dummyUser);
    user.save();
}
