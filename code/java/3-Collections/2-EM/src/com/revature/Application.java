package com.revature;

import com.revature.model.Employee;
import com.revature.service.EmployeeManagement;

public class Application {
    public static void main(String[] args) {

        EmployeeManagement employeeManagement=new EmployeeManagement();

        employeeManagement.addEmployee(new Employee(1,"charles",1000.00));
        employeeManagement.addEmployee(new Employee(2,"tasnim",2000.00));
        employeeManagement.addEmployee(new Employee(3,"brady",3000.00));
        employeeManagement.addEmployee(new Employee(4,"Nag",3000.00));

        employeeManagement.editEmployee(3,"Brady Falcon");
        employeeManagement.deleteEmployee(4);


        for(Employee employee: employeeManagement.getEmployees()){
            System.out.println(employee);
        }

    }
}
