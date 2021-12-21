package com.example.web;

import com.example.config.GreetingConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

//   private String message="Hello";

//    @Value("${greeting.message:greetings}")
//    private String message;
//
//    @Value("${greeting.messages}")
//    private List<String> messages;


    @Value("${db.password}")
    String dbPassword;

    private final GreetingConfiguration greetingConfiguration;

    public GreetingController(GreetingConfiguration greetingConfiguration) {
        this.greetingConfiguration = greetingConfiguration;
    }

    @GetMapping(value = "/api/greeting",produces = {"text/plain"})
    public String getMessage(){
//        System.out.println(greetingConfiguration.getLocaleMessages().get("es"));
        System.out.println(dbPassword);
        return greetingConfiguration.getMessage();
    }

}
