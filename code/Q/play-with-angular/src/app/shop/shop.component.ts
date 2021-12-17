import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  products=[
    {
      id:1,
      name:'Laptop',
      price:1000.00
    },
    {
      id:2,
      name:'Mobile',
      price:1000.00
    }
  ]
  cart:Array<any>=[]

  addToCart(product:any){
   this.cart.push(product)
  }

  constructor() { }

  ngOnInit(): void {
  }

}
