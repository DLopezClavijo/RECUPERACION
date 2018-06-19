'use strict'


var mongoose = require('mongoose');
var app = require('./app');


var port = process.env.PORT || 3977;

mongoose.Promise = global.Promise;

mongoose.connect('mongodb://localhost:27017/curso_angular', (err, res) => {
	if (err) {
		throw err;
	} else {
		console.log("Conexión correcta");

		
		app.listen(port, function () {
			console.log("Servidor escuchando en http://localhost:" + port);
		});
	}
})