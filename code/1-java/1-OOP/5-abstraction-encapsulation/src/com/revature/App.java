package com.revature;

import com.revature.car.Car;
import com.revature.wheel.CEATWheel;
import com.revature.wheel.MRFWheel;

public class App {
    public static void main(String[] args) {

        MRFWheel mrfWheel=new MRFWheel();
        CEATWheel ceatWheel=new CEATWheel();

        Car car=new Car(ceatWheel);

        car.move();

    }
}
