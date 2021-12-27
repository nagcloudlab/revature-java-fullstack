package com.example.restapi;

import com.example.entities.Publisher;
import com.example.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// uri = /api/v1/publishers

@AllArgsConstructor
@RestController
public class PublisherController {

    private PublisherRepository publisherRepository;


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/v1/publishers",
            consumes = {"application/json"}
    )
    public ResponseEntity<?> save(@RequestBody Publisher publisher){
        publisher=publisherRepository.save(publisher);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(publisher);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/v1/publishers"
    )
    public ResponseEntity<?> getAll(){
       Iterable<Publisher> publishers= publisherRepository.findAll();
       return ResponseEntity
               .status(HttpStatus.OK)
               .body(publishers);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/v1/publishers/{publisherId}"
    )
    public ResponseEntity<?> getOne(@PathVariable(name="publisherId")int publisherId){
        Optional<Publisher> optional = publisherRepository.findById(publisherId);
        if(optional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(optional.get());
        }else {
            return ResponseEntity
                            .status(HttpStatus.NOT_FOUND)
                            .body(null);
        }
    }


    @RequestMapping(
            method = RequestMethod.PUT,
//            method = RequestMethod.PATCH,
            value = "/api/v1/publishers/{publisherId}"
    )
    public ResponseEntity<?> update(
            @PathVariable(name = "publisherId") int publisherId,
            @RequestBody Publisher publisher
                                    ){
        Optional<Publisher> optional = publisherRepository.findById(publisherId);
        if(optional.isPresent()) {
            publisher.setId(publisherId);
            publisher=publisherRepository.save(publisher); // update
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(publisher);
        }else {
            publisher=publisherRepository.save(publisher); // insert
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(publisher);
        }
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/api/v1/publishers/{publisherId}"
    )
    public ResponseEntity<?> deleteOne(@PathVariable(name = "publisherId") int publisherId){
        publisherRepository.deleteById(publisherId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    @RequestMapping(
            method = RequestMethod.HEAD,
            value = "/api/v1/publishers/{publisherId}"
    )
    public ResponseEntity<?> getHeadOne(@PathVariable(name="publisherId")int publisherId){
        Optional<Publisher> optional = publisherRepository.findById(publisherId);
        if(optional.isPresent()) {
            HttpHeaders httpHeaders=new HttpHeaders();

            httpHeaders.add("Last-Modified", LocalDate.now().toString());
            httpHeaders.add("Content-Size","1000");

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(httpHeaders)
                    .body(null);
        }else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }


}

/*
    POST ==> to create  resource
    PUT  ==> to create  resource if not exist else to update
 */
