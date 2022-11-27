package com.Product.BookStore.controller;

import com.Product.BookStore.model.Book;
import com.Product.BookStore.model.User;
import com.Product.BookStore.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @PutMapping("/books/rent/{uId}/{bookId}")
    private ResponseEntity<HttpStatus> borrowBook(@PathVariable int uId, @PathVariable int bookId){
        return generalService.borrowBook(uId,bookId);
    }

    @PutMapping("/books/return/{rentedId}")
    private ResponseEntity<HttpStatus> returnBook(@PathVariable int rentedId){
        return generalService.returnBook(rentedId);
    }

    @PostMapping("/books/review/{uId}/{bookId}")
    private ResponseEntity<HttpStatus> reviewBook(@PathVariable int uId,@PathVariable int bookId, @RequestBody String review){
        return generalService.reviewBook(uId,bookId,review);
    }

    @PostMapping("/books/like/{uId}/{bookId}")
    private ResponseEntity<HttpStatus> likeBook(@PathVariable int uId,@PathVariable int bookId){
        return generalService.likeBook(uId,bookId);
    }

    @GetMapping("/books")
    private ResponseEntity<List<Book>> availableBooks() {
        //return ResponseEntity.ok().body(this.productService.getProd());
        return null;
    }

}
