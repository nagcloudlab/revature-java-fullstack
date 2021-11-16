package com.revature;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Set_Colln_Ex_2 {
    public static void main(String[] args) {

        Chapter chapter1=new Chapter(1,"title1");
        Chapter chapter2=new Chapter(3,"title3");
        Chapter chapter3=new Chapter(4,"title4");
        Chapter chapter4=new Chapter(2,"title2.1");
        Chapter chapter5=new Chapter(2,"title2.2");

        Set<Chapter> chapters=new TreeSet<>(new IndexCompatator());
        chapters.add(chapter1);
        chapters.add(chapter2);
        chapters.add(chapter3);
        chapters.add(chapter4);
        chapters.add(chapter5);
        display(chapters);
    }

    private static void display(Set<Chapter> chapters) {
        for(Chapter chapter:chapters){
            System.out.println(chapter);
        }
    }
}

class IndexCompatator implements Comparator<Chapter>{
    @Override
    public int compare(Chapter o1, Chapter o2) {
        return Integer.compare(o1.getIndex(),o2.getIndex());
    }
}
