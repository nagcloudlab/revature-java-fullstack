import {AbstractControl, FormGroup} from "@angular/forms";


export function strongPasswordValidator(control:AbstractControl){
  const passwordValue=control.value;
  // Pa$$w0rd
  if(passwordValue.length>=3)
    return null;
  else
  return {password:true}
}


export function confirmPasswordMatchValidator(){
 return function (fg:FormGroup){
   const v1=fg.controls['password'].value;
   const v2=fg.controls['confirmPassword'].value;
   if(v1===v2)
     return null;
   else
     return {passwordMatch:true}
 }
}
