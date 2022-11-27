package com.Product.BookStore.service;

import com.Product.BookStore.model.Book;
import com.Product.BookStore.model.Rented;
import com.Product.BookStore.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GeneralService {

    ResponseEntity<HttpStatus> borrowBook(int uId, int bookId);

    ResponseEntity<HttpStatus> returnBook(int rentedId);

    ResponseEntity<HttpStatus> reviewBook(int uId, int bookId, String review);

    ResponseEntity<HttpStatus> likeBook(int uId, int bookId);

    //ResponseEntity<List<Book>> availableBooks();


}
