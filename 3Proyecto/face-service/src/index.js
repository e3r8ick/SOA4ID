'use strict';
//require
var express = require("express")
var bodyParser = require("body-parser");
var app = express()
const request = require('request');

//Global
// Suscription key.
const subscriptionKey = 'cdc52fa64173455f97e4b57ea665ee36';
//suscription url
const uriBase = 'https://southcentralus.api.cognitive.microsoft.com/face/v1.0';


app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

//host
var server = app.listen(3006, function(){
  var host = server.address().address;
  var port = server.address().port;

  console.log("App escuchando en http://%s:%s",host,port);
})

app.get('/face', function(req,res) {
	var photoURL = req.query.photo;
	// Request parameters.
	const params = {
		'returnFaceId': 'true',
		'returnFaceLandmarks': 'false',
	};

	//options for the request 
	const options = {
		uri: uriBase+"/detect",
		qs: params,
		body: '{"url": ' + '"' + photoURL + '"}',
		headers: {
			'Content-Type': 'application/json',
			'Ocp-Apim-Subscription-Key' : subscriptionKey
		}
	};
	// request to the FACE API
	request.post(options, (error, response, body) => {
		if (error) {
		  console.log('Error: ', error);
		  return;
		}
		let jsonResponse = JSON.stringify(JSON.parse(body), null, '  ');
		res.send(jsonResponse);
	  });
});


//https://www.larepublica.net/storage/images/2018/02/21/201802210902310.facebook-sele.jpg
//https://ep01.epimg.net/especiais/2018/copa-do-mundo/img/selecciones/costa-rica.jpg