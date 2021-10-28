package com.example;

import java.io.FileNotFoundException;
import java.util.function.Consumer;
import java.util.function.Function;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class FP_Ex_2 {


    public static void main(String[] args) throws FileNotFoundException {

        Employee employee = new Employee("nag");


        Function<Employee, String> getEmpName = e -> e.getName();
        Function<String, String> toUppercase = s -> s.toUpperCase();
        Function<String, Character> getInitialChar = name -> name.charAt(0);

//
//        String name=getEmpName.apply(employee);
//        char initial=getInitialChar.apply(name);


        Function<Employee, Character> getEmployeeInitial =
                getEmpName
                        .andThen(toUppercase)
                        .andThen(getInitialChar);

        char initial = getEmployeeInitial.apply(employee);

        System.out.println(initial);


    }

}
