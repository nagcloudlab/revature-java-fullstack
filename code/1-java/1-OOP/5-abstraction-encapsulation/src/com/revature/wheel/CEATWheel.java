package com.revature.wheel;

public class CEATWheel implements Wheel {

    public int rotate(int speed){
        System.out.println("ceat wheel rotating...");
        return 80*speed;
    }

}
