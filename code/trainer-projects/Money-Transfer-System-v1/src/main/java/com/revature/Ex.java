package com.revature;

class Xyz {
    static {
        System.out.println("Xyz:static block");
    }

    public Xyz() {
        System.out.println("Xyz:constructor");
    }
}

public class Ex {

    static {
        // when this block will execute?
//        this block will execute one time when class being loaded into JVM
        // why we need?
        // to do any one time initialization at class-leve

        System.out.println("im static-block");
    }

    public static void main(String[] args) {
        System.out.println("im main");

        new Xyz();

    }
}
