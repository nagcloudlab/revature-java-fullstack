package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicResource {

    @GetMapping("/api/public-resource")
    public String getPublicResource(){
        return "PUBLIC-RESOURCE";
    }

}
