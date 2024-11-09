package com.api.grocery_booking.service;

import com.api.grocery_booking.model.User;
import com.api.grocery_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Add user
     * @param user
     * @return User
     */
    public User addUser(User user){
        return userRepository.save(user);
    }

    /**
     * Fetch all the users
     * @return Users
     */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
