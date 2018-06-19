'use strict'


var mongoose = require('mongoose');
	

var Schema = mongoose.Schema;


var AlbumSchema = Schema({
	name: String,
	year: Number,
	image: String,
	singer: {type: Schema.ObjectId, ref: 'Singer'}
});


module.exports = mongoose.model('Album', AlbumSchema);