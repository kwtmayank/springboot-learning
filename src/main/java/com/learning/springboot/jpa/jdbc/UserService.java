package com.learning.springboot.jpa.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public int createUser(User user) {
        return userRepository.createUser(user.getName(), user.getAge());
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
