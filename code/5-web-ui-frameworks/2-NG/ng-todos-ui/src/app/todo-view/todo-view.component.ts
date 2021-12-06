import {Component, Input, OnInit} from '@angular/core';
import {TodosService} from "../todos.service";

@Component({
  selector: 'app-todo-view',
  templateUrl: './todo-view.component.html',
  styleUrls: ['./todo-view.component.scss']
})
export class TodoViewComponent implements OnInit {

  @Input("value")todo:any={}

  constructor(private todosService:TodosService) { }

  ngOnInit(): void {
  }

  handleComplete(event:Event,todoId:number){
    this.todosService.completeTodo(todoId)
  }

  handleDelete(event:Event,todoId:number){
    this.todosService.deleteTodo(todoId)
  }

}
