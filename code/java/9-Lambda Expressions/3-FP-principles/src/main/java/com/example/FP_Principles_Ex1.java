package com.example;

/*


Java | Javascript | Python | Scala | Kotlin |

    First Class Functions

        - A function can be stored in a variable
         - A parameter of a function can be a function
        - The return value of a function can be a function


 */

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class FP_Principles_Ex1 {

    public static int add(int x, int y) {
        int r = x + y;
        return r;
    }

    //     - A parameter of a function can be a function
    public static IntPredicate and(IntPredicate p1, IntPredicate p2) {

//        - The return value of a function can be a function
        return n -> {
            return p1.test(n) && p2.test(n);
        };
    }

    public static void main(String[] args) {

        int x = 12;
        int y = 13;

        int z = add(x, y);

//     #1   - A function can be stored in a variable
        IntPredicate isMin = n -> n > 100;
        IntPredicate isMax = n -> n < 1000;

        IntPredicate isMinAndMax = and(isMin, isMax);


        int n = 300;
        boolean b = isMinAndMax.test(n);
        System.out.println(b);


    }
}
