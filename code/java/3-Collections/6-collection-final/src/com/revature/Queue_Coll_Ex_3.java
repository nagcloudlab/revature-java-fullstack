package com.revature;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Queue_Coll_Ex_3 {

    public static void main(String[] args) {


        PriorityQueue<String> priorityQueue=new PriorityQueue<>(new Reverse());
        priorityQueue.add("Z");
        priorityQueue.add("Y");
        priorityQueue.add("C");
        priorityQueue.add("A");
        priorityQueue.add("B");


        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

    }

}

class Reverse implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
