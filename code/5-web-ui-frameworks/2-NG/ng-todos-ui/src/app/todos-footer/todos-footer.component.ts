import { Component, OnInit } from '@angular/core';
import {TodosService} from "../todos.service";

@Component({
  selector: 'app-todos-footer',
  templateUrl: './todos-footer.component.html',
  styleUrls: ['./todos-footer.component.scss']
})
export class TodosFooterComponent implements OnInit {

  constructor(private todosService:TodosService) { }

  ngOnInit(): void {
  }

  handleFilter(event:Event,filter:string){
    event.preventDefault();
    this.todosService.filterTodos(filter)
  }
  handleClearCompleted(){
    this.todosService.clearCompleted()
  }

}
