package com.revature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class List_Colln_Compare_Ex {
    public static void main(String[] args) {
        /*
            ArrayList ==> Array
            LinkedList ==> DLL
         */
        compare(new ArrayList<>(100000000));
        compare(new LinkedList<>());
    }

    private static void compare(List<Integer> list) {
        long start=System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            list.add(i);
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);

    }
}
