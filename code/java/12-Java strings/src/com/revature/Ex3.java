package com.revature;

// Abstraction

/*
    exposing/define essential features of an objects

    why?

    => obj will be easy to use dependent
    => for loose coupling

    how to implement in java?

    => via interface-type ( most preferred )
    => class with public-methods
    => abstract-class over inheritance hierarchy

 */

// module / library / framework : datastructures using java A.k.A collection

//------------------------------------------------------
// Top-Level : Abstraction / Interface
//------------------------------------------------------
interface Collection{
    void add(String data);
    void clear();
}

/*
    types of collections

    1. List ==> arrange data in order within memory e.g array
    2. Set  ==> un-ordered

 */

interface List extends Collection{
    void add(int index,String data);
}
interface Set extends Collection{

}


//------------------------------------------------------
// Middle-Level : Partial-Implementation / AbstractClass
//------------------------------------------------------

abstract class AbstractList implements List{
    @Override
    public void clear() {

    }
}

//------------------------------------------------------
// Bottom-Level : Implementation / Class
//------------------------------------------------------

// using array datastructures
class ArrayList extends AbstractList implements List{
    @Override
    public void add(String data) {
        //..add logic on array
    }

    @Override
    public void add(int index, String data) {
        //..//..add logic on array with indx
    }
    private void doX(){}
    private void doY(){}
    private void doZ(){}
}

// using linkedlist datastructures
class LinkedList extends AbstractList implements List{
    @Override
    public void add(String data) {
        // //..add logic on linkedlist
    }

    @Override
    public void add(int index, String data) {
        //.add logic on linkedlist with index
    }

}

public class Ex3 {

    public static void main(String[] args) {

        List list=new ArrayList(); // collections
        list.add("pizza");
        list.add("burger");

        list.clear();


    }

}
