'use strict'


var User = require('../models/user');


var bcrypt = require('bcrypt-nodejs');


var jwt = require('../services/jwt');


var fs = require('fs');


var path = require('path');

function saveUser(req, res) {
	
	var user = new User();

	
	var params = req.body;

	console.log(params);

	user.name = params.name;
	user.surname = params.surname;
	user.email = params.email;
	user.role = "ROLE_USER";
	user.image = 'null';

	if (params.password) {

		bcrypt.hash(params.password, null, null, function(err, hash){
			user.password = hash;
			if (user.name != null && user.surname != null && user.email != null) {
				user.save((err, userStored) => {
					if (err) {
						res.status(500).send({message: 'Error al guardar el usuario'});
					} else {
						if (!userStored) {
							res.status(400).send({message: 'Error en el registro de usuario'});
						} else {
							res.status(200).send({user: userStored});
						}
					}
				});
			}
		});
	} else {
		res.status(500).send({message: 'Introduce la contraseña'});
	}
}

function loginUser(req, res) {
	var params = req.body;

	var email = params.email;
	var password = params.password;

	
	User.findOne({email: email.toLowerCase()}, (err, user) => {
		if (err) {
			res.status(500).send({message: 'Error en la petición'});
		} else {
			if (!user) {
				res.status(400).send({message: 'El usuario no existe'});
			} else {
				
				bcrypt.compare(password, user.password, function (err, check) {
					if (check) {
						if (params.gethash) {
							
							res.status(200).send({token: jwt.createToken(user)});
						} else {
							res.status(200).send({user});
						}
					} else {
						res.status(404).send({message: 'El usuario no se ha podido logear'});
					}
				});
			}
		}
	});
}

function pruebas(req, res) {
	res.status(200).send({message: 'Probando el controlador de Usuario'});
}

function updateUser(req, res) {
	
	var userId = req.params.id;

	var update = req.body;

	if (userId != req.user.sub) {
		return res.status(500).send({message: 'No tiene permisos para actualizar al usuario'});
	}

	User.findByIdAndUpdate(userId, update, (err, userUpdated) => {
		if (err) {
			res.status(500).send({message: 'Error en la petición'});
		} else {
			if (!userUpdated) {
				res.status(404).send({message: 'No se ha podido actualizar al usuario'});
			} else {
				res.status(200).send({user: userUpdated});
			}
		}
	});
}




module.exports = {
	pruebas,
	saveUser,
	loginUser,
	updateUser
}