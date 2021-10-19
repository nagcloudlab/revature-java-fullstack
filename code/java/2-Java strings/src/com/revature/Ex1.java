package com.revature;

// static polymorphism
/*

    => we know what behav get invoked at coding time

    how to implement ?

    => via method-overloading

 */

class Actor{
    public void act(){
        System.out.println("single role acting...");
    }
    public void act(int highyPay){
        System.out.println("double role acting...");
    }
}

public class Ex1 {

    public static void main(String[] args) {

        Actor actor=new Actor();
        actor.act();
        actor.act(1000);

        //------------------------------------------

        String str="abcedfgh";
        String s1=str.substring(2);
        System.out.println(s1); // CEDFGH
        String s2=str.substring(2,4);
        System.out.println(s2); // CE

        //-------------------------------------------

        System.out.println(12);
        System.out.println("string");

        //-----------------------------------------

    }

}
