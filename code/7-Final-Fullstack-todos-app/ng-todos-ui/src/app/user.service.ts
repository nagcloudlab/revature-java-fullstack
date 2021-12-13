import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  userStream: BehaviorSubject<any> = new BehaviorSubject({})

  doLogin(credentials: any) {
    this.httpClient.post("http://localhost:8080/login", credentials)
      .subscribe({
        next: (response: any) => {
          localStorage.setItem("token", response.jwt);
          this.userStream.next({
            action: "LOGIN_SUCCESS",
          })
        },
        error: (error => {
          this.userStream.next({
            action: "LOGIN_FAILED",
            error
          })
        })
      })
  }

  doRegister(formData: any) {
    formData.authorities = [
      'ROLE_USER'
    ]
    this.httpClient.post("http://localhost:8080/api/users", formData)
      .subscribe({
        next: (response: any) => {
          this.userStream.next({
            action: "REGISTER_SUCCESS",
          })
        }
      })
  }
  doLogout() {
    localStorage.removeItem('token')
    this.userStream.next({
      action: "LOGOUT_SUCCESS",
    })
  }

  isLoggedIn() {
    let token = localStorage.getItem("token")
    if (token)
      return true;
    else
      return false;
  }

  constructor(private httpClient: HttpClient) { }
}
