package com.revature;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_Coll_Ex_2 {

    public static void main(String[] args) {

        Deque<String> deque=new LinkedList<>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addLast("Y");
        deque.addLast("Z");


        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());



    }

}
