package com.revature;

public class Ex {

    public static void main(String[] args) {

        int[] arr1=new int[5];
        arr1[0]=10;
        arr1[1]=20;
        arr1[2]=30;
        arr1[3]=40;
        arr1[4]=50;

        int[] arr2=new int[arr1.length+5];
        System.arraycopy(arr1,0,arr2,0,arr1.length);
        arr2[5]=60;

        for(int n:arr2){
            System.out.println(n);
        }


        // Any Q, im here


    }

}
