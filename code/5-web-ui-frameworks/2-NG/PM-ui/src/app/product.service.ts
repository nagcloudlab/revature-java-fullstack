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


}