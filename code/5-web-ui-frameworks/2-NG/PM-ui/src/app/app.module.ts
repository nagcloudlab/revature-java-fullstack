import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router'
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductsResolver } from './products.resolver';
import { ProductViewComponent } from './product-view/product-view.component';
import { ProductResolver } from './product.resolver';
import { AuthGuard } from './auth.guard';
import { LoginFormComponent } from './login-form/login-form.component';
import { FormStatusGuard } from './form-status.guard';
import { ProductDetailViewGuard } from './product-detail-view.guard';

const routes: Routes = [
  { path: '', pathMatch: 'full', component: HomeComponent },
  {
    path: 'new',
    component: ProductFormComponent,
    canActivate: [AuthGuard],
    canDeactivate: [FormStatusGuard]
  },
  {
    path: 'list',
    resolve: {
      products: ProductsResolver
    },
    canActivateChild: [ProductDetailViewGuard],
    component: ProductListComponent,
    children: [
      {
        path: "view/:productId",
        resolve: {
          product: ProductResolver
        },
        component: ProductViewComponent
      }
    ]
  },
  {
    path: "edit/:productId",
    resolve: {
      product: ProductResolver
    },
    component: ProductFormComponent
  },
  {
    path: 'login',
    component: LoginFormComponent
  }

]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductFormComponent,
    ProductListComponent,
    ProductViewComponent,
    LoginFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
