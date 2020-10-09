import { todolist } from './../data/todolist';

import { user } from './../data/user';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http"
import { LoggedUserServiceService } from './logged-user-service.service';
import { todoTask } from '../data/task';

@Injectable({
  providedIn: 'root'
})


export class TaskService {
  delete(mytask: todoTask) {
    console.log("calling the api");
    return this.httpClient.delete("http://todo-ecs-alb-1402331110.us-east-1.elb.amazonaws.com/task/" + mytask.id).subscribe();
  }
  public allmytasks:Observable<todoTask[]>;
  allTasks: todoTask[];

  constructor(private httpClient: HttpClient) { }

  getTasks(): Observable<any>{
    return this.httpClient.get("http://todo-ecs-alb-1402331110.us-east-1.elb.amazonaws.com/task");
  }

  saveTask(taskToSave: any, list: todolist){
    taskToSave.lid = list.id;
    let save = this.httpClient.post("http://todo-ecs-alb-1402331110.us-east-1.elb.amazonaws.com/list/" + list.id ,taskToSave).subscribe();
  }

  updateTask(taskToSave: any, list_id){
    let save = this.httpClient.post("http://todo-ecs-alb-1402331110.us-east-1.elb.amazonaws.com/list/" + list_id ,taskToSave).subscribe();
  }

  getTasksByList(list:todolist): Observable<any>{
    return this.httpClient.get("http://todo-ecs-alb-1402331110.us-east-1.elb.amazonaws.com/list/" + list.id)
  }

}
