package com.Product.BookStore.controller;

import com.Product.BookStore.model.Book;
import com.Product.BookStore.model.BookCopies;
import com.Product.BookStore.model.User;
import com.Product.BookStore.service.BookService;
import com.Product.BookStore.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private GeneralService generalService;

    @PostMapping("/books/add") //done
    private ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(this.bookService.addBook(book));
    }


    @PostMapping("/books/addcopies") //done
    private ResponseEntity<HttpStatus> addCopies( @RequestBody BookCopies bc){
        //bc.setbId(bId);
        bookService.addCopies(bc);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/sortBooksByDate")
    private List<Book> sortedBooksByDate(){
        return bookService.sortedBooksByDate();
    }
    @GetMapping("/sortBooksByLikes")
    private  List<Book> sortedBooksByLikes(){
        return bookService.sortedBooksByLikes();
    }

}
