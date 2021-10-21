package com.revature;

import java.util.HashSet;
import java.util.Set;

public class Set_Colln_Ex_4 {

    public static void main(String[] args) {

        Car car1=new Car( "1109","model-1","white");
        Car car2=new Car( "1109","model-1","white");


        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());

//        System.out.println(car1.equals(car2));//

        Set<Car> cars=new HashSet<>();
        cars.add(car1);
        cars.add(car2);

        System.out.println(cars.size()); //


    }

}
