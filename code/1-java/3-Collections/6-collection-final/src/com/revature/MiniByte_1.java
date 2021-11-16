package com.revature;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MiniByte_1 {

    public static void main(String[] args) {

        // Unique
//        Set<String> set=new TreeSet<>(); // un-ordered but sorted
//        Set<String> set=new HashSet<>(); // un-ordered
        Set<String> set=new LinkedHashSet<>(); // ordered
        set.add("A");
        set.add("B");
        set.add("B");
        set.add("Z");
        set.add("D");
        set.add("P");
        set.add("F");

        System.out.println(set);

    }

}
