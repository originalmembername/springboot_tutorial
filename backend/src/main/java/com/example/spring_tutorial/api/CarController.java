package com.example.spring_tutorial.api;

import com.example.spring_tutorial.model.Car;
import com.example.spring_tutorial.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/car")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @CrossOrigin
    @PostMapping
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }

    @CrossOrigin
    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public Car getCarById(@PathVariable("id") Integer id){
        return carService.getCarById(id)
                .orElse(null);
    }

    @CrossOrigin
    @DeleteMapping(path = "/{id}")
    public void deleteCarById(@PathVariable("id") Integer id){
        carService.deleteCarById((id));
    }

    @CrossOrigin
    @PutMapping(path = "/{id}")
    public void updateCarById(@PathVariable("id") Integer id, @RequestBody @Valid @NonNull Car car){
        carService.updateCarById(id, car);
    }
}
