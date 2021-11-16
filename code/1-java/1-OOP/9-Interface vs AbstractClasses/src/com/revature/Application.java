package com.revature;


import com.revature.work.ProjectOneWork;
import com.revature.work.ProjectTwoWork;
import com.revature.work.TechWork;

public class Application {
    public static void main(String[] args) {


        TechWork techWork=new ProjectTwoWork();

        techWork.doX();
        techWork.doY();
        techWork.doTechWork();

    }
}
