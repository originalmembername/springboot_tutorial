package com.example.spring_tutorial.api;

import com.example.spring_tutorial.model.Car;
import com.example.spring_tutorial.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/car")
@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void addCar(@RequestBody @Valid @NonNull Car car){
        carService.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping(path = "/{id}")
    public Car getCarById(@PathVariable("id") UUID id){
        return carService.getCarById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCarById(@PathVariable("id") UUID id){
        carService.deleteCarById((id));
    }

    @PutMapping(path = "/{id}")
    public void updateCarById(@PathVariable("id") UUID id, @RequestBody @Valid @NonNull Car car){
        carService.updateCarById(id, car);
    }
}
