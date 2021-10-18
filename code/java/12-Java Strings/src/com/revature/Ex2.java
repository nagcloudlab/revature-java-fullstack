package com.revature;

// static polymorphism
/*

    => we dont know what behav get invoked at coding time

    how to implement ?

    => via method-overring with inheritance

 */

abstract class Training{
    abstract void  doTraining(String subject);
}

class TechTraining extends Training{
    @Override
    void doTraining(String subject) {
        System.out.println("techincal training : "+subject);
    }
}

class ManagementTraining extends Training{
    @Override
    void doTraining(String subject) {
        System.out.println("management training : "+subject);
    }
}

class Revature {
    void doTraining(Training training,String subject){
        training.doTraining(subject); // we r uncertain what behav it will
    }
}

public class Ex2 {
    public static void main(String[] args) {

        Revature revature=new Revature();
        revature.doTraining(new TechTraining(),"Fullstack java");
        revature.doTraining(new ManagementTraining(),"Fullstack java");

    }
}
