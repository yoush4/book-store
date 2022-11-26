package com.Product.BookStore.service;

import com.Product.BookStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService {

    User createUser(User user);
    User suspendUser(User user);
    User updateUser(User user);


}
