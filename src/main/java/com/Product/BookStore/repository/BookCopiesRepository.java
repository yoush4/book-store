package com.Product.BookStore.repository;

import com.Product.BookStore.model.BookCopies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopiesRepository extends JpaRepository<BookCopies, Integer> {
}
