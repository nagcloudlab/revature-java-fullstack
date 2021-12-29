package com.example.springreactivedatabase;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {
}
