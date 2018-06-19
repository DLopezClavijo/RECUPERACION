import {Component, OnInit} from '@angular/core';

import { Router, ActivatedRoute, Params} from '@angular/router';

import { UserService } from '../services/user.service';

import { SingerService } from '../services/singer.service';

import { Singer } from '../models/singer';

import { GLOBAL } from '../services/global';

@Component ({
	selector: 'singer-list',
	templateUrl: '../views/singer-list.html',
	providers: [UserService, SingerService]
})

export class SingerListComponent implements OnInit {
	public titulo: string;

	public singers: Singer[];

	public identity;

	public token;

	public url: string;

	public next_page;

	public prev_page;

	public confirmado;

	constructor(
		private _route: ActivatedRoute,
		private _router: Router,
		private _userService: UserService,
		private _singerService: SingerService
	) {
		this.titulo = 'Artistas';

		this.identity = this._userService.getIdentity();
		this.token = this._userService.getToken();

		this.url = GLOBAL.url;

		this.next_page = 1;
		this.prev_page = 1;
	}

	ngOnInit() {
		console.log("listado de artistas");

		this.getSingers();
	}

	getSingers() {
		this._route.params.forEach((params: Params) => {
			let page = +params['page'];

			if (!page) {
				page = 1;
			} else {
				this.next_page = page + 1;
				this.prev_page = page - 1;

				if (this.prev_page == 0) {
					this.prev_page = 1;
				}
			}

			this._singerService.getSingers(this.token, page).subscribe(
				response => {
					if (!response.singers) {
						this._router.navigate(['/']);
					} else {
						this.singers = response.singers;
					}
				}, error => {
					var errorMessage = <any>error;
	                if (errorMessage != null) {
	                  var body = JSON.parse(error._body);
	                  console.log(error);
	                }
				}
			);
		});
	}

	onDeleteConfirm(id) {
		this.confirmado = id;
	}

	onCancelSinger() {
		this.confirmado = null;
	}

	onDeleteSinger(id) {
		this._singerService.deleteSinger(this.token, id).subscribe(
			response => {
				console.log(response.singer);
				if (!response.singer) {
					alert('Error del servidor');
				} else {
					this.getSingers();
				}
			}, error => {
				var errorMessage = <any>error;
                if (errorMessage != null) {
                  var body = JSON.parse(error._body);
                  console.log(error);
                }
			}
		);
	}
}