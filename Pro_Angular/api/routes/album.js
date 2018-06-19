'use strict'

var express = require('express');

var AlbumController = require('../controllers/album');

var md_auth = require('../middlewares/authenticated');


var multipart = require('connect-multiparty');
var md_upload = multipart({uploadDir: './uploads/albums'});


var api = express.Router();

api.get('/album/:id', md_auth.ensureAuth, AlbumController.getAlbum);
api.post('/album', md_auth.ensureAuth,AlbumController.saveAlbum);
api.get('/albums/:singer?', md_auth.ensureAuth, AlbumController.getAlbums);
api.put('/album/:id', md_auth.ensureAuth, AlbumController.updateAlbum);
api.delete('/album/:id', md_auth.ensureAuth, AlbumController.deleteAlbum);


module.exports = api;