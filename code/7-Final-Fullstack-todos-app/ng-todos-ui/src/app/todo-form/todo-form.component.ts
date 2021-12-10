import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {debounceTime} from "rxjs/operators";
import {TodosService} from "../todos.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-todo-form',
  templateUrl: './todo-form.component.html',
  styleUrls: ['./todo-form.component.scss']
})
export class TodoFormComponent implements OnInit {


  todoFormGroup:FormGroup=this.fb.group({
    title:['',[
      Validators.required,
      Validators.minLength(3),
    ]
    ],
    type:['Office'],
    date:[new Date()]
  });
  startDate:Date=new Date();

  errors:any={}

  handleSubmit(event:Event){
    if(this.todoFormGroup.valid){
      this.todosService.addTodo(this.todoFormGroup.value)
        .then(e=>{
          this.router.navigate(["/todo-list"])
        })
      this.todoFormGroup.reset();
    }
  }

  constructor(
    private fb:FormBuilder,
    private todosService:TodosService,
    private router:Router) { }

  ngOnInit(): void {

    const titleFormControl=this.todoFormGroup.get('title');

    titleFormControl?.statusChanges
      .pipe(debounceTime(2000))
      .subscribe({
        next:e=>{
          if(e==="INVALID"){
            if(titleFormControl?.errors?.['required']){
              this.errors['title']="title is required"
            }
            if(titleFormControl?.errors?.['minlength']){
              this.errors['title']="title must have min 3 chars"
            }
          }else
            this.errors['title']=''
        }
      })

    // this.todoFormGroup.get('title')
    //   ?.valueChanges
    //   .subscribe({
    //     next:e=>{
    //       console.log(e)
    //     }
    //   })

  }

}
