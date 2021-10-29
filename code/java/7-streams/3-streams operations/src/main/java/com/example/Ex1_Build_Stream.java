package com.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

public class Ex1_Build_Stream {

    public static void main(String[] args)throws IOException {

        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream
                .map(String::toUpperCase)
                .forEach(System.out::println);

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays
                .stream(numbers)
                .sum();
        System.out.println(sum);

        Set<Integer> integers=Set.of(1,2,3,4,5,6,7,8,9,10);
        integers
                .stream()
                .forEach(System.out::println);


        Stream
                .iterate(0,n->n+2)
                .limit(10)
                .forEach(System.out::println);


        Stream
                .generate(Math::random) // 0 - 1
                .limit(10)
                .forEach(System.out::println);


        long uniqueWordCount=Files
                .lines(Paths.get("src/main/resources/data.txt"), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();

        System.out.println(uniqueWordCount);



    }

}
