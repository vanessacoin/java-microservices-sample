package com.vanessa.userservice.controller;

import com.vanessa.userservice.model.User;
import com.vanessa.userservice.repository.UserRepository;
import com.vanessa.userservice.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(
            userRequest.getUserId(),
            userRequest.getName(),
            userRequest.getEmail()
        );
    }
}

class UserRequest {
    private Long userId;
    private String name;
    private String email;

    public Long getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
