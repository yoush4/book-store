package com.Product.BookStore.service;

import com.Product.BookStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User createUser(User user);
    ResponseEntity<HttpStatus> suspendUser(int uId);
    User updateUser(User user);

    ResponseEntity<HttpStatus> addMoney(int uId, int money);




}
