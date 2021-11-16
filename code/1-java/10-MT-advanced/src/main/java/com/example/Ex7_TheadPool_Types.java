package com.example;

import java.util.concurrent.*;

public class Ex7_TheadPool_Types {

    public static void main(String[] args) throws Exception {


        ScheduledExecutorService executorService =
//                Executors.newSingleThreadExecutor();
//                Executors.newFixedThreadPool(8);
//                Executors.newCachedThreadPool();
                Executors.newScheduledThreadPool(2);


        Runnable task = () -> {
            System.out.println("task executed by " + Thread.currentThread().getName());
        };

        executorService.scheduleAtFixedRate(task, 5, 8, TimeUnit.SECONDS);


    }

}
