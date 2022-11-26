package com.Product.BookStore.service;

import com.Product.BookStore.model.User;
import com.Product.BookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
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
        return user;
    };

    @Override
    public User updateUser(User user){
        return user;
    };


}
