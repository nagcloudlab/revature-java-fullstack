package com.example;

class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}

public class Ex6_Singleton {
    public static void main(String[] args) {

    }
}
