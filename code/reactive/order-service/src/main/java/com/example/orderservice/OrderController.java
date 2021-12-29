package com.example.orderservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@RestController
public class OrderController {


    WebClient webClient= WebClient.builder().build();


    @PostMapping("/api/orders")
    public ResponseEntity<?> createNewOrder(@RequestBody OrderRequestPayload orderRequestPayload){

        String[] cart=orderRequestPayload.getCart();

        Arrays.stream(cart).forEach(System.out::println);

        webClient.get()
                 .uri("http://localhost:8181/api/books")
                .retrieve()
                .bodyToFlux(Book.class)
                .subscribe(result->{
                    System.out.println(result);
                });

        return ResponseEntity.ok().build();

    }

}
