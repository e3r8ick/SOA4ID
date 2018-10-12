function buildUserApi(app) {
    
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


}


module.exports = buildUserApi;