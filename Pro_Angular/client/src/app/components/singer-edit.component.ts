import {Component, OnInit} from '@angular/core';

import { Router, ActivatedRoute, Params} from '@angular/router';

import { UserService } from '../services/user.service';

import { Singer } from '../models/singer';

import { GLOBAL } from '../services/global';

import { SingerService } from '../services/singer.service';

import { UploadService } from '../services/upload.service';

@Component ({
	selector: 'singer-edit',
	templateUrl: '../views/singer-add.html',
	providers: [UserService, SingerService, UploadService]
})

export class SingerEditComponent implements OnInit {
	public titulo: string;

	public singer: Singer;

	public identity;

	public token;

	public url: string;

	public alertMessage;

	public is_edit;

	
	public filesToUpload : Array<File>;

	constructor(
		private _route: ActivatedRoute,
		private _router: Router,
		private _userService: UserService,
		private _singerService: SingerService,
		private _uploadService: UploadService
	) {
		this.titulo = 'Editar Cantante';

		this.identity = this._userService.getIdentity();
		this.token = this._userService.getToken();

		this.url = GLOBAL.url;

		this.singer = new Singer('','','');

		this.is_edit = true;
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

	onSubmit() {
		console.log(this.singer);

		this._route.params.forEach((params: Params) => {
			let id = params['id'];

			this._singerService.editSinger(this.token, id, this.singer).subscribe(
			response => {
				if (!response.singer) {
					this.alertMessage = 'Error del Servidor';
				} else {
					this.alertMessage = 'Singer Actualizado';

					
					if (!this.filesToUpload) {
						this._router.navigate(['/']);
					} else {
						this._uploadService.makeFileRequest(this.url+'upload-image-singer/'+id, [], this.filesToUpload, this.token, 'image')
							.then(
								(result: any) => {
									this._router.navigate(['/singers/1']);
								}, (error) => {
									console.log(error);
								}
							);
					}
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

	
	fileChangeEvent(fileInput: any) {
		this.filesToUpload = <Array<File>>fileInput.target.files;
	}
}