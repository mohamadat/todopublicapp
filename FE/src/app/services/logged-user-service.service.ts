import { todolist } from './../data/todolist';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { user } from '../data/user';

@Injectable({
  providedIn: 'root'
})
export class LoggedUserServiceService {
  private loggedUserSrc = new BehaviorSubject<user>(null);
  private mylists = new BehaviorSubject<Observable<todolist>>(null);
  currentUser = this.loggedUserSrc.asObservable();
  currentLists = this.mylists.asObservable();

  constructor() { }

  changeLoggedUser(toLoguser: user){
    this.loggedUserSrc.next(toLoguser);
  }

  changeMylists(userlists: Observable<any>){
    this.mylists.next(userlists);
  }
}
