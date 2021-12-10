import { Component, OnInit } from '@angular/core';
import {TodosService} from "../todos.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent implements OnInit {

  todos:Array<any>=[]

  constructor(
    private todosService:TodosService,
    private route:ActivatedRoute
  ) {}

  ngOnInit(): void {

    this.todosService.getTodos()

    this.todosService.todosStream
      .subscribe({
        next:(e:any)=>{
          let {action,todos}=e;
          this.todos=todos;
        }
      })

    this.route.params.subscribe(e=>{
      let {filter}=e;
      if(filter){
        this.todosService.filterTodos(filter.toUpperCase())
      }
    })
  }

}
