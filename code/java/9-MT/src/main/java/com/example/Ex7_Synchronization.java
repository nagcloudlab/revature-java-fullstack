package com.example;

import java.util.ArrayList;
import java.util.List;

class Home {

    private static Object key1 = new Object();
    private static Object key2 = new Object();
    private static Object key3 = new Object();

    public void room1() {
        String name = Thread.currentThread().getName();
        synchronized (key1) {
            System.out.println("thread-" + name + " entering room-1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread-" + name + " leaving room-1");
        }
    }

    public void room2() {
        String name = Thread.currentThread().getName();
        synchronized (key1) {
            System.out.println("thread-" + name + " entering room-2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread-" + name + " leaving room-2");
        }
    }

}


public class Ex7_Synchronization {
    public static void main(String[] args) {

        Home home1 = new Home();


        Runnable home1Room1Task = () -> {
            home1.room1();
        };
        Runnable home1Room2Task = () -> {
            home1.room2();
        };


        Thread thread1 = new Thread(home1Room1Task, "T1");
        Thread thread2 = new Thread(home1Room2Task, "T2");

        thread1.start();
        thread2.start();


    }
}
