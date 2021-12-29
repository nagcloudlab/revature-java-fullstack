package com.example.restapi;

import com.example.entities.Book;
import com.example.entities.Publisher;
import com.example.repository.BookRepository;
import com.example.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/v1/books",
            consumes = {"application/json"}
    )
    public ResponseEntity<?> save(@RequestBody Book book) {
        Optional<Publisher> optionalPublisher=publisherRepository.findById(book.getPublisherId());
        book.setPublisher(optionalPublisher.get());
        bookRepository.save(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(book);
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/v1/books",
            consumes = {"application/json"}
    )
    public ResponseEntity<?> getAll() {
        Iterable<Book> books= bookRepository.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(books);
    }


}
