package com.revature.service;

import com.revature.model.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeManagement {

    private List<Employee> employees=new ArrayList<>();

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public void editEmployee(int id,String newName){
        Employee employee=null;
        for(Employee emp:employees){
            if(emp.getId()==id){
                employee=emp;
                break;
            }
        }
        if(employee!=null){
            employee.setName(newName);
        }
    }
    public void editEmployee(int id,double newSalary){
            Employee employee=null;
            for(Employee emp:employees){
                if(emp.getId()==id){
                    employee=emp;
                    break;
                }
            }
            if(employee!=null){
                employee.setSalary(newSalary);
            }
    }
    public void deleteEmployee(int id){
        Iterator<Employee> iterator= employees.iterator();
        while (iterator.hasNext()){
            Employee employee=iterator.next();
            if(employee.getId()==id)
                iterator.remove();
        }
    }
    public List<Employee> getEmployees(){
        return this.employees;
    }

}
