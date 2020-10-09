import { todolist } from './../data/todolist';
import { AppComponent } from './../app.component';
import { user } from './../data/user';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http"
import { LoggedUserServiceService } from './logged-user-service.service';

@Injectable({
  providedIn: 'root'
})

export class ListApiService {
  constructor(private httpClient: HttpClient, private userData: LoggedUserServiceService) { }


  getlists(): Observable<any>{
    console.log("from apo list service getting the lists");
   this.httpClient.get("http://localhost:8080/list").subscribe(
    );

    this.userData.changeMylists(this.httpClient.get("http://localhost:8080/list"));
    return this.httpClient.get("http://localhost:8080/list")
  }

  getListByUid(user:user): Observable<any>{
    return this.httpClient.get("http://localhost:8080/list/user/" + user.id)
  }

  savelist(listTosave: todolist){
    let save = this.httpClient.post("http://localhost:8080/list",listTosave).subscribe(

    );

  }


}
