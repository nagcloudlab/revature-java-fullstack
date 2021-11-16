package com.revature;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Colln_Ex_1 {
    public static void main(String[] args) {

        // print-queue => FIFO principle

        Queue<String> queue=new LinkedList<>();
        queue.add("print-1");
        queue.add("print-2");
        queue.add("print-3");

//        System.out.println(queue.peek());

        while (!queue.isEmpty()){
            String print= queue.poll();
            System.out.println(print);
        }

        System.out.println(queue.isEmpty());

    }
}
