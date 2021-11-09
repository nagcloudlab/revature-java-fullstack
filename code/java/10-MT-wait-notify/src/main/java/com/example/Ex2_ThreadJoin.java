package com.example;

import java.util.concurrent.TimeUnit;

public class Ex2_ThreadJoin {
    public static void main(String[] args) {

        Runnable trainerTask = () -> {
            System.out.println("tnr looking on Q");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("tnr giving solution to Q");
        };

        Runnable employeeTask = () -> {

            System.out.println("employee learning");
            System.out.println("employee got Q");

            Thread tnrThread = new Thread(trainerTask);
            tnrThread.start();

            System.out.println("employee joining tnr thread");
            try {
                tnrThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("employee learning further after trainer");

        };

        Thread empThread = new Thread(employeeTask);
        empThread.start();

    }
}
