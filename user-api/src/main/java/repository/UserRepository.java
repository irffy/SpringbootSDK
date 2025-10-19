package com.example.user_api.repository;

import com.example.user_api.model.User;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UserRepository {

    // In-memory store
    private Map<Integer, User> userStore = new HashMap<>();

    public User save(User user) {
        userStore.put(user.getId(), user);
        return user;
    }

    public User findById(int id) {
        return userStore.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(userStore.values());
    }

    public void deleteById(int id) {
        userStore.remove(id);
    }

    public boolean existsById(int id) {
        return userStore.containsKey(id);
    }
}
