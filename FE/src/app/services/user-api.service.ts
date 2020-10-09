import { AppComponent } from './../app.component';
import { user } from './../data/user';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http"
import { LoggedUserServiceService } from './logged-user-service.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})


export class UserApiService {
  constructor(private _router: Router, private httpClient: HttpClient, private userData: LoggedUserServiceService) { }
  loginuser:user = new user;

  getusers(): Observable<any>{
    return this.httpClient.get("http://todo-ecs-alb-1402331110.us-east-1.elb.amazonaws.com/user");
  }

  loginUser(userTologIn: user):user{
    //log in user then change shared logged in user in the service
    this.httpClient.post<user>("http://todo-ecs-alb-1402331110.us-east-1.elb.amazonaws.com/login",userTologIn).subscribe(
      data => { this.loginuser = data;
      this.userData.changeLoggedUser(this.loginuser);
      console.log("saved" + this.loginuser.id );
    }
    );
    // redirect user
    return this.loginuser;

  }

  showTodo(){}

  saveuser(userTosave: user): user{

    let save = this.httpClient.post<user>("http://todo-ecs-alb-1402331110.us-east-1.elb.amazonaws.com/user",userTosave).subscribe(
      loginuser => this.loginuser = loginuser
    );
    this.userData.changeLoggedUser(this.loginuser);
    return this.loginuser;

  }




}
