import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) { }

  getProducts() {
    // uses browser's XHR API
    return this.httpClient.get("http://localhost:8080/api/products")
  }

}
