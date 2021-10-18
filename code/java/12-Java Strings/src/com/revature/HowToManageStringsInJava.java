package com.revature;

/*

    strings

        => group of characters ( a-zA-Z , 0-9 , any symbols )

    how to manage Strings in java ?

    using 3 classes

    1. java.lang.String
    2. java.lang.StringBuffer
    3. java.lang.StringBuilder


    imp notes about java strings

    #0-, every string is an object in java-language
    #1-, we can create string object with/without 'new' operator
    #2-, if we create string object without 'new' operator, obj will get placed in SCP memory

        SCP-memory

        => pre allocated memory
        => can hold unique string objects


    #3-, by default, every string is an 'immutable' object






 */

public class HowToManageStringsInJava {

    public static void main(String[] args) {

//        String s1="abc";
//        String s2="abc";
//
//        System.out.println(s1 == s2);
//
//        String s3=s1.concat("d");
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//
//        System.out.println(s1 == s3);

        //----------------------------------------------------------

//        String s4=new String("abc");
//        String s5=new String("abc");
//
//        System.out.println(s4 == s5);
//
        //------------------------------------------------------------

        // Quiz

        String a="xyz";
        String b="xyz";

        String c=new String("xyz");
        String d=new String("xyz");

        System.out.println(a==b); // true
        System.out.println(a.equals(b)); // true

        System.out.println(c==d); // false
        System.out.println(c.equals(d)); // true

        /*

            imp-note:

            => '==' operator compares references
            => 'equals' method compare obj's content

         */

        System.out.println(a=b);// assignment


    }

}
