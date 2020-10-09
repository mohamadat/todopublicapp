import { RegisterPageComponent } from './register-page/register-page.component';
import { TodoDocComponent } from './todo-doc/todo-doc.component';
import { TodoTaskComponent } from './todo-task/todo-task.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import { TodoUserComponent } from './todo-user/todo-user.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { path: 'user', component: TodoUserComponent},
  { path: 'task', component: TodoTaskComponent},
  { path: 'list', component: TodoListComponent},
  { path: 'doc', component: TodoDocComponent},
  { path: 'register', component: RegisterPageComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [TodoListComponent, TodoUserComponent, TodoDocComponent, TodoTaskComponent, RegisterPageComponent];
