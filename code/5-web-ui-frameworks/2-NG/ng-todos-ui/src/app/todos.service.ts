import { Injectable } from '@angular/core';
import { BehaviorSubject } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TodosService {


  private todos: Array<any> = []

  constructor(private httpClient: HttpClient) { }

  todosStream = new BehaviorSubject({
    filter: 'ALL',
    action: '',
    todos: this.todos
  });

  private TODO_FILTERS: any = {
    ALL: () => true,
    ACTIVE: (todo: any) => !todo.completed,
    COMPLETED: (todo: any) => todo.completed
  }

  getTodos() {
    this.httpClient.get("http://localhost:8080/api/todos")
      .subscribe({
        next: (response: any) => {
          this.todos = response;
          this.todosStream.next({
            filter: 'All',
            action: 'LOAD_TODOS',
            todos: this.todos
          })
        }
      }
      )
  }

  filterTodos(filter = 'ALL') {
    let filteredTodos = this.todos.filter(this.TODO_FILTERS[filter])
    this.todosStream.next({
      filter: filter,
      action: '',
      todos: filteredTodos
    })
  }

  addTodo(newTodo: any) {
    return new Promise((resolve, reject) => {
      this.httpClient.post("http://localhost:8080/api/todos", {
        title: newTodo.title
      }).subscribe({
        next: e => {
          this.todos.push(newTodo);
          this.todosStream.next({
            filter: 'ALL',
            action: 'ADD_TODO',
            todos: this.todos
          })
          resolve(true)
        }
      })
    })
  }

  completeTodo(todoId: number) {
    this.todos = this.todos.map(todo => {
      if (todo.id === todoId)
        return { ...todo, completed: !todo.completed }
      else
        return todo
    })
    this.todosStream.next({
      filter: 'ALL',
      action: 'COMPLETE_TODO',
      todos: this.todos
    })
  }

  deleteTodo(todoId: number) {

    this.httpClient.delete("http://localhost:8080/api/todos/" + todoId).subscribe({
      next: e => {
        this.todos = this.todos.filter(todo => todo.id !== todoId);
        this.todosStream.next({
          filter: 'ALL',
          action: 'DELETE_TODO',
          todos: this.todos
        })
      }
    });

  }

  clearCompleted() {
    this.todos = this.todos.filter(todo => !todo.completed);
    this.todosStream.next({
      filter: 'ALL',
      action: 'CLEAR_COMPLETED',
      todos: this.todos
    })
  }


}
