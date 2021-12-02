import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  products: Array<any> = []

  constructor(private route: ActivatedRoute, private productService: ProductService) { }

  ngOnInit(): void {
    this.route.data
      .subscribe((data: any) => {
        this.products = data.products
      })
  }

  handleDelete(productId: number) {
    this.productService.deleteProduct(productId)
      .subscribe(response => {
        this.products = this.products.filter(p => p.id !== productId);
      })
  }

}
