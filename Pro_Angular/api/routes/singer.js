'use strict'

var express = require('express');

var SingerController = require('../controllers/singer');

var md_auth = require('../middlewares/authenticated');


var multipart = require('connect-multiparty');
var md_upload = multipart({uploadDir: './uploads/singers'});


var api = express.Router();

api.get('/singer/:id', md_auth.ensureAuth, SingerController.getSinger);
api.post('/singer', md_auth.ensureAuth, SingerController.saveSinger);
api.get('/singers/:page?', md_auth.ensureAuth, SingerController.getSingers);
api.put('/singer/:id', md_auth.ensureAuth, SingerController.updateSinger);
api.delete('/singer/:id', md_auth.ensureAuth, SingerController.deleteSinger);



module.exports = api;