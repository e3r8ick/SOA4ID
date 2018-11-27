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
		//let jsonResponse = JSON.stringify(JSON.parse(body), null, '  ');
		let jsonResponseArray = JSON.parse(body)
		//console.log(jsonResponseArray.length)
		//res.send(jsonResponse);

		var nIds = (jsonResponseArray.length)-1;
		var faceIdArray = "["
	
		for(var i = 0; i < nIds; i++){
			if(i+1 == nIds){
				faceIdArray += '"'+ jsonResponseArray[i]['faceId']+ '"';
				faceIdArray += "]";
			}else{
				faceIdArray += '"'+ jsonResponseArray[i]['faceId'] +'"';
				faceIdArray += ",";
			}
		}
		//console.log(faceIdArray);

		//options for the request 
		const options = {
			uri: uriBase+"/identify",
			qs: params,
			body: '{"faceIds":'+ faceIdArray +',"personGroupId": "users"}',
			headers: {
				'Content-Type': 'application/json',
				'Ocp-Apim-Subscription-Key' : subscriptionKey
			}
		};
		//console.log(options);
		// request to the FACE API
		request.post(options, (error, response, body) => {
			if (error) {
			  console.log('Error: ', error);
			  return;
			}
			let jsonResponse = JSON.stringify(JSON.parse(body), null, '  ');
			let jsonResponseArray = JSON.parse(body)
			//res.send(jsonResponse);

			var nPersons = jsonResponseArray.length;
			let personsArray= new Array();
			var y = 0;
			
			for(var z =1; z < nPersons; z++){
				//console.log(jsonResponseArray[z]['candidates'].length);
				//console.log(jsonResponseArray[z]['candidates']);
				if(jsonResponseArray[z]['candidates'].length == 1){
					personsArray[y]  = jsonResponseArray[z]['candidates'][0]['personId'];
					//console.log( jsonResponseArray[z]['candidates'][0]['personId']);
					y++;
				}
			}
			console.log(personsArray)
			//for(var j = 0; j < nIds; j++){

				//options for the request 
				const options = {
					uri: uriBase+"/persongroups/users/persons/" + personsArray[0],
					qs: params,
					headers: {
						'Content-Type': 'application/json',
						'Ocp-Apim-Subscription-Key' : subscriptionKey
					}
				};
				

				request.post(options, (error, response, body) => {
					if (error) {
					console.log('Error: ', error);
					return;
					}
					let jsonResponse = JSON.stringify(JSON.parse(body), null, '  ');
					let jsonResponseArray = JSON.parse(body)
					console.log(jsonResponseArray.length)
					res.send(jsonResponse);
				});
			//}
	    });
	});  
});


//https://www.larepublica.net/storage/images/2018/02/21/201802210902310.facebook-sele.jpg
//https://ep01.epimg.net/especiais/2018/copa-do-mundo/img/selecciones/costa-rica.jpg