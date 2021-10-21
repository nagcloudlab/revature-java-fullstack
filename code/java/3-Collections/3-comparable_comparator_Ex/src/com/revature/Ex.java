package com.revature;

interface  Wheel{
    void rotate();
}
class MRFWheel implements Wheel{
    public void rotate(){
        System.out.println("MRF wheel rotating");
    }
}
class Car{
    Wheel wheel;
    public void setWheel(Wheel wheel){
        this.wheel=wheel;
    }
    public void move(){
        this.wheel.rotate();
        System.out.println("car move");
    }
}


public class Ex {
    public static void main(String[] args) {

        Car car=new Car();
        car.setWheel(new MRFWheel());
        car.move();

    }
}
