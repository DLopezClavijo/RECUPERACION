'use strict'

var path = require('path');
var fs = require('fs');
var mongoosePaginate = require('mongoose-pagination');


var Album = require('../models/album');
var Singer = require('../models/singer');

function getSinger(req, res) {
	
	var singerId = req.params.id;

	Singer.findById(singerId, (err, singer) => {
		if (err) {
			res.status(500).send({message: 'Error al obtener el singer'});
		} else {
			if (!singer) {
				res.status(404).send({message: 'El singer no existe'});
			} else {
				res.status(200).send({singer});
			}
		}
	});
}

function getSingers(req, res) {
	
	if (req.params.page) {
		var page = req.params.page;
	} else {
		var page = 1;
	}

	
	var itemsPerPage = 3;

	Singer.find().sort('name').paginate(page, itemsPerPage, function (err, singers, total) {
		if (err) {
			res.status(500).send({message: 'Error al listar los artistas'});
		} else {
			if (!singers) {
				res.status(404).send({message: 'No hay artistas'});
			} else {
				res.status(200).send({pages: total, singers: singers});
			}
		}
	});
}

function saveSinger(req, res) {
	
	var singer = new Singer();

	
	var params = req.body;


	singer.name = params.name;
	singer.description = params.description;
	singer.image = 'null';

	
	singer.save((err, singerStored) => {
		if (err) {
			res.status(500).send({message: 'Error al guardar el singer'});
		} else {
			if (!singerStored) {
				res.status(404).send({message: 'El singer no se ha guardado'});
			} else {
				res.status(200).send({singer: singerStored});
			}
		}
	});
}//

function updateSinger(req, res) {
	
	var singerId = req.params.id;

	
	var update = req.body;

	Singer.findByIdAndUpdate(singerId, update, (err, singerUpdated) => {
		if (err) {
			res.status(500).send({message: 'Error al actualizar el singer'});
		} else {
			if (!singerUpdated) {
				res.status(404).send({message: 'El singer no se ha actualizado'});
			} else {
				res.status(200).send({singer: singerUpdated});
			}
		}
	});
}

function deleteSinger(req, res) {
	
	var singerId = req.params.id;

	Singer.findByIdAndRemove(singerId, (err, singerRemoved) => {
		if (err) {
			res.status(500).send({message: 'Error al borrar el singer'});
		} else {
			if (!singerRemoved) {
				res.status(404).send({message: 'El singer no se ha borrado'});
			} else {
				Album.find({singer: singerRemoved._id}).remove((err, albumRemoved) => {
					if (err) {
						res.status(500).send({message: 'Error al borrar el album'});		
					} else {
						if (!albumRemoved) {
							res.status(404).send({message: 'El album no se ha borrado'});
						} else {
							res.status(200).send({singer: singerRemoved});
						}
					}
				});
			}
		}
	});
}



module.exports = {
	getSinger,
	getSingers,
	saveSinger,
	updateSinger,
	deleteSinger
}