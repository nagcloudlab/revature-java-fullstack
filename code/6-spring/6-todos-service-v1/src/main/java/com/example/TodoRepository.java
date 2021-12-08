package com.example;

import com.example.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TodoRepository extends CrudRepository<Todo,Integer> {
}
