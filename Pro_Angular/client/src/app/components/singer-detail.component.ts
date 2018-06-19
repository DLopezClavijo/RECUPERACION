import {Component, OnInit} from '@angular/core';

import { Router, ActivatedRoute, Params} from '@angular/router';

import { UserService } from '../services/user.service';

import { Singer } from '../models/singer';

import { GLOBAL } from '../services/global';

import { SingerService } from '../services/singer.service';

@Component ({
	selector: 'singer-detail',
	templateUrl: '../views/singer-detail.html',
	providers: [UserService, SingerService]
})

export class SingerDetailComponent implements OnInit {
	public titulo: string;

	public singer: Singer;

	public identity;

	public token;

	public url: string;

	public alertMessage;

	constructor(
		private _route: ActivatedRoute,
		private _router: Router,
		private _userService: UserService,
		private _singerService: SingerService
	) {
		this.titulo = 'Detalles del Singer';

		this.identity = this._userService.getIdentity();
		this.token = this._userService.getToken();

		this.url = GLOBAL.url;
	}

	ngOnInit() {
		
		this.getSinger();
	}

	getSinger() {
		
		this._route.params.forEach((params: Params) => {
			let id = params['id'];
			this._singerService.getSinger(this.token, id).subscribe(
				response => {
					if (!response.singer) {
					
						this._router.navigate(['/']);
					} else {
						this.singer = response.singer;
					}
				}, error => {
					var errorMessage = <any>error;
	                if (errorMessage != null) {
	                  var body = JSON.parse(error._body);
	                  this.alertMessage = body.message;
	                  console.log(error);
	                }
				}
			);
		});
	}
}