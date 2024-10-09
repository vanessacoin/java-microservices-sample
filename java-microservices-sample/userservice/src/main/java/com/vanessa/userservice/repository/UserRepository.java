package com.vanessa.userservice.repository;

import com.vanessa.userservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    
    private final List<User> users = new ArrayList<>();
    private Long currentId = 1L;

    public User save(User user) {
        user.setId(currentId++);
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}