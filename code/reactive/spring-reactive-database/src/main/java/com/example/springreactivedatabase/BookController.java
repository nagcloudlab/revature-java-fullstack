package com.example.springreactivedatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/api/books")
    public Flux<Book> getAll(){
        return bookRepository.findAll(); // Non-blocking
    }

}
