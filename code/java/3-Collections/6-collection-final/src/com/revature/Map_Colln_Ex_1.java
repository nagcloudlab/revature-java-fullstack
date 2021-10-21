package com.revature;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Map_Colln_Ex_1 {

    public static void main(String[] args) {

        Car car1=new Car("123","model-1","white");
        Car car2=new Car("321","model-2","white");

        Owner owner1=new Owner("Nag","chennai-india");
        Owner owner2=new Owner("Indu","bengalore-india");

        /*
            key         Value
            owner-1  -> car1
            owner-2  -> car2

            Note : key must be unique , value no constraint

         */

        Map<Owner,Car> map=new HashMap<>(16,0.7F);
        map.put(owner1,car1);
        map.put(owner2,car2);

        //----------------------------------------------------------------------

        // search operation on hash-map , find car details for owner

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Owner name?");
        String ownerName=scanner.nextLine();
        Owner key=new Owner(ownerName,"Nil");
        // key => hash-code
        Car car=map.get(key); // O(1)
        if(car!=null){
            System.out.println(car);
        }else{
            System.out.println("you dont have any car");
        }

        //------------------------------------------------------------------
    }

}

