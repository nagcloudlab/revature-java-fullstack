package com.revature;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MiniByte_2 {
    public static void main(String[] args) {

//        Map<Integer,String> map=new TreeMap<>();
//        Map<Integer,String> map=new HashMap<>();
        Map<Integer,String> map=new LinkedHashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(7,"seven");
        map.put(3,"three");
        map.put(3,"three");
        map.put(4,"four");

        System.out.println(map.get(7));

    }
}
