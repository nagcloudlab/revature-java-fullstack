package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex5_Executor_Framework {

    public static void main(String[] args) {


        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName() + " started task1");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " completed task1");
        };

//        Thread thread = new Thread(task1);
//        thread.start();

        ExecutorService executorService = Executors.newFixedThreadPool(8);
//        executorService.submit(task1);
//        executorService.submit(task1);

        for (int i = 0; i < 16; i++) {
            executorService.submit(task1);
        }


    }

}
