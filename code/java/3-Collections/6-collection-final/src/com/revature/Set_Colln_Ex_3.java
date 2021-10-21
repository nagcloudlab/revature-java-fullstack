package com.revature;

import java.util.HashSet;
import java.util.Set;

public class Set_Colln_Ex_3 {
    public static void main(String[] args) {

        Set<String> family=new HashSet<>();

        String s1="Nag";
        String s2="Indu";
        String s3="Riya";
        String s4="gaN";

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        family.add(s1);
        family.add(s2);
        family.add(s3);
        family.add(s4);
        family.add(s4);

        System.out.println(family);

    }
}
