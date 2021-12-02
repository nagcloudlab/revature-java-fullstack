import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  apiUrl = "http://localhost:8080/api/products";

  constructor(private httpClient: HttpClient) { }

  getAllProducts() {
    return this.httpClient.get(this.apiUrl);// async http-call using XHR api
  }
  getProduct(productId: number) {
    return this.httpClient.get(this.apiUrl + "/" + productId);// async http-call using XHR api
  }
  deleteProduct(productId: number) {
    return this.httpClient.delete(`${this.apiUrl}/${productId}`)
  }
  saveProduct(product: any) {
    return this.httpClient.post(this.apiUrl, product)
  }
  updateProduct(productId: number, product: any) {
    return this.httpClient.put(this.apiUrl + "/" + productId, product);
  }


}
