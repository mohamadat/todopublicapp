import { UserApiService } from './../services/user-api.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css'],
  providers: [UserApiService]
})
export class RegisterPageComponent implements OnInit {

  constructor(private _UserApiService:UserApiService,private _router: Router) { }
  public user={};

  ngOnInit(): void {
    // this.user.p
  }

  // register new user in the db then redirect to login page
  onSubmit(data) {
    this._UserApiService.saveuser(data);
    this._router.navigate(['/user'])


  }

}
