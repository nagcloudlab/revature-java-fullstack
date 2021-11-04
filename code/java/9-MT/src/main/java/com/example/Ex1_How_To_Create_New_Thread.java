package com.example;

public class Ex1_How_To_Create_New_Thread {
    public static void main(String[] args) {


        // step-1 : create instance of Thread class
        // step-2 : Assign task1 who implements Runnable interface that thread should execute
        // step-3 : start thread


        class Task1 implements Runnable {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " executing task1..");
            }
        }
        Task1 task1 = new Task1();

        // - or-

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " executing task2..");
            }
        };

        // -or-

        Runnable task3 = () -> {
            System.out.println(Thread.currentThread() + " executing task3..");
        };

        Thread thread = new Thread(task3);
        thread.start();  // Allocating New-stack memory to this thread for independent execution.


    }
}
