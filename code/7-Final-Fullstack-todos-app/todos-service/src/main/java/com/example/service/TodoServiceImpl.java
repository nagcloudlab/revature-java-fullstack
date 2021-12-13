package com.example.service;

import com.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    @RolesAllowed(value = {"ROLE_ADMIN"})
    public void deleteAllTodos() {
        // only 'ADMIN' can delete all user todos
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        System.out.println(userDetails.getAuthorities());
//        if(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            todoRepository.deleteAll();
//        }else{
//            throw new AccessDeniedException("no permission");
//        }
    }
}
