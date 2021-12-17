import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {confirmPasswordMatchValidator, strongPasswordValidator} from "./custom-validators";
import {zip} from "rxjs";

@Component({
  selector: 'app-customer-register-form',
  templateUrl: './customer-register-form.component.html',
  styleUrls: ['./customer-register-form.component.css']
})
export class CustomerRegisterFormComponent implements OnInit {

  errors:any={

  }

  customerForm:FormGroup=this.fb.group({
    email:['',[Validators.required,Validators.email]],
    password:['',[Validators.required,strongPasswordValidator]],
    confirmPassword:[''],
    mobile:[''],
    notiType:['email']
  },{
    validators:confirmPasswordMatchValidator()
  })

  loadCustomer(){
    //...
    let customerData={
      email:'nag@mail.com',
      mobile:'1234567890',
      notiType:'sms'
    }
    //this.customerForm.setValue(customerData)
    this.customerForm.patchValue(customerData)
  }
  resetCustomerForm(){
    this.customerForm.reset({
      email:'',
      mobile:'',
      notiType:'email'
    })
  }

  handleNotiType(notification:string){
    let mobileControl=this.customerForm.controls['mobile']
    if(notification==='sms'){
      mobileControl.setValidators([Validators.required,Validators.pattern(/\d{10}/)])
    }
    if(notification==='email'){
      mobileControl.removeValidators([Validators.required])
    }
    mobileControl.updateValueAndValidity()
  }

  handleSubmit(){
    if(this.customerForm.valid){
      const customerData=this.customerForm.value;
      console.log(customerData)
    }
  }

  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {

    const emailControl=this.customerForm.controls['email'];
    const valueChangesStream=emailControl.valueChanges;
    const statusChangesStream=emailControl.statusChanges;

    const stream=zip(valueChangesStream,statusChangesStream)
    stream
      .subscribe({
        next:(e)=>{
          let [email,status]=e;
          if(status==="VALID"){
            //..
            if(email==="nag@mail.com"){
            this.errors['email_exist']="Email already exist"
            }else{
              this.errors['email_exist']=""
            }
          }
        }
      })

  }

}
