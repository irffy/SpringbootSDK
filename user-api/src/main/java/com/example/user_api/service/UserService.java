package com.example.user_api.service;

import com.example.user_api.model.User;
import com.example.user_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    // Constructor injection
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User getUserById(int id) {
        return repository.findById(id);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(int id, User user) {
        if (repository.existsById(id)) {
            return repository.save(user);
        }
        return null;
    }

    public void deleteUser(int id) {
        repository.deleteById(id);
    }
}
