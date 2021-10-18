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

//        String a="xyz";
//        String b="xyz";
//
//        String c=new String("xyz");
//        String d=new String("xyz");
//
//        System.out.println(a==b); // true
//        System.out.println(a.equals(b)); // true
//
//        System.out.println(c==d); // false
//        System.out.println(c.equals(d)); // true

        /*

            imp-note:

            => '==' operator compares references
            => 'equals' method compare obj's content

         */

//        System.out.println(a=b);// assignment

        //---------------------------------------------------


        String s="abcdefgha";
        System.out.println(s.length());
        System.out.println(s.charAt(7));
        System.out.println(s.indexOf(97)); // 97 = 'a' , 65 = 'A'
        System.out.println(s.indexOf('a'));
        System.out.println(s.indexOf('i'));
        System.out.println(s.indexOf("cde"));
        System.out.println(s.indexOf('a'));
        System.out.println(s.lastIndexOf('a'));

        System.out.println(s.startsWith("abc"));
        System.out.println(s.endsWith("ghi"));
        System.out.println(s.contains("ced"));


        String x="Abc";
        String y="abc";

        System.out.println(x.equals(y));
        System.out.println(x.equalsIgnoreCase(y));


        String name1="nag";
        String name2="nAg";

        System.out.println(name1.compareTo(name2));
        System.out.println(name1.compareToIgnoreCase(name2));


        String str=" abc ";
        System.out.println(str.isEmpty());
        System.out.println(str.isBlank());

        String givenName="   Nag ";
        String actualName="Nag";
        System.out.println(givenName.trim().equals(actualName));


        String menu="idly vada poori";
        String[] menuItems=menu.split(" "); // delim , common delims are , space, , ;
        for(String menuItem:menuItems){
            System.out.println(menuItem);
        }



        String filePath1="c:/dir1/dir2/dir3/filename1.jpg";
        String filePath2="c:/dir1/dir2/filename2.jpg";

        int lastSlashIdx=filePath2.lastIndexOf("/");
        String fileName=filePath2.substring(lastSlashIdx);
        System.out.println(fileName);


        String ss="abc";
        char[] ca=ss.toCharArray(); // String to char array
        ss=new String(ca); //  char-array to string


        String ssn="123-33-232a";

        // validate given user ssn with format xxx-xx-xxxx , here x is digit

        // solution-1:
        boolean isValid=true;
        if(ssn.length()==11){
            for (int i = 0; i < 11; i++) {
                char ch=ssn.charAt(i);
                if(i==3 || i==6){
                    // check is that char is '-'
                    if(ch != '-'){
                        isValid=false;
                        break;
                    }
                }else{
                    // check is that char is 'digit'
                    if("1234567890".indexOf(ch)==-1){
                        isValid=false;
                        break;
                    }
                }
            }

        }else{
            isValid=false;
        }


        // Solution-2 using 'Regular Expression'
        // use case : pattern matching
        String ssnPattern="\\d{3}-\\d{2}-\\d{4}";
        isValid=ssn.matches(ssnPattern);


        if(isValid){
            System.out.println("valid ssn");
        }else{
            System.out.println("invalid ssn");
        }


        System.out.println("*".repeat(10));

        System.out.println("Nag".replace('N','n'));

        //----------------------------------------------------------------

        // any primitive value to String
        int n=123;
        String sn=String.valueOf(n);
        System.out.println(sn);

        // String to to primitive

        String v="2546798";
        int i=Integer.parseInt(v);

        //----------------------------------------------------------------

    }

}
