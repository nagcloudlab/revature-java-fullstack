import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CartService } from '../cart.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent {

  @Input("value") product: any;

  reviews: Array<any> = []

  currentTab: number = 1;

  constructor(
    private cartService: CartService,
    private productService: ProductService
  ) { }

  handleTabChange(e: Event, tabIndex: number) {
    e.preventDefault();
    // console.log("handling tab change..");
    // console.log(e);
    // console.log(tabIndex);
    this.currentTab = tabIndex;
    if (this.currentTab === 3) {
      this.productService.getReviews(this.product.id)
        .subscribe({
          next: (response: any) => {
            this.reviews = response;
          }
        })
    }
  }
  handleBuy(event: Event) {
    //this.buy.emit(this.product)
    this.cartService.addToCart(this.product)
  }

}
