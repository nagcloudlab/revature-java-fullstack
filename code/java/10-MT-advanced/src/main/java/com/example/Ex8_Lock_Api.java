package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex8_Lock_Api {

    public static void main(String[] args) {


        Lock lock = new ReentrantLock();

        Runnable diningTask = () -> {
            String tName = Thread.currentThread().getName();
            lock.lock();
            System.out.println(tName + " going to have lunch..");
            System.out.println(tName + " eating");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tName + " finished lunch");
            lock.unlock();
        };


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(diningTask);
        executorService.submit(diningTask);


    }

}
