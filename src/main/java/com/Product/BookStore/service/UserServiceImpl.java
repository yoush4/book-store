package com.Product.BookStore.service;

import com.Product.BookStore.exception.UserException;
import com.Product.BookStore.model.User;
import com.Product.BookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<HttpStatus> suspendUser(int uId){
        Optional<User> u=this.userRepository.findById(uId);
        if(u.isPresent()){
            User userUpdate=u.get();
            userUpdate.setStatus(false);
            userRepository.save(userUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new UserException("User not found with id: "+uId);
        }
    };

    @Override
    public User updateUser(User user){
        Optional<User> u=this.userRepository.findById(user.getuId());
        if(u.isPresent()){
            User userUpdate=u.get();
            userUpdate.setuId(user.getuId());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setMail(user.getMail());
            userUpdate.setPhone(user.getPhone());
            userUpdate.setWallet(user.getWallet());
            userUpdate.setStatus(user.isStatus());
            return this.userRepository.save(userUpdate);
        }else{
            throw new UserException("User not found with id: "+user.getuId());
        }
    };

    @Override
    public ResponseEntity<HttpStatus> addMoney(int uId, int money){
        Optional<User> u=this.userRepository.findById(uId);
        if(u.isPresent()){
            User userUpdate=u.get();
            if(money > 0 && money % 500 == 0)
                userUpdate.setWallet(money + u.get().getWallet());
            userRepository.save(userUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new UserException("User not found with id: "+uId);
        }

    }



    ;


}
