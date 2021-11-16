package com.example;


class Counter {
    private long count = 0;

    public  void increment() {
        count = count + 1;  // read existing count from memory , increment count , write back into memory
    }

    public long getCount() {
        return this.count;
    }

}

public class Ex5_RaceCondition {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter(); // shared resource

        Runnable counterTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(counterTask);
            threads[i].start();
        }

        for (int i = 0; i < 1000; i++) {
            threads[i].join();
        }


        System.out.println(counter.getCount()); // 1000 * 1000 = 1000000

    }
}
