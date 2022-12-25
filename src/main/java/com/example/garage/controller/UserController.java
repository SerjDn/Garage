package com.example.garage.controller;

import com.example.garage.model.User;
import com.example.garage.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/{userId}/{carId}")
    public User AddCarToUser(@PathVariable int userId, @PathVariable int carId) {
        return userService.AddCarToUser(userId, carId);
    }
}
