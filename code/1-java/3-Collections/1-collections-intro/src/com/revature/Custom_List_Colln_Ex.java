package com.revature;


import java.util.Iterator;

class NagList<E> implements Iterable<E> {

    // array or linkedlist or tree or hashtable or graph
    private Object[] items = new Object[10];
    private int count = 0;

    public void add(E e) {
        items[count] = e;
        count++;
    }

    public E get(int i) {
        return (E) items[i];
    }

    public int size() {
        return count;
    }

    @Override
    public Iterator<E> iterator() {

        class Itr implements Iterator {
            int cursor = 0;
            @Override
            public boolean hasNext() {
                if (cursor < count) // 0 < 4
                    return true;
                else
                    return false;
            }

            @Override
            public E next() {
                E e = (E) items[cursor];
                cursor++;
                return e;
            }
        }

        return new Itr();
    }
}


public class Custom_List_Colln_Ex {
    public static void main(String[] args) {

        NagList<String> nagList = new NagList<>();
        nagList.add("A");
        nagList.add("B");
        nagList.add("D");
        nagList.add("C");

        Iterator<String> iterator = nagList.iterator();
        while (iterator.hasNext()) {
            String stringItem = iterator.next();
            System.out.println(stringItem);
        }

        // -or-

        for(String item:nagList){
            System.out.println(item);
        }

    }
}
