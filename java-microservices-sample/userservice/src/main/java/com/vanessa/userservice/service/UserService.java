package com.vanessa.userservice.service;

import com.vanessa.userservice.model.User;
import com.vanessa.userservice.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public User createUser(Long userId, String name, String email) {
        return new User(userId, name, email);
    }
}
