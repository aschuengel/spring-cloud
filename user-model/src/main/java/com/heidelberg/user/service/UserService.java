package com.heidelberg.user.service;

import com.heidelberg.user.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/users")
public interface UserService {
    @GetMapping
    List<User> getUsers();
    @GetMapping("{id}")
    User getUser(@PathVariable("id") String id);
    @DeleteMapping("{id}")
    void deleteUserById(@PathVariable("id") String id);
    @PutMapping
    void updateUser(User user);
    @PostMapping
    String createUser(User user);
}