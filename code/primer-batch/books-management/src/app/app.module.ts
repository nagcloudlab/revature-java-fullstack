import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BookFormComponent } from './book-form/book-form.component';
import { BookListComponent } from './book-list/book-list.component';
import {RouterModule, Routes} from "@angular/router";
import { LoginFormComponent } from './login-form/login-form.component';


const routes:Routes=[
  {
    path:'',
    pathMatch:'full',
    redirectTo:'login',
  },
  {
    path:'form',
    component:BookFormComponent
  },
  {
    path:'list',
    component:BookListComponent
  },
  {
    path:'login',
    component:LoginFormComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BookFormComponent,
    BookListComponent,
    LoginFormComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
