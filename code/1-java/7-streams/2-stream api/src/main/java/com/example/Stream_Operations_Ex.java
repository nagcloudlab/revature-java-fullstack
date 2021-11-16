package com.example;

import java.util.Random;
import java.util.stream.Stream;

public class Stream_Operations_Ex {

    public static void main(String[] args) {

        Random random = new Random();

        Stream.generate(() -> {
                    return random.nextInt(); // +v1 and -ve
                })
                //.peek(n -> System.out.println("peek - " + n))
                .filter(n -> n > 0)
                .limit(10)
                .forEach(System.out::println);

        // stream , data pulled bottom

    }

}
