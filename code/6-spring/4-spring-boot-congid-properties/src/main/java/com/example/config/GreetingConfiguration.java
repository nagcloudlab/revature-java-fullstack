package com.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "greeting")
public class GreetingConfiguration {

    private String message;
    private List<String> messages;
    private Map<String,String> localeMessages;


}
