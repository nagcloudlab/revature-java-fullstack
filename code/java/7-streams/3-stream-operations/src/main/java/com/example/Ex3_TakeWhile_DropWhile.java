package com.example;

import com.example.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex3_TakeWhile_DropWhile {
    public static void main(String[] args) {


        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(34234, "E1", 1000.00));
        employees.add(new Employee(14234, "E2", 2000.00));
        employees.add(new Employee(34234, "E3", 5000.00));
        employees.add(new Employee(54234, "E4", 4000.00));
        employees.add(new Employee(44234, "E5", 3000.00));

//        employees.sort((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary()));
        // -or-
        employees.sort(Comparator.comparing(Employee::getSalary));

        //-------------------------------------------------------------------

        employees
                .stream()
                .takeWhile(employee -> employee.getSalary()<=3000) // break
//                .dropWhile(employee -> employee.getSalary()<=3000)
                .forEach(System.out::println);



    }
}
