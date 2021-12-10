import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  doLogin(credentials: any) {
    return this.httpClient.post("http://localhost:8080/login", credentials)
  }

  constructor(private httpClient: HttpClient) { }
}
