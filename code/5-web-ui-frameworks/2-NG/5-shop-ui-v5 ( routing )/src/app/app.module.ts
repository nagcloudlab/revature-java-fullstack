import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductComponent } from './product/product.component';
import { CartViewComponent } from './cart-view/cart-view.component';
import { CartBadgeComponent } from './cart-badge/cart-badge.component';
import { DiscountPipe } from './discount.pipe';
import { ReviewComponent } from './review/review.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';





const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    resolve: {},
    canActivate: [],
    canActivateChild: [],
    canDeactivate: []
  },
  {
    path: 'products',
    component: ProductListComponent
  },
  {
    path: 'cart',
    component: CartViewComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  }
]





@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ProductListComponent,
    ProductComponent,
    CartViewComponent,
    CartBadgeComponent,
    DiscountPipe,
    ReviewComponent,
    HomeComponent,
    NotFoundComponent
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
