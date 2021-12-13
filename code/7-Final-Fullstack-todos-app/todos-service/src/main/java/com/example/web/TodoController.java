package com.example.web;

import com.example.entity.Todo;
import com.example.entity.User;
import com.example.repository.TodoRepository;
import com.example.repository.UserRepository;
import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserRepository userRepository;

    //---------------------------------------------------------------------
    // REST api endpoints
    //---------------------------------------------------------------------
    // GET : /api/todos

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/todos",
            produces = {"application/json", "application/xml"}
    )
    public Collection<Todo> getAll(Principal principal) {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) principal;
//        String email = userDetails.getUsername();

        UsernamePasswordAuthenticationToken authenticationToken=(UsernamePasswordAuthenticationToken)principal;
        String email=authenticationToken.getName();

        User user = userRepository.findByEmail(email);
        Collection<Todo> todos = todoRepository.findAllByUserId(user.getId());
        return todos;
    }


    //--------------------------------------------------------------------

    // GET : /api/todos/{todoId}

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/todos/{todoId}",
            produces = {"application/json"}
    )
    public ResponseEntity<?> get(@PathVariable(name = "todoId") int todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        if (optionalTodo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(optionalTodo.get());

    }

    //--------------------------------------------------------------------
    // POST : /api/todos

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/todos",
            consumes = {"application/json", "application/xml"}
    )
    public ResponseEntity<?> post(@RequestBody Todo todo) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        todo.setUser(user);

        todo = todoRepository.save(todo); // insert ...

        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    //-------------------------------------------------------------------------

    // PUT : /api/todos/{todoId}

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/api/todos/{todoId}"
    )
    public ResponseEntity<?> put(
            @PathVariable(name = "todoId") int todoId,
            @RequestBody Todo todo
    ) {
        todo.setId(todoId);
        todo = todoRepository.save(todo); // update
        return ResponseEntity.ok(todo);
    }

    //-------------------------------------------------------------------------

    // DELETE : /api/todos/{todoId}


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/todos/{todoId}"
    )
    public ResponseEntity<?> delete(@PathVariable(name = "todoId") int todoId) {
        todoRepository.deleteById(todoId); // delete from todos where id=?
        return ResponseEntity.ok().build();
    }

    //----------------------------------------------------------------------------

    // DELETE : /api/todos

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/todos"
    )
    public ResponseEntity<?> deleteAll() {
        todoService.deleteAllTodos();
        return ResponseEntity.ok().build();
    }


}
