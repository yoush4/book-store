package com.Product.BookStore.service;

import com.Product.BookStore.exception.UserException;
import com.Product.BookStore.model.Book;
import com.Product.BookStore.model.BookCopies;
import com.Product.BookStore.model.User;
import com.Product.BookStore.repository.BookCopiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Product.BookStore.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCopiesRepository bookCopiesRepository;
    @Override
    public Book addBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public ResponseEntity<HttpStatus> addCopies(BookCopies bc) {
        Optional<BookCopies> b=this.bookCopiesRepository.findById(bc.getbId());
        if(b.isPresent()){
            BookCopies copiesAdd=b.get();
            copiesAdd.setCopies(b.get().getCopies()+bc.getCopies());

            bookCopiesRepository.save(copiesAdd);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            bookCopiesRepository.save(bc);
            return new ResponseEntity<>(HttpStatus.OK);

        }
    }

    @Override
    public List<Book> sortedBooksByDate() {
        List<Book> bookItems= bookRepository.findAll();
        bookItems.sort(Comparator.comparing(Book::getLocalDateTime));
        return bookItems;
    }

    @Override
    public List<Book> sortedBooksByLikes() {
        List<Book> bookItems= bookRepository.findAll();
        bookItems.sort(Comparator.comparing(Book::getLikes).reversed());
        return bookItems;
    }
}
