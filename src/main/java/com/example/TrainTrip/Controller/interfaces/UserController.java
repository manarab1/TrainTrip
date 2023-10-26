package com.example.TrainTrip.Controller.interfaces;

import com.example.TrainTrip.Entity.User;

import java.util.List;

public interface UserController {
    User getUserById(Long userId);

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);
}
