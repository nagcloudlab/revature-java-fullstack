import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ng-todos-ui';

  isLoggedIn = false;

  handleLogout() {
    this.userService.doLogout()
  }

  ngOnInit() {
    this.isLoggedIn = this.userService.isLoggedIn()
    this.userService.userStream
      .subscribe((e: any) => {
        if (e.action === "LOGIN_SUCCESS") {
          this.isLoggedIn = this.userService.isLoggedIn()
        }
        if (e.action === "LOGOUT_SUCCESS") {
          this.isLoggedIn = this.userService.isLoggedIn()
          this.router.navigate(['/login-form'])
        }
      })
  }

  constructor(
    private userService: UserService,
    private router: Router) { }

}
