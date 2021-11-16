package com.revature.wheel;

public class MRFWheel implements Wheel {


    // Overriding
    public int rotate(int speed){
        //..
        System.out.println("MRF wheel rotating..");
        return 60*speed;
    }


}
