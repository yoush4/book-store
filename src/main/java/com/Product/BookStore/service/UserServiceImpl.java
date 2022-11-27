package com.Product.BookStore.service;

import com.Product.BookStore.exception.UserException;
import com.Product.BookStore.model.User;
import com.Product.BookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User suspendUser(User user){
        Optional<User> u=this.userRepository.findById(user.getuId());
        if(u.isPresent()){
            User userUpdate=u.get();
            userUpdate.setStatus(false);
            return this.userRepository.save(userUpdate);
        }else{
            throw new UserException("User not found with id: "+user.getuId());
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
    public User addMoney(User user){
        Optional<User> u=this.userRepository.findById(user.getuId());
        if(u.isPresent()){
            User userUpdate=u.get();
            if(user.getWallet() > 0 && user.getWallet() % 500 == 0)
                userUpdate.setWallet(user.getWallet() + u.get().getWallet());
            return this.userRepository.save(userUpdate);
        }else{
            throw new UserException("User not found with id: "+user.getuId());
        }

    }



    ;


}
