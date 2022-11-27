package com.Product.BookStore.service;

import com.Product.BookStore.exception.UserException;
import com.Product.BookStore.model.Book;
import com.Product.BookStore.model.BookCopies;
import com.Product.BookStore.model.Rented;
import com.Product.BookStore.model.User;
import com.Product.BookStore.repository.BookCopiesRepository;
import com.Product.BookStore.repository.BookRepository;
import com.Product.BookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Product.BookStore.repository.GeneralRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class GeneralServiceImpl implements GeneralService{

    @Autowired
    private GeneralRepository generalRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCopiesRepository bookCopiesRepository;

    @Override
    public ResponseEntity<HttpStatus> borrowBook(int uId, int bookId){

        System.out.println(uId + " " + bookId);
        Optional<User> u = userRepository.findById(uId);
        Optional<Book> b = bookRepository.findById(bookId);
        Optional<BookCopies> bc=bookCopiesRepository.findById(bookId);

        User user=u.get();

        Book book=b.get();
        System.out.println("BOOK---------------------"+book.getBookName());
        System.out.println("USER---------------------"+user.getUsername());
        BookCopies bookCopies=bc.get();
        System.out.println("COPIES---------------------"+bookCopies.getCopies());
        Rented r=new Rented();
        if(u.isPresent() && b.isPresent())
        {
            double minimum_balance=0.3*(double)(book.getPrice());
            //lastrent book wala condition missing
            if(bookCopies.getCopies()>0 && minimum_balance<user.getWallet() && user.getBooksRented()<3 && user.isStatus())
            {
                bookCopies.setCopies(bookCopies.getCopies()-1);
                user.setWallet(user.getWallet()-(int)(0.2*(double)(book.getPrice())));
                user.setBooksRented(user.getBooksRented()+1);

                r.setuId(user.getuId());
                r.setbId(book.getbId());

                //bookCopies.setCopies(bookCopies.getCopies()-1);

                generalRepository.save(r);
                bookCopiesRepository.save(bookCopies);
                userRepository.save(user);

                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    };

}
