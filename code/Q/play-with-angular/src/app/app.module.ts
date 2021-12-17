import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterModule, Routes} from "@angular/router";
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CustomerRegisterFormComponent } from './customer-register-form/customer-register-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import { ShopComponent } from './shop/shop.component';

const routes:Routes=[
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'shop',
    component:ShopComponent
  },
  {
    path:'about',
    component:AboutComponent
  },
  {
    path:'dashboard',
    component:DashboardComponent
  },
  {
    path:'customer-register',
    component:CustomerRegisterFormComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    DashboardComponent,
    CustomerRegisterFormComponent,
    ShopComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
