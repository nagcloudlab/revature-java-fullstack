package com.example.repository;

import com.example.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book,Integer> {

    @Query(value = "from Book b where b.publisher.name=:publisherName")
    List<Book> findByPublisher(String publisherName);

}
