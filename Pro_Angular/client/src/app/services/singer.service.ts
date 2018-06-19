
import { Injectable } from '@angular/core';


import { Http, Response, Headers, RequestOptions } from '@angular/http';


import 'rxjs/add/operator/map';


import { Observable } from 'rxjs/Observable';

import { GLOBAL } from './global';

import { Singer } from '../models/singer';


@Injectable()
export class SingerService {

	public url:string;

	
	constructor(private _http: Http) {
		this.url = GLOBAL.url;
	}

	addSinger(token, singer: Singer) {
		let params = JSON.stringify(singer);

		let headers = new Headers({
			'Content-Type': 'application/json',
			'Authorization': token
		});

		return this._http.post(this.url + 'singer', params, {headers: headers}).map(res => res.json());
	}

	getSinger(token, id: string) {
		let headers = new Headers({
			'Content-Type': 'application/json',
			'Authorization': token
		});

		return this._http.get(this.url + 'singer/' + id, {headers: headers}).map(res => res.json());
	}

	getSingers(token, page) {
		let headers = new Headers({
			'Content-Type': 'application/json',
			'Authorization': token
		});

		return this._http.get(this.url + 'singers/' + page, {headers: headers}).map(res => res.json());
	}

	editSinger(token, id: string, singer: Singer) {
		let params = JSON.stringify(singer);

		let headers = new Headers({
			'Content-Type': 'application/json',
			'Authorization': token
		});

		return this._http.put(this.url + 'singer/' + id, params, {headers: headers}).map(res => res.json());
	}

	deleteSinger(token, id: string) {
		let headers = new Headers({
			'Content-Type': 'application/json',
			'Authorization': token
		});

		return this._http.delete(this.url + 'singer/' + id, {headers: headers}).map(res => res.json());
	}
}