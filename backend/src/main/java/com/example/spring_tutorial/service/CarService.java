package com.example.spring_tutorial.service;

import com.example.spring_tutorial.dao.CarRepository;
import com.example.spring_tutorial.model.Car;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CarService {

    @Autowired
    public CarService( CarRepository carDao) {
        this.carDao = carDao;
    }

    @Autowired
    private final CarRepository carDao;

    public int addCar(Car car){
        if(car.getId() == null){
            car.setId(ThreadLocalRandom.current().nextInt());
        }
        if(!carDao.existsById(car.getId())){
            carDao.save(car);
            return 0;
        }
        return 1;
    }

    public List<Car> getAllCars(){
        Iterable<Car> carIterable = carDao.findAll();
        return Lists.newArrayList(carIterable);
    }

    public Optional<Car> getCarById(Integer id){
        return  carDao.findById(id);
    }

    public int deleteCarById(Integer id){
        if(carDao.existsById(id)){
            carDao.deleteById(id);
            return 0;
        }
        return 1;
    }

    public int updateCarById(Integer id, Car newCar){
        Optional<Car> carMaybe = carDao.findById(id);
        if(carMaybe.isEmpty()){
            return 1;
        }
        else {
            Car car = carMaybe.get();
            car.setBrand(newCar.getBrand());
            car.setModel(newCar.getModel());
            carDao.save(car);
            return 0;
        }
    }
}
