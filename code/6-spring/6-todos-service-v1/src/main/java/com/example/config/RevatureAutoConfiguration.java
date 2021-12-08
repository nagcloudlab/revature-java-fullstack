package com.example.config;

import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RevatureAutoConfiguration {

    @Bean
    public String bean1(){
        return "BEAN-1";
    }

    @Bean
    public String bean2(){
        return "BEAN-2";
    }

}
