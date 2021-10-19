
// package dec
package com.revature.emp;

// import statements

// Public Type
public class Employee {

    // state a.k.a data

    // a. class-level data
    public final static String COMPANY_NAME="revature";
    public static String tnrName; // null

    // b. object-level data
    public int id; // 0
    public String name; // null

    // constructor
    public Employee(){} // default constructor

    // behavior

    // a. class-level behav
    public static void doTraining(){
        System.out.println(tnrName+ " doing raining");
    }

    // b.object-level-behav
    public void doListenAndWork(){
        System.out.println(name+" listening and working");
    }

}
