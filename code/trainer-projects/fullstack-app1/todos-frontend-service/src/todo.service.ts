import { TODO_FILTERS } from "./todo.filters";
import { Todo } from "./todo.model";


const url = "http://localhost:8080/users/nag/todos";

class TodoService {

    todos: Array<Todo> = []

    addTodo(title: string) {
        // const newTodo = new Todo(title)
        // this.todos = this.todos.concat(newTodo);
        // console.log(this.todos);
        return fetch(url, {
            method: 'POST',
            body: JSON.stringify({ title }),
            headers: {
                'Content-Type': 'application/json' // Media Type
            }
        })

    }
    editTodo(id: number, newTitle: string) {
        this.todos = this.todos.map((todo: Todo) => {
            if (todo.id === id) {
                todo.title = newTitle;
                return todo;
            } else {
                return todo
            }
        })
    }
    completeTodo(id: number) {
        this.todos = this.todos.map(todo => {
            if (todo.id === id) {
                return { ...todo, completed: !todo.completed }
            } else {
                return todo
            }
        })
    }
    deleteTodo(id: number) {
        return fetch(`${url}/${id}`, { method: 'DELETE' })
    }
    completeAll() {
        let areAllCompleted = this.todos.every(todo => todo.completed)
        this.todos = this.todos.map(todo => {
            return { ...todo, completed: !areAllCompleted }
        })
    }
    clearCompleted() {
        this.todos = this.todos.filter(todo => !todo.completed)
    }

    getTodos(filter: any) {
        // n/w call
        return fetch(url, { method: 'GET' })
            .then(response => response.json());

    }

}

export { TodoService }
