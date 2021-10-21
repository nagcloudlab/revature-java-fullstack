package com.revature;

import java.util.Stack;

public class Stack_Ex1 {

    public static void main(String[] args) {

//        stack => LIFO

        Stack<String> stringStack=new Stack<>();
        stringStack.push("A");
        stringStack.push("B");
        stringStack.push("C");

        //System.out.println(stringStack.peek());
        while(!stringStack.isEmpty()){
            System.out.println(stringStack.pop());
        }

//        for(String item:stringStack){
//            System.out.println(item);
//        }


    }

}
