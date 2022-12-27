package com.example.garage.controller;

import com.example.garage.model.User;
import com.example.garage.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @PostMapping
    public String addUser(@RequestBody User user, Model model) {
        model.addAttribute("user", userService.addUser(user));
        return "user";
    }

    @PostMapping("/{userId}/{carId}")
    public String AddCarToUser(@PathVariable int userId, @PathVariable int carId, Model model) {
        model.addAttribute("user", userService.AddCarToUser(userId, carId));
        return "user";
    }
}
