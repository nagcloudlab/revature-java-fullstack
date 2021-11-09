package com.example;


import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class Ex1_ThreadSleep {
    public static void main(String[] args) {

        Runnable timeTask = () -> {
            while (true) {
                LocalTime localTime = LocalTime.now();
                System.out.println(localTime);

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread timeThread = new Thread(timeTask);
        timeThread.start();


    }
}
