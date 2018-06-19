import {Component, OnInit} from '@angular/core';

import { Router, ActivatedRoute, Params} from '@angular/router';

import { UserService } from '../services/user.service';

import { Singer } from '../models/singer';

import { GLOBAL } from '../services/global';

import { SingerService } from '../services/singer.service';

@Component ({
	selector: 'singer-add',
	templateUrl: '../views/singer-add.html',
	providers: [UserService, SingerService]
})

export class SingerAddComponent implements OnInit {
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
		this.titulo = 'Añadir Singer';

		this.identity = this._userService.getIdentity();
		this.token = this._userService.getToken();

		this.url = GLOBAL.url;

		this.singer = new Singer('','','');
	}

	ngOnInit() {
		console.log("añadir artistas");
	}

	onSubmit() {
		console.log(this.singer);

		this._singerService.addSinger(this.token, this.singer).subscribe(
			response => {
				if (!response.singer) {
					this.alertMessage = 'Error del Servidor';
				} else {
					this.alertMessage = 'Singer Guardado';

					this.singer = response.singer; 
					
					this._router.navigate(['/editar-singer', response.singer._id]);
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
	}
}