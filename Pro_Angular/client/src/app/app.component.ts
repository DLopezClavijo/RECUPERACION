import { Component } from '@angular/core';
import { Router, ActivatedRoute, Params} from '@angular/router';
import { User } from './models/user';
import { UserService } from './services/user.service';
import { GLOBAL } from './services/global';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  providers:[UserService]
})
export class AppComponent {
  public title = 'MySpace Cutre';

  public user: User; 

  public user_register : User; 

  public identity; 

  public token; 

  public errorMessage; 

  public alertRegister; 

  public url:string;

  constructor(
    private _route: ActivatedRoute,
    private _router: Router,
    private _userService:UserService) {
    
    this.user = new User('','','','','','ROLE_USER','');

    this.user_register = new User('','','','','','ROLE_USER','');

    this.url = GLOBAL.url;
  }

  public ngOnInit(){
  	this.identity = this._userService.getIdentity();
    this.token = this._userService.getToken();

    console.log(this.identity);
    console.log(this.token);
  }

  public onSubmit() {
    

    this._userService.signup(this.user).subscribe(
      response => {
        
        this.identity = response.user; 

        if (!this.identity._id) {
          alert("Usuario incorrecto");
        } else {
          
          this._userService.signup(this.user, 'true').subscribe(
            response => {
              this.token = response.token;
              if (this.token.length <= 0) {
                alert("El token es incorrecto");
              } else {
                localStorage.setItem('identity', JSON.stringify(this.identity));
                localStorage.setItem('token', this.token);

                this.user = new User('','','','','','ROLE_USER','');
              }
            }, error => {
                var errorMessage = <any>error;
                if (errorMessage != null) {
                  var body = JSON.parse(error._body);
                  this.errorMessage = body.message;
                }
            }
          );
        }
      }, error => {
        var errorMessage = <any>error;
        if (errorMessage != null) {
          var body = JSON.parse(error._body);
          this.errorMessage = body.message;
        }
      }
    );
  }

  logout() {
    localStorage.removeItem('identity');
    localStorage.removeItem('token');

    localStorage.clear();

    this.identity = null;
    this.token = null;

    this._router.navigate(['/']); 
  }

  onSubmitRegister() {
    console.log(this.user_register);

    this._userService.register(this.user_register).subscribe(
      response => {
        this.user_register = response.user;
        if (!this.user_register._id) {
          this.alertRegister = 'Error al registrar';
        } else {
          this.alertRegister = 'Usuario registrado. Identifícate con ' + this.user_register.email;
          this.user_register = new User('','','','','','ROLE_USER','');
        }
      }, error => {
        var errorMessage = <any>error;
        if (errorMessage != null) {
          var body = error._body;
          this.alertRegister = body.message;
        }
      }
    );
  }
}
