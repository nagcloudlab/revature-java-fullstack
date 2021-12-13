import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service'

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.scss']
})
export class RegisterFormComponent implements OnInit {


  registerForm: FormGroup = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required],
    name: ['', Validators.required]
  })

  handleSubmit(event: Event) {

    if (this.registerForm.valid) {
      let formData = this.registerForm.value;
      this.userService.doRegister(formData)
    }

  }


  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
    this.userService.userStream
      .subscribe({
        next: (e: any) => {
          if (e.action === "REGISTER_SUCCESS") {
            this.router.navigate(["/login-form"])
          }
        }
      })
  }

}
