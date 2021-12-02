import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router'
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductsResolver } from './products.resolver';

const routes: Routes = [
  { path: '', pathMatch: 'full', component: HomeComponent },
  { path: 'new', component: ProductFormComponent },
  {
    path: 'list',
    resolve: {
      products: ProductsResolver
    },
    component: ProductListComponent,
  }
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductFormComponent,
    ProductListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
