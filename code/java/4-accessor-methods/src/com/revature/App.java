package com.revature;


public class App {

    public static void main(String[] args) {

       Employee employee=new Employee(123);
       employee.setName("Nag");
       employee.setSalary(10000L);
       employee.setAddress("chennai-india");

        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getSalary());
        System.out.println(employee.getAddress());


    }

}
