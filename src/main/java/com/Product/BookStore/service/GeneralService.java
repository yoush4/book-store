package com.Product.BookStore.service;

import com.Product.BookStore.model.Rented;
import com.Product.BookStore.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface GeneralService {

    ResponseEntity<HttpStatus> borrowBook(int uId, int bookId);

}
