package com.Product.BookStore.service;

import com.Product.BookStore.exception.UserException;
import com.Product.BookStore.model.*;
import com.Product.BookStore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class GeneralServiceImpl implements GeneralService{

    @Autowired
    private GeneralRepository generalRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCopiesRepository bookCopiesRepository;

    @Autowired
    private RentedRepository rentedRepository;

    @Override
    public ResponseEntity<HttpStatus> returnBook(int rentedId){

        //System.out.println(uId + " " + bookId);
        Optional<Rented> rented = rentedRepository.findById(rentedId);


        //Optional<BookCopies> bc=bookCopiesRepository.findById(bookId);

        //User user=u.get();
        Rented r=rented.get();

        //Book book=b.get();

        //System.out.println("BOOK---------------------"+book.getBookName());
        //System.out.println("USER---------------------"+user.getUsername());
        //BookCopies bookCopies=bc.get();
        //System.out.println("COPIES---------------------"+bookCopies.getCopies());
        //Rented r=new Rented();

        if(rented.isPresent())
        {
            Optional<Book> b = bookRepository.findById(r.getbId());
            Book book=b.get();
            double rent_amount=0.1*(double)book.getPrice();
            double security_deposit=0.2*(double)book.getPrice();

            Optional<BookCopies> bc=bookCopiesRepository.findById(r.getbId());
            BookCopies bookCopies=bc.get();

            Optional<User> u=userRepository.findById(r.getuId());
            User user=u.get();

            user.setWallet(user.getWallet()+security_deposit-rent_amount);
            bookCopies.setCopies(bookCopies.getCopies()+1);
            user.setBooksRented(user.getBooksRented()-1);

            r.setReturnDateTime(LocalDateTime.now());

            generalRepository.save(r);
            bookCopiesRepository.save(bookCopies);
            userRepository.save(user);


        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<HttpStatus> borrowBook(int uId, int bookId){

        //System.out.println(uId + " " + bookId);
        Optional<User> u = userRepository.findById(uId);
        Optional<Book> b = bookRepository.findById(bookId);
        Optional<BookCopies> bc=bookCopiesRepository.findById(bookId);

        User user=u.get();

        Book book=b.get();
        //System.out.println("BOOK---------------------"+book.getBookName());
        //System.out.println("USER---------------------"+user.getUsername());
        BookCopies bookCopies=bc.get();
        //System.out.println("COPIES---------------------"+bookCopies.getCopies());
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


                generalRepository.save(r);
                bookCopiesRepository.save(bookCopies);
                userRepository.save(user);

                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<HttpStatus> reviewBook(int uId, int bookId, String review) {

        Optional<User> u = userRepository.findById(uId);
        Optional<Book> b = bookRepository.findById(bookId);
        User user=u.get();
        Book book=b.get();
        Review r=new Review();
        if(u.isPresent() && b.isPresent())
        {
            if(ifRented(uId,bookId)) {
                r.setuId(user.getuId());
                r.setbId(book.getbId());
                r.setReview(review);
                reviewRepository.save(r);
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<HttpStatus> likeBook(int uId, int bookId) {
        Optional<User> u = userRepository.findById(uId);
        Optional<Book> b = bookRepository.findById(bookId);
        //User user=u.get();
        Book book=b.get();
        if(u.isPresent() && b.isPresent())
        {
            if(ifRented(uId,bookId)) {
                book.setLikes(book.getLikes() + 1);
                bookRepository.save(book);
                return new ResponseEntity<>(HttpStatus.OK);

            }
            else{
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean ifRented(int uId, int bookId) {
        Optional<User> u = userRepository.findById(uId);
        Optional<Book> b = bookRepository.findById(bookId);
        if(u.isPresent() && b.isPresent()){
            List<Rented> list= new ArrayList<>();
            list=this.rentedRepository.findAll();
            for (Rented r:list) {
                if(r.getuId()==uId && r.getbId()==bookId){
                    return true;
                }
            }
            return false;

        }


        return false;
    }

//    @Override
//    public ResponseEntity<List<Book>> availableBooks() {
//        List<Book> list= new ArrayList<>();
//        list=this.bookRepository.findAll();
//        return (ResponseEntity<List<Book>>) list;
//    }
//    @Query(value = "select r from rented r where user_id=?1")
//     ResponseEntity<List<Rented>> showTransactions(int uId){
//
//    };



};
