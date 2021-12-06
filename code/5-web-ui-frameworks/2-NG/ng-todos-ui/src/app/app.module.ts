import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TodoFormComponent } from './todo-form/todo-form.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import {RouterModule, Routes} from "@angular/router";
import { TodoViewComponent } from './todo-view/todo-view.component';
import { TodosFooterComponent } from './todos-footer/todos-footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatNativeDateModule} from '@angular/material/core';
import {MaterialModule} from "./material.module";
import {ReactiveFormsModule} from "@angular/forms";


const routes:Routes=[
  {path:'', pathMatch:"full", redirectTo:'todo-list/all'},
  {path:'todo-list', pathMatch:"full", redirectTo:'todo-list/all'},
  {path:'todo-list/:filter',component:TodoListComponent},
  {path:'new-todo',component:TodoFormComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    TodoFormComponent,
    TodoListComponent,
    TodoViewComponent,
    TodosFooterComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MaterialModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
