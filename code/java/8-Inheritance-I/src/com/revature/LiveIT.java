package com.revature;

import com.revature.god.God;
import com.revature.live.*;

public class LiveIT {
    public static void main(String[] args) {

        God god=new God();


        Human human=new MaleHuman();
        Animal animal=new Animal();
        Robot robot=new Robot();


        god.manageLT(human);
        System.out.println();
        god.manageLT(animal);
        System.out.println();
        god.manageLT(robot);






    }
}
