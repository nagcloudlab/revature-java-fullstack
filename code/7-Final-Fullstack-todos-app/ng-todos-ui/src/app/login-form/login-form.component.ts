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

  loginForm: FormGroup = this.fb.group({
    email: [''],
    password: ['']
  });

  handleSubmit(event: Event) {
    let credentials = this.loginForm.value;
    this.userService.doLogin(credentials)
      .subscribe({
        next: (response: any) => {
          localStorage.setItem("token", response.jwt);
          this.router.navigate(['/todo-list/all'])
        }
      })
  }

  constructor(private fb: FormBuilder, private router: Router, private userService: UserService) { }

  ngOnInit(): void {
  }

}
