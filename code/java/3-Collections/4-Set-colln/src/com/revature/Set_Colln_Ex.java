package com.revature;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Set_Colln_Ex {

    public static void main(String[] args) {

        Set<String> stringSet=new TreeSet<>(new ReverseStrings());
        stringSet.add("B");
        stringSet.add("C");
        stringSet.add("A");
        stringSet.add("D");
        stringSet.add("B");

        System.out.println(stringSet); // un-ordered , but sorted

    }

}

class ReverseStrings implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}