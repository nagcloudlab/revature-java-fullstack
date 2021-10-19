package com.revature.live;


// Author: LivingTeam
// parent / super / base / generalized class

public abstract class LivingThing {

    public void eat(){
        System.out.println("LT: eat");
    }
    public final void sleep(){
        System.out.println("LT: sleep");
    }
    public abstract void work();

}
