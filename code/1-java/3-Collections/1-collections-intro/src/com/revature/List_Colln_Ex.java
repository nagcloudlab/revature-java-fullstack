package com.revature;

import java.util.*;

public class List_Colln_Ex {
    public static void main(String[] args) {

//        List<String> stringList = new ArrayList<>();// box / container for string elements , collection
//        stringList.add("A");
//        stringList.add("B");
//        stringList.add("C");
//        stringList.add("A");
//        stringList.add(3, "D"); // insert

//        String ele=stringList.get(3);
//        stringList.set(3,"d");
//        stringList.remove(3);
//        System.out.println(stringList.get(stringList.size()-1));
//        System.out.println(stringList.size());
//        System.out.println(stringList.contains("Z"));
//        System.out.println(stringList.isEmpty());
//        System.out.println(stringList.indexOf("A"));
//        System.out.println(stringList.lastIndexOf("A"));

//        List<String> subList=stringList.subList(0,2);
//        stringList.clear();

        //---------------------------------------------------------

//        List<String> list1=new ArrayList<>();
//        list1.add("A");
//        list1.add("B");
//        list1.add("C");
//
//        List<String> list2=new ArrayList<>();
//        list2.add("D");
//        list2.add("F");
//        list2.add("B");
//
////        list1.removeAll(list2); // remove common elements from source colln
////        list1.retainAll(list2); // retain common elements from source colln
//
//        System.out.println(list1);

        //---------------------------------------------------------

        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("A");


        // Iteration / Looping

        // way-1 : traditional for loop
//        for(int i=0;i< stringList.size();i++){
//            String stringItem=stringList.get(i);
//            System.out.println(stringItem);
//        }


//        Iterable Collection  = Collection + Iteration Logic with Iterator
        //way-2 : iterator ( recommended )
//        Iterator<String> iterator=stringList.iterator();
//        while(iterator.hasNext()){
//            String stringItem= iterator.next();
//            System.out.println(stringItem);
//        }

        // Way-3: For-Each loop Enhanced For Loop ( JDK 1.5 )

        /*
        syntax:

            for(Type var : iterable ){

            }

         */

//        for(String stringItem:stringList){
//            System.out.println(stringItem);
//        }


    }
}
