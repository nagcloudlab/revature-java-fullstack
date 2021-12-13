import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {

  message: string = "";

  loginForm: FormGroup = this.fb.group({
    email: [''],
    password: ['']
  });

  handleSubmit(event: Event) {
    let credentials = this.loginForm.value;
    this.userService.doLogin(credentials)
  }

  constructor(private fb: FormBuilder, private router: Router, private userService: UserService) { }

  ngOnInit(): void {
    this.userService.userStream
      .subscribe({
        next: (e: any) => {
          if (e.action === "LOGIN_SUCCESS")
            this.router.navigate(["/todo-list/all"])
          if (e.action === "LOGIN_FAILED") {
            console.log(e);
            this.message = "Login failed"
          }
        }
      })
  }

}
