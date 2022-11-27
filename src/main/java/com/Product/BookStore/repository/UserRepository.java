package com.Product.BookStore.repository;

import com.Product.BookStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
}
