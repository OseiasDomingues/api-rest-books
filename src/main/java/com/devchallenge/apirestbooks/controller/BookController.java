package com.devchallenge.apirestbooks.controller;

import com.devchallenge.apirestbooks.model.Book;
import com.devchallenge.apirestbooks.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookServices bookServices;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> list = bookServices.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book book = bookServices.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping
    public ResponseEntity<Book> findById(@RequestBody Book obj){
        Book book = bookServices.insert(obj);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
}
