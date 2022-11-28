package com.Product.BookStore.controller;

import com.Product.BookStore.model.User;
import com.Product.BookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/add") //done
    private ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }

    @PutMapping("/users/suspend/{uId}") //done
    private ResponseEntity<HttpStatus> suspendUser(@PathVariable int uId){
        userService.suspendUser(uId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/users/update/{uId}") //done
    private ResponseEntity<User> updateUser(@PathVariable int uId, @RequestBody User user){
        user.setuId(uId);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }

//    @PutMapping("/users/addmoney/{uId}")
//    private ResponseEntity<User> addMoney(@PathVariable int uId, @RequestBody User user){
//        user.setuId(uId);
//        return ResponseEntity.ok().body(this.userService.addMoney(user));
//    }

    @PutMapping("/users/addmoney/{uId}/{money}") //done
    private ResponseEntity<User> addMoney(@PathVariable int uId,@PathVariable int money){
        userService.addMoney(uId,money);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
