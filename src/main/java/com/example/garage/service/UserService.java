package com.example.garage.service;

import com.example.garage.model.Car;
import com.example.garage.model.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    private int userCounter = 1;
    private List<User> users = new LinkedList<>();
    private CarService carService;

    public UserService(CarService carService) {
        this.carService = carService;
    }

    public User addUser(User user) {
        user.setId(userCounter);
        user.setUserCars(new LinkedList<Car>());
        users.add(user);
        userCounter++;
        return user;
    }

    public User getUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.get(i);
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

    public User AddCarToUser(int userId, int carId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {

                List<Car> tempCars = users.get(i).getUserCars();
                tempCars.add(carService.getCar(carId));
                users.get(i).setUserCars(tempCars);

                return users.get(i);
            }
        }
        return null;
    }
}
