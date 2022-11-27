package com.Product.BookStore.controller;

import com.Product.BookStore.model.User;
import com.Product.BookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/add")
    private ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }

    @PutMapping("/users/suspend/{uId}")
    private ResponseEntity<User> suspendUser(@PathVariable int uId, @RequestBody User user){
        user.setuId(uId);
        return ResponseEntity.ok().body(this.userService.suspendUser(user));
    }

    @PutMapping("/users/update/{uId}")
    private ResponseEntity<User> updateUser(@PathVariable int uId, @RequestBody User user){
        user.setuId(uId);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }



}
