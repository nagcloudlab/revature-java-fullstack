package com.example;

import java.util.concurrent.TimeUnit;

public class Ex4_Producer_Consumer {

    static int[] buffer = new int[10];
    static int count = 0;

    static boolean isEmpty() {
        return count == 0;
    }

    static boolean isFull() {
        return count == buffer.length;
    }

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Runnable produceTask = () -> {
            synchronized (lock) {
                for (int i = 0; i < 50; i++) {
                    if (isFull()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer[count++] = 1;
                    System.out.println("produced item - " + i);
                    //lock.notify(); // notify any random thread
                    lock.notifyAll();
                }
                System.out.println("Done producing");
            }
        };

        Runnable consumeTask = () -> {
            synchronized (lock) {
                for (int i = 0; i < 45; i++) {
                    if (isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer[--count] = 0;

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("consumed item " + i);
                    lock.notify();
                }
                System.out.println("Done consuming");
            }
        };


        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);
//
        producerThread.start();
        consumerThread.start();
//
        producerThread.join();
        consumerThread.join();

        System.out.println("data in the buffer: " + count);

    }
}
