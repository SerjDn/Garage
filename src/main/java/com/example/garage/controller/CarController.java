package com.example.garage.controller;

import com.example.garage.model.Car;
import com.example.garage.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public String getCar(@PathVariable int id, Model model) {
        model.addAttribute("car", carService.getCar(id));
        return "car";
    }

    @GetMapping
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getCars());
        return "cars";
    }

    @PostMapping
    public String addCar(@RequestBody Car car, Model model) {
        model.addAttribute("car", carService.addCar(car));
        return "car";
    }
}
