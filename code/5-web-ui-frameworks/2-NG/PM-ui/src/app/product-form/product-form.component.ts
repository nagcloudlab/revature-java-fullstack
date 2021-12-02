import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {

  constructor(
    private productService: ProductService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  handleSubmit(event: Event, productFormGroup: NgForm) {
    const productFormModel = productFormGroup.value
    this.productService.saveProduct(productFormModel)
      .subscribe(response => {
        this.router.navigate(["/list"])
      });
  }


}
