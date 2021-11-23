
// -------------------------------------------------
// Model
// -------------------------------------------------

class Todo{
    static nextId=0;
    constructor(title){
        Todo.nextId++;
        this.id=Todo.nextId
        this.title=title;
        this.completed=false;
    }
}

// -------------------------------------------------
// Service
// -------------------------------------------------

const TODO_FILTERS={
    ALL:()=>true,
    ACTIVE:todo=>!todo.completed,
    COMPLETED:todo=>todo.completed
}


class TodoService{
    
    todos=[]

    addTodo(title){
        const newTodo=new Todo(title)
        this.todos=this.todos.concat(newTodo);
    }
    editTodo(id,newTitle){
        this.todos=this.todos.map(todo=>{
            if(todo.id===id){
                return {...todo,title:newTitle}
            }else{
                return todo
            }
        })
    }
    completeTodo(id){
        this.todos=this.todos.map(todo=>{
            if(todo.id===id){
                return {...todo,completed:!todo.completed}
            }else{
                return todo
            }
        })
    }
    deleteTodo(id){
        this.todos=this.todos.filter(todo=>todo.id!==id)
    }
    completeAll(){
        let areAllCompleted=this.todos.every(todo=>todo.completed)
        this.todos=this.todos.map(todo=>{
            return {...todo,completed:!areAllCompleted}
        })
    }
    clearCompleted(){
        this.todos=this.todos.filter(todo=>!todo.completed)
    }
    getTodos(filter){

        // if(flag==="ALL")
        //     this.todos
        //     .filter(todo=>true)
        //     .forEach(todo=>console.log(todo))
        // if(flag==="ACTIVE")
        //     this.todos
        //     .filter(todo=>!todo.completed)
        //     .forEach(todo=>console.log(todo))    
        // if(flag==="COMPLETED")
        //     this.todos
        //     .filter(todo=>todo.completed)
        //     .forEach(todo=>console.log(todo))  

        this.todos
            .filter(TODO_FILTERS[filter])
            .forEach(todo=>console.log(todo))

    }

}

const todoService=new TodoService();
todoService.addTodo("todo-1")
todoService.addTodo("todo-2")
todoService.addTodo("todo-3")