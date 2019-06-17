package com.example.spring_tutorial.service;

import com.example.spring_tutorial.dao.CarDao;
import com.example.spring_tutorial.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    public CarService(@Qualifier("MySQLDao") CarDao carDao) {
        this.carDao = carDao;
    }

    private final CarDao carDao;

    public int addCar(Car car){
         return carDao.insertCar(car);
    }

    public List<Car> getAllCars(){
        return carDao.selectAllCars();
    }

    public Optional<Car> getCarById(UUID id){
        return  carDao.selectCarById(id);
    }

    public int deleteCarById(UUID id){
        return carDao.deleteCarById(id);
    }

    public int updateCarById(UUID id, Car car){
        return carDao.updateCarById(id, car);
    }
}
