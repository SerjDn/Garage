package com.example.garage.service;

import com.example.garage.model.Car;
import com.example.garage.model.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    private int userCounter = 1;
    private final List<User> users = new LinkedList<>();
    private final CarService carService;

    public UserService(CarService carService) {
        this.carService = carService;
    }

    public User addUser(User user) {
        user.setId(userCounter);
        user.setUserCars(new LinkedList<>());
        users.add(user);
        userCounter++;
        return user;
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

    public User AddCarToUser(int userId, int carId) {
        for (User user : users) {
            if (user.getId() == userId) {

                List<Car> tempCars = user.getUserCars();
                tempCars.add(carService.getCar(carId));
                user.setUserCars(tempCars);

                return user;
            }
        }
        return null;
    }
}
