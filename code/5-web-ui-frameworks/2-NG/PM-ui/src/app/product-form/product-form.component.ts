import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {


  product: any = {
    name: '',
    price: '',
    is_available: true,
    img_path: '',
    description: ''
  }

  isEditMode = false;

  constructor(
    private productService: ProductService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {

    this.route.data.subscribe((data: any) => {
      if (data.product) {
        this.product = data.product;
        this.isEditMode = true;
      }
    })

  }

  handleSubmit(event: Event, productFormGroup: NgForm) {
    const productFormModel = productFormGroup.value
    if (this.isEditMode) {
      this.productService.updateProduct(this.product.id, productFormModel)
        .subscribe(response => {
          this.router.navigate(["/list"]) // programmtic routing
        });
    } else
      this.productService.saveProduct(productFormModel)
        .subscribe(response => {
          this.router.navigate(["/list"]) // programmtic routing
        });
  }

  cancelled = false;

  doCancel() {
    this.cancelled = true;
    this.router.navigate(['list'])
  }

}



