package com.example;

import com.example.config.TransferServiceConfiguration;
import com.example.service.TransferService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        //------------------------------------------------------
        // boot/init phase
        //------------------------------------------------------

        System.out.println("-".repeat(50));

        ConfigurableApplicationContext applicationContext=null;
        applicationContext= SpringApplication.run(TransferServiceConfiguration.class);

        System.out.println("-".repeat(50));


        //------------------------------------------------------
        //Use
        //------------------------------------------------------

        TransferService transferService=applicationContext.getBean(TransferService.class);
        transferService.transfer(100.00,"1","2");


        //------------------------------------------------------
        //Destroy phase
        //------------------------------------------------------

    }
}
