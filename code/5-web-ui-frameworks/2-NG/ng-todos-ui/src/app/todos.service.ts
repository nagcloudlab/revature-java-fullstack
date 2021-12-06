import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TodosService {


  private todos: Array<any> = [
    {id: 1, title: 'task-1', completed: true},
    {id: 2, title: 'task-2', completed: true},
    {id: 3, title: 'task-3', completed: false}
  ]

  todosStream=new BehaviorSubject({
    filter:'ALL',
    action:'',
    todos:this.todos
  });

  private TODO_FILTERS:any={
    ALL:()=>true,
    ACTIVE:(todo:any)=>!todo.completed,
    COMPLETED:(todo:any)=>todo.completed
  }

  filterTodos(filter='ALL') {
    let filteredTodos=this.todos.filter(this.TODO_FILTERS[filter])
    this.todosStream.next({
      filter: filter,
      action: '',
      todos:filteredTodos
    })
  }

  addTodo(newTodo:any){
   return new Promise((resolve,reject)=>{
     this.todos.push(newTodo);
     this.todosStream.next({
       filter: 'ALL',
       action:'ADD_TODO',
       todos:this.todos
     })
     resolve(true)
   })
  }

  completeTodo(todoId: number) {
    this.todos = this.todos.map(todo => {
      if (todo.id === todoId)
        return {...todo, completed: !todo.completed}
      else
        return todo
    })
    this.todosStream.next({
      filter: 'ALL',
      action:'COMPLETE_TODO',
      todos:this.todos
    })
  }

  deleteTodo(todoId: number) {
    this.todos = this.todos.filter(todo => todo.id !== todoId);
    this.todosStream.next({
      filter: 'ALL',
      action:'DELETE_TODO',
      todos:this.todos
    })
  }

  clearCompleted(){
    this.todos = this.todos.filter(todo => !todo.completed);
    this.todosStream.next({
      filter: 'ALL',
      action:'CLEAR_COMPLETED',
      todos:this.todos
    })
  }


}
