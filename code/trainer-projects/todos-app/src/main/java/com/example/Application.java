package com.example;

import com.example.model.Todo;
import com.example.model.TodoFilter;
import com.example.repository.InMemoryTodoRepository;
import com.example.repository.JdbcTodoRepository;
import com.example.repository.TodoRepository;
import com.example.service.TodoService;
import com.example.service.TodoServiceImpl;

import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);


    //------------------------------------------------------------------
    // Init
    //------------------------------------------------------------------

    static TodoRepository todoRepository = new JdbcTodoRepository(); // dependency
    static TodoService todoService = new TodoServiceImpl(todoRepository); // dependent

    //-------------------------------------------------------------------

    public static void main(String[] args) {

        //------------------------------------------------------------------
        // Use
        //------------------------------------------------------------------


        while (true) {
            System.out.println("select choice !");
            System.out.println("" +
                    "1- Add Todo \n" +
                    "2- View Todos" +
                    "");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    handleChoice1();
                    break;
                }
                case 2: {
                    handleChoice2();
                    break;
                }
            }
        }

        //-------------------------------------------------------------------


    }

    private static void handleChoice1() {
        System.out.println("Enter todo title");
        scanner.nextLine(); // clear prev input buffer  ( its not good option )
        String title = scanner.nextLine();
        todoService.addTodo(title);
    }

    private static void handleChoice2() {
        todoService.getTodos(TodoFilter.ALL)
                .forEach(System.out::println);
    }


}
