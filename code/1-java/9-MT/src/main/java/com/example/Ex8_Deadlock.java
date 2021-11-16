package com.example;

class R1 {

    public synchronized void m1(R2 r2) {
        System.out.println("T1 having R1");
        System.out.println("T1 trying for R2");
        r2.m2();
    }

    public  void m2() {
        System.out.println("T2 also having R1");
    }
}

class R2 {
    public synchronized void m1(R1 r1) {
        System.out.println("T2 having R2");
        System.out.println("T2 trying for R1");
        r1.m2();
    }

    public synchronized void m2() {
        System.out.println("T1 also having R2");
    }
}

public class Ex8_Deadlock {
    public static void main(String[] args) {

        R1 r1 = new R1();
        R2 r2 = new R2();

        Runnable task = () -> {
            String tName = Thread.currentThread().getName();
            if (tName.equals("T1")) {
                r1.m1(r2);
            }
            if (tName.equals("T2")) {
                r2.m1(r1);
            }
        };


        Thread thread1 = new Thread(task, "T1");
        Thread thread2 = new Thread(task, "T2");

        thread1.start();
        thread2.start();

    }
}
