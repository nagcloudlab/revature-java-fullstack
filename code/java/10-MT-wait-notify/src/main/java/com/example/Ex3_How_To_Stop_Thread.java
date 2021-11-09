package com.example;

import java.util.concurrent.TimeUnit;

public class Ex3_How_To_Stop_Thread {
    public static void main(String[] args) {

        Runnable playSong = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("boom boom boom");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    break;
                }
            }
        };

        Thread playerThread = new Thread(playSong);
        playerThread.start();


        // after 5s
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        playerThread.stop();
        playerThread.interrupt();


    }
}
