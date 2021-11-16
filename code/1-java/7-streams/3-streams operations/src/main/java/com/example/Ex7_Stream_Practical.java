package com.example;

import com.example.model.Trader;
import com.example.model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex7_Stream_Practical {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).

//        transactions
//                .stream()
//                .filter(transaction -> transaction.getYear()==2011)
//                .sorted(Comparator.comparing(Transaction::getValue))
//                .forEach(System.out::println);

        // Query 2: What are all the unique cities where the traders work?

//        transactions
//                .stream()
//                .map(transaction -> transaction.getTrader().getCity())
//                .distinct()
//                .forEach(System.out::println);


        // Query 3: Find all traders from Cambridge and sort them by name.

//        transactions
//                .stream()
//                .map(transaction -> transaction.getTrader())
//                .filter(trader -> trader.getCity().equals("Cambridge"))
//                .map(trader -> trader.getName())
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);


        // Query 5: Are there any trader based in Milan?

        boolean milanBased=
                transactions
                        .stream()
                        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);


        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.

        transactions
                .stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Milan"))
                .forEach(trader -> trader.setCity("Cambridge"));



    }

}
