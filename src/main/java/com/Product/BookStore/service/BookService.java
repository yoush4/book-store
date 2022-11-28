package com.Product.BookStore.service;

import com.Product.BookStore.model.Book;
import com.Product.BookStore.model.BookCopies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    Book addBook(Book book);

    ResponseEntity<HttpStatus> addCopies(BookCopies bc);

    List<Book> sortedBooksByDate();
    List<Book> sortedBooksByLikes();
}
