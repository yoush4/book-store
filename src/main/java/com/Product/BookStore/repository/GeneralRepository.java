package com.Product.BookStore.repository;

import com.Product.BookStore.model.Rented;
import org.springframework.data.jpa.repository.JpaRepository;

//RENTED TABLE
public interface GeneralRepository extends JpaRepository<Rented,Integer> {
}
