package com.example.TrainTrip.Service.interfaces;

import com.example.TrainTrip.Entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long userId);
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
}
