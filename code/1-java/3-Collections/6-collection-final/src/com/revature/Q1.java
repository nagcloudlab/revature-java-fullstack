package com.revature;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {

        // List => Iterable

        List<String> list=new ArrayList<>();
        list.add("item-1");
        list.add("item-2");
        list.add("item-3");

        for(String item:list){
            System.out.println(item);
        }

        // Set => Iterable

        Set<String> set=new HashSet<>();
        set.add("item-1");
        set.add("item-2");
        set.add("item-3");

        for(String item:set){
            System.out.println(item);
        }

        // Map => Not Iterable
        Map<Integer,String> map=new HashMap<>();
        map.put(234,"Nag1");
        map.put(324,"Nag2");
        map.put(565,"Nag2");


        //
        Set<Integer> keys= map.keySet();
        for(Integer key:keys){
            System.out.println(map.get(key));
        }

        // or



    }

}
