package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //---------------------------------------------------------------
        // way-1 : Imperative style
        //---------------------------------------------------------------

//        Scanner scanner = new Scanner(new File("report.txt"));
//        Map<String, Double> map = new HashMap<>();
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            String[] tokens = line.split(",");
//            String department = tokens[1];
//            double salary = Double.parseDouble(tokens[2]);
//            if (map.containsKey(department)) {
//                double newTotal = map.get(department) + salary;
//                map.put(department, newTotal);
//            } else {
//                map.put(department, salary);
//            }
//        }
//        System.out.println(map);
//        scanner.close();


        //---------------------------------------------------------------
        // way-2 : Declarative style
        //---------------------------------------------------------------

        Map<String, DoubleSummaryStatistics> map =
                Files.lines(Paths.get("report.txt"))
                        .map(line -> line.split(","))
                        .collect(Collectors.groupingBy(tokens -> tokens[1],
                                Collectors.summarizingDouble(tokens -> Double.parseDouble(tokens[2]))));

        System.out.println(map);
    }

}
