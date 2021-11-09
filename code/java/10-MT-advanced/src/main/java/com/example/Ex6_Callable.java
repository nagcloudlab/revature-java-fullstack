package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.*;

public class Ex6_Callable {

    public static void main(String[] args) {


        Callable<List<String>> readVegMenuTask = () -> {
            System.out.println(Thread.currentThread().getName() + " reading file...");
            List<String> menu = new ArrayList<>();
            try {
                Scanner scanner = new Scanner(new File("veg-menu.txt"));
                while (scanner.hasNext()) {
                    menu.add(scanner.next());
                }
            } catch (FileNotFoundException e) {
                throw e;
            }
            TimeUnit.SECONDS.sleep(2);
            return menu;
        };

        Callable<List<String>> readNonVegMenuTask = () -> {
            System.out.println(Thread.currentThread().getName() + " reading file...");
            List<String> menu = new ArrayList<>();
            try {
                Scanner scanner = new Scanner(new File("non-veg-menu.txt"));
                while (scanner.hasNext()) {
                    menu.add(scanner.next());
                }
            } catch (FileNotFoundException e) {
                throw e;
            }
            TimeUnit.SECONDS.sleep(2);
            return menu;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Collection<Callable<List<String>>> tasks = Arrays.asList(
                readVegMenuTask,
                readNonVegMenuTask
        );

        try {
            List<Future<List<String>>> futures = executorService.invokeAll(tasks);
            for (Future<List<String>> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
