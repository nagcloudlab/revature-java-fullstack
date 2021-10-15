package com.revature.bill;

import com.revature.pm.PriceMatrix;
import com.revature.pm.PriceMatrix_v1;

/**
 *
 *  Team-2
 *
 */

/*

    design  & performance issues
    ----------------------------------

    => dependent & dependency components are tightly-coupled
    => too many dependency instances created & destroyed
    => unit-testing not possible

    reason for these issues?

    => dependent it's own creating dependency

    solution:

    => don't create dependency in dependent's home ( class ), inject from externally

    how ?

    => through 'dependency injection'

       types

        => constructor-level dependency injection for mandatory dependencies
        => setter-level dependency injection for optional dependencies

    -------------------------------------------------------------------

    OO programing principles  a.k.a S.O.L.I.D principles

    S: Single-responsibility principle
    O: Open for extension-closed for modification principle
    L: Liskov substitution principle
    I: Interface segregation principle
    D: Dependency inversion principle

    -------------------------------------------------------------------



 */


public class Billing {

    private PriceMatrix priceMatrix;

    public Billing(PriceMatrix priceMatrix){
        this.priceMatrix=priceMatrix;
    }

    public double getTotalPrice(String[] cart){
        double totalPrice=0.0;
//        PriceMatrix_v1 priceMatrix=new PriceMatrix_v1();
        for(String itemCode:cart){
            totalPrice=totalPrice+priceMatrix.getPrice(itemCode);
        }
        return totalPrice;
    }

}
