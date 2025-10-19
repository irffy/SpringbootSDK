package com.example.user_api.controller;

import com.example.user_api.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // In-memory store to hold users temporarily
    private Map<Integer, User> userStore = new HashMap<>();

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userStore.getOrDefault(id, new User(id, "Unknown", "N/A"));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        // Save user (in-memory)
        userStore.put(user.getId(), user);
        return user;
    }
}
