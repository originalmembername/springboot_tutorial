package com.example.spring_tutorial.dao;

import com.example.spring_tutorial.model.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarDao {
     int insertCar(UUID id, Car car);

     List<Car> selectAllCars();

     default int insertCar(Car car){
         UUID id = UUID.randomUUID();
         return insertCar(id, car);
     }

     Optional<Car> selectCarById(UUID id);

     int deleteCarById(UUID id);

     int updateCarById(UUID id, Car car);
}
