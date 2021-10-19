package com.revature;

public class Employee {

    private int id;
    public String name;


    public Employee(int id){
        if(id>0)
            this.id=id;
    }

    public int getId(){
        return this.id;
    }


}
