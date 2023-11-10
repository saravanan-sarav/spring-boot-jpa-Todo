package com.codewithsarav.springbootjpa.service;

import com.codewithsarav.springbootjpa.model.User;
import com.codewithsarav.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(User user) {
        User loggedInUser = userRepository.findUserIsValid(user.getUserName(), user.getPassword());
        return loggedInUser;
    }

    public User register(User user) {
        userRepository.save(user);
        return user;
    }
}
