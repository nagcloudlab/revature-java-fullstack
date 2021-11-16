package com.revature;

import com.revature.bill.Billing;
import com.revature.pm.PriceMatrix;
import com.revature.pm.PriceMatrix_v1;
import com.revature.pm.PriceMatrix_v2;

public class Application {

    public static void main(String[] args) {

        //-------------------------------------
        // init phase
        //-------------------------------------

        PriceMatrix priceMatrixV1=new PriceMatrix_v1();
        PriceMatrix priceMatrixV2=new PriceMatrix_v2();

        Billing billing=new Billing(priceMatrixV2);


        //-------------------------------------
        // user phase
        //-------------------------------------

        String[] cart={"23123","345345","6767567"};
        double totalPrice=billing.getTotalPrice(cart);

        System.out.println("TotalPrice : "+totalPrice);
        System.out.println("Happy shopping");


    }

}
