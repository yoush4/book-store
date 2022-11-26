package com.Product.BookStore.controller;

import com.Product.BookStore.model.User;
import com.Product.BookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    private ResponseEntity<User> saveProduct(@RequestBody User user) {
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }
}
