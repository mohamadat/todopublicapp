import { todoTask } from './../data/task';
import { TaskService } from './../services/task.service';
import { Observable } from 'rxjs';
import { todolist } from './../data/todolist';
import { ListApiService } from './../services/list-api.service';
import { LoggedUserServiceService } from './../services/logged-user-service.service';
import { Component, OnInit } from '@angular/core';
import { user } from '../data/user';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  selectedList:todolist;
  constructor(private userData: LoggedUserServiceService, private _listservice: ListApiService, private _taskservice: TaskService) { }
  loginuser:user;
  tosavelist:todolist;
  allLists:todolist[];
  public mytask = new todoTask;
  allmytasks:todolist[];



  ngOnInit(): void {
    this.mytask.title = "koko";
    this.userData.currentUser.subscribe(loginuser =>{ this.loginuser = loginuser});
    //get all lists of logged in user
    this._listservice.getListByUid(this.loginuser).subscribe(
      data=>{
            this.allLists = data;
      }
    );

    // this.allLists = this._listservice.getlists();
    // call the api service to get all lists on intit
    console.log("all lists are" + this.allLists);
  }
  onSubmit(data) {
    this.allLists.push(data);

    // add the user info to the list befor sending the list to the BE
    data.uid = this.loginuser.id;
    console.log("from component" + data.title);
    this._listservice.savelist(data);
  }

  //call the api ang get list tasks then show it
  //get up one list tasks
  showTodo(list, task){
    this.selectedList = list;
    this._taskservice.getTasksByList(list).subscribe(
    data=>{this.allmytasks = data;}
  );
  }

  CreateTodo(data,task){
    console.log("the task is" + data.id);
     this.allmytasks.push(task);
    this._taskservice.saveTask(task, data);
    console.log("done + data " + data + task.title);
  }



}
