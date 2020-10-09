import { TaskService } from './../services/task.service';
import { todolist } from './../data/todolist';
import { todoTask } from './../data/task';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo-task',
  templateUrl: './todo-task.component.html',
  styleUrls: ['./todo-task.component.css']
})
export class TodoTaskComponent implements OnInit {
   @Input() mytask: todoTask;
   @Input() listtypes: todolist[];
   updatedtask = "";

  constructor(private _taskservice:TaskService) { }

  ngOnInit(): void {
  }
  onSubmit(data) {
  }

  onDelete(){
    this.mytask.title = this.updatedtask;
    this._taskservice.delete(this.mytask);

  }
  onUpdate(list_id){
    this.mytask.title = this.updatedtask;
    this._taskservice.updateTask(this.mytask,list_id);

  }

}
