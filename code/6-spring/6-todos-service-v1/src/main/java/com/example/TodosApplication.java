package com.example;

import com.example.entity.Todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
public class TodosApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext=null;
        applicationContext= SpringApplication.run(TodosApplication.class);


        Todo todo=new Todo();
        todo.setTitle("Learn fullstack");

        TodoRepository todoRepository=applicationContext.getBean(TodoRepository.class);
        todoRepository.save(todo);

        System.out.println("All is well");


    }
}
