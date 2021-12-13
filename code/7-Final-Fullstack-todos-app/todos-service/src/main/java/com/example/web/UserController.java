package com.example.web;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.web.payload.HttpResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    private UserService userService;

    // POST /api/users

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/users"
    )
    public ResponseEntity<?> doPost(@RequestBody User user){
        userService.register(user);
        HttpResponseBody responseBody=new HttpResponseBody("user registered");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }


}
