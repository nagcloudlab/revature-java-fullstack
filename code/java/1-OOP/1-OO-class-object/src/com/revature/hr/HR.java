package com.revature.hr;


import com.revature.emp.Employee;

public class HR {

    public static void manageEmployees(){

        Employee.tnrName="Nag";

        // create employees
        Employee employee1=new Employee();
        employee1.id=1;
        employee1.name="One";

        Employee employee2=new Employee();
        employee2.id=2;
        employee2.name="Two";

        // do Training
        Employee.doTraining();

        // do Listen and Work
        employee1.doListenAndWork();
        employee2.doListenAndWork();

    }

}
