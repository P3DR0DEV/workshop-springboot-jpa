package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(UUID id) {
        Optional<User> user = repository.findById(id);

        return user.orElse(null);
    }

    public User insert(User user) {
        User userInserted = repository.save(user);

        return userInserted;
    }
}
