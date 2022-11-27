package com.Product.BookStore.repository;

import com.Product.BookStore.model.Rented;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RentedRepository extends JpaRepository<Rented,Integer> {
//    @Query(value = "select r from rented r where r.user_id=?1")
//    ResponseEntity<List<Rented>> showTransactions(int userId);

}
