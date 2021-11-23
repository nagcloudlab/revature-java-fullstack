package com.example;

import com.example.entity.User;
import com.example.exceptions.InvalidCredentialException;
import com.example.exceptions.UserNotFoundException;
import com.example.repository.*;
import com.example.service.TodoService;
import com.example.service.TodoServiceImpl;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class TodoApplication {

    static Scanner scanner = new Scanner(System.in);
    static EntityManagerFactory entityManagerFactory=null;

    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("my-pu");
    }

    //------------------------------------------------------------------
    // Init
    //------------------------------------------------------------------

    static User currentUser = null;

    static TodoRepository todoRepository = new JpaTodoRepository(entityManagerFactory); // dependency
    static TodoService todoService = new TodoServiceImpl(todoRepository); // dependent

    static UserRepository userRepository = new JpaUserRepository(entityManagerFactory);
    static UserService userService = new UserServiceImpl(userRepository);

    //-------------------------------------------------------------------

    public static void main(String[] args) {

        //------------------------------------------------------------------
        // Use
        //------------------------------------------------------------------

        while (true) {
            System.out.println("\n select choice !");
            System.out.println("" +
                    "\n\n" +
                    "1- Add Todo \n" +
                    "2- View Todos \n" +
                    "3- Update Todo \n" +
                    "4- Delete Todo \n" +
                    "5- Register \n" +
                    "6- Login \n" +
                    "7- Logout \n" +

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
                case 3: {
                    handleChoice3();
                    break;
                }
                case 4: {
                    handleChoice4();
                    break;
                }
                case 5: {
                    handleChoice5();
                    break;
                }
                case 6: {
                    handleChoice6();
                    break;
                }
                case 7: {
                    currentUser = null;
                    todoService.setUser(null);
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

    private static void handleChoice3() {
        System.out.println("Enter todo new-title");
        scanner.nextLine();
        String title = scanner.nextLine();

        System.out.println("Enter todo id");
        int id = scanner.nextInt();
        todoService.editTodo(id, title);
    }

    private static void handleChoice4() {
        System.out.println("Enter todo id");
        int id = scanner.nextInt();
        todoService.deleteTodo(id);
    }

    private static void handleChoice5() {

        scanner.nextLine();

        System.out.println("Email !");
        String email = scanner.nextLine();

        System.out.println("Password !");
        String password = scanner.nextLine();

        System.out.println("Name !");
        String name = scanner.nextLine();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);

        userService.register(user);

    }

    private static void handleChoice6() {
        scanner.nextLine();
        System.out.println("Enter Email");
        String email = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        try {
            currentUser = userService.login(email, password);
            todoService.setUser(currentUser);
            System.out.println("login successful");
        } catch (UserNotFoundException | InvalidCredentialException e) {
            System.out.println("exception: " + e.getMessage());
        }

    }

}
