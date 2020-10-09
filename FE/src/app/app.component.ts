import { user } from './data/user';
import { UserApiService } from './services/user-api.service';
import { Component } from '@angular/core';
import { LoggedUserServiceService } from './services/logged-user-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  title = 'todo';
  loggedUser = new user();
  static loggeduser: object;
  lstusers:user[];
  // public loginuser = new user();
  public sss = "new user";
  loginuser:user;

  constructor(private _UserApiService: UserApiService, private userData: LoggedUserServiceService){

  }

  ngOnInit(){
    // this.loginuser.uname = "atwa";
    // console.log(this.loginuser);
    this.userData.currentUser.subscribe(loginuser => this.loginuser = loginuser)

    this._UserApiService.getusers().subscribe(
      data=>{
        this.lstusers = data;
      }
    );
  }


}



