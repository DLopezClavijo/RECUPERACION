'use strict'

var path = require('path');
var fs = require('fs');

var Singer = require('../models/singer');
var Album = require('../models/album');


var mongoosePaginate = require('mongoose-pagination');

function getAlbum(req, res) {
	
	var albumId = req.params.id;

	
	Album.findById(albumId).populate({path: "singer"}).exec((err, album) => {
		if (err) {
			res.status(500).send({message: 'Error en la petición'});
		} else {
			if (!album) {
				res.status(404).send({message: 'No existe el album'});
			} else {
				res.status(200).send({album});
			}
		}
	});
}

function saveAlbum(req, res) {
	
	var album = new Album();

	var params = req.body;

	album.name = params.name;
	album.year = params.year;
	album.image = 'null';
	album.singer = params.singer;

	album.save((err, albumStored) => {
		if (err) {
			res.status(500).send({message: 'Error en la petición'});
		} else {
			if (!albumStored) {
				res.status(404).send({message: 'No se ha guardado al album'});
			} else {
				res.status(200).send({album: albumStored});
			}
		}
	});
}

function getAlbums(req, res) {

	var singerId = req.params.singer;

	if (!singerId) {

		var find = Album.find({}).sort('name');
	} else {
		var find = Album.find({singer: singerId}).sort('name');
	}

	find.populate({path: 'singer'}).exec((err, albums) => {
		if (err) {
			res.status(500).send({message: 'Error en la petición'});
		} else {
			if (!albums) {
				res.status(404).send({message: 'No hay albumes'});
			} else {
				res.status(200).send({albums});
			}
		}
	});
}

function updateAlbum(req, res) {

	var albumId = req.params.id;

	var update = req.body;

	Album.findByIdAndUpdate(albumId, update, (err, albumUpdated) => {
		if (err) {
			res.status(500).send({message: 'Error en la petición'});
		} else {
			if (!albumUpdated) {
				res.status(404).send({message: 'No se ha podido actualizar al album'});
			} else {
				res.status(200).send({album: albumUpdated});
			}
		}
	});
}

function deleteAlbum(req, res) {

	var albumId = req.params.id;

	Album.findByIdAndRemove(albumId, (err, albumRemoved) => {
		if (err) {
			res.status(500).send({message: 'Error en la petición'});
		} else {
			if (!albumRemoved) {
				res.status(404).send({message: 'No se ha podido borrar al album'});
			} else {
				res.status(200).send({album: albumRemoved});
			}
		}
	});
}



module.exports = {
	getAlbum,
	saveAlbum,
	getAlbums,
	updateAlbum,
	deleteAlbum
};