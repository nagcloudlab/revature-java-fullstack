package com.revature;


import java.util.ArrayList;
import java.util.List;

class GiftBoxEmptyException extends  Exception{
    public GiftBoxEmptyException(String message) {
        super(message);
    }
}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void surprise(ArrayList giftBox) throws GiftBoxEmptyException{
        if(giftBox.isEmpty()){
            throw new GiftBoxEmptyException("expecting atleast one gift");
        }
        System.out.println(this.name+" happy with giftbox");
    }

}

public class Ex2 {
    public static void main(String[] args) {

        Person person=new Person("tasnim");

        ArrayList giftBox=new ArrayList();

        try {
            person.surprise(giftBox);
        } catch (GiftBoxEmptyException e) {
            System.out.println("oops, on that");
        }

    }
}
