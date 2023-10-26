package com.example.TrainTrip.Controller.impl;

import com.example.TrainTrip.Controller.interfaces.UserController;
import com.example.TrainTrip.Entity.User;
import com.example.TrainTrip.Service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    @Override
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/{allUser}")
    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping
    @Override
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    @Override
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    @Override
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
