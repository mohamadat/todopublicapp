import { LoggedUserServiceService } from './../services/logged-user-service.service';
import { UserApiService } from './../services/user-api.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { user } from '../data/user';

@Component({
  selector: 'app-todo-user',
  templateUrl: './todo-user.component.html',
  styleUrls: ['./todo-user.component.css']
})
export class TodoUserComponent implements OnInit {
  loginuser:user = new user();

  constructor(private _router: Router, private _UserApiService:UserApiService,
    private userData: LoggedUserServiceService ){ }

  ngOnInit(): void {

    // update logged in user variable

    // this._router.navigate(['doc'])

  }

  onSubmit(data){
    console.log("i am clicked");
    // this.userData.currentUser.subscribe(loginuser => this.loginuser = loginuser);
     var logeduser = this._UserApiService.loginUser(data);
     console.log("inuser com " + logeduser);


  }

}
