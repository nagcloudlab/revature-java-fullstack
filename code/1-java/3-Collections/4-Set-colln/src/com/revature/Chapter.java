package com.revature;

//import java.lang.Comparable;

public class Chapter implements Comparable<Chapter>{
    private int index;
    private String title;
    public Chapter(int index, String title) {
        this.index = index;
        this.title = title;
    }
    public int getIndex() {
        return index;
    }
    public String getTitle() {
        return title;
    }
    @Override
    public int compareTo(Chapter o) {
        return Integer.compare(this.getIndex(),o.getIndex());
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "index=" + index +
                ", title='" + title + '\'' +
                '}';
    }
}
