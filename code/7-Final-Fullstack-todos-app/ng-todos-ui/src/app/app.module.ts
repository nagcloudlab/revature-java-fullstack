import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TodoFormComponent } from './todo-form/todo-form.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import { RouterModule, Routes } from "@angular/router";
import { TodoViewComponent } from './todo-view/todo-view.component';
import { TodosFooterComponent } from './todos-footer/todos-footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatNativeDateModule } from '@angular/material/core';
import { MaterialModule } from "./material.module";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { AuthGuard } from './auth.guard';
import { JwtInterceptorInterceptor } from './jwt-interceptor.interceptor';


const routes: Routes = [
  { path: '', pathMatch: "full", redirectTo: 'login-form' },
  { path: 'todo-list', pathMatch: "full", redirectTo: 'todo-list/all' },
  {
    path: 'todo-list/:filter',
    component: TodoListComponent,
    canActivate: [AuthGuard]
  },
  { path: 'new-todo', component: TodoFormComponent },
  { path: 'login-form', component: LoginFormComponent },
  { path: 'register-form', component: RegisterFormComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    TodoFormComponent,
    TodoListComponent,
    TodoViewComponent,
    TodosFooterComponent,
    LoginFormComponent,
    RegisterFormComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MaterialModule,
    RouterModule.forRoot(routes),
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
