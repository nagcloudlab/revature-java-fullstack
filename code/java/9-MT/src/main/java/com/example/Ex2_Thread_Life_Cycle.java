package com.example;

public class Ex2_Thread_Life_Cycle {

    public static void main(String[] args) {

        // RUNNABLE-state -> RUNNING-state
        Runnable numberTask = () -> {

            String threadName = Thread.currentThread().getName();

            for (int i = 0; i < 1000; i++) {
                System.out.println(threadName + " => " + i);
            }

        }; // RUNNING-state -> DEAD-state

        //numberTask.run();

        Thread t1Thread = new Thread(numberTask, "T1"); // NEW-state
        t1Thread.start(); // NEW-state -> RUNNABLE-state


        Thread t2Thread = new Thread(numberTask, "T2"); // NEW-state
        t2Thread.start(); // NEW-state -> RUNNABLE-state


        Thread t3Thread = new Thread(numberTask, "T3"); // NEW-state
        t3Thread.start(); // NEW-state -> RUNNABLE-state

    }

}
