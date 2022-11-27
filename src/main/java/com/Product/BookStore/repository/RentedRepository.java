package com.Product.BookStore.repository;

import com.Product.BookStore.model.Rented;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentedRepository extends JpaRepository<Rented,Integer> {
}
