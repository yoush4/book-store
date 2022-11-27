package com.Product.BookStore.controller;

import com.Product.BookStore.model.User;
import com.Product.BookStore.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @PutMapping("/users/rent/{uId}/{bookId}")
    private ResponseEntity<HttpStatus> borrowBook(@PathVariable int uId, @PathVariable int bookId){
        return generalService.borrowBook(uId,bookId);
    }

    @PostMapping("/books/review/{uId}/{bookId}")
    private ResponseEntity<HttpStatus> updateUser(@PathVariable int uId,@PathVariable int bookId, @RequestBody String review){
        return generalService.reviewBook(uId,bookId,review);
    }

}
