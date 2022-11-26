package com.Product.BookStore.service;

import com.Product.BookStore.model.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book updateBook(Book book);
    List<Book> getBook();

    Book getBookById(long bookID);
    void deleteProd(long bookID);
}
