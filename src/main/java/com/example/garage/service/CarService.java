package com.example.garage.service;

import com.example.garage.model.Car;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CarService {

    private int carCounter = 1;
    private final List<Car> cars = new LinkedList<>();

    public Car addCar(Car car) {
        car.setId(carCounter);
        cars.add(car);
        carCounter++;
        return car;
    }

    public Car getCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getCars () {
        return cars;
    }
}
