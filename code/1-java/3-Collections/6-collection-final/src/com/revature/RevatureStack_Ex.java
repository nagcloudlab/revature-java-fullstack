package com.revature;

// Ex. Stack collection
// condition: don't use built-in collections here

/*

    why,

    to manage data in LIFO order
    => data reverse operations

    algorithms:

        - push()
        - peek()
        - pop()
        - size()

    How to implement stack?

        -> using array or linkedlist


 */


class RevatureStack<E>{

    private Object[] data=new Object[10]; // array
    int top=-1;

    public void push(E e){
        top++;
        data[top] = e;
    }
    public E peek(){
        return (E)data[top];
    }
    public E pop(){
        E e=(E)data[top];
        data[top]=null;
        top--;
        return e;
    }
    public int size(){
        return top+1;
    }

}




public class RevatureStack_Ex {

    public static void main(String[] args) {

        RevatureStack<String> revatureStack=new RevatureStack<>();
        revatureStack.push("java");
        revatureStack.push("javascript");
        revatureStack.push("spring");
        revatureStack.push("angular");

//        String peekEle= revatureStack.peek();
//        System.out.println(peekEle);


//        System.out.println(revatureStack.size());

//        System.out.println(revatureStack.pop());
//        System.out.println(revatureStack.pop());
//        System.out.println(revatureStack.pop());
//        System.out.println(revatureStack.pop());


    }

}
