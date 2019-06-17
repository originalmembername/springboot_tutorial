package com.example.spring_tutorial.dao;

import com.example.spring_tutorial.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MySQLDao")
public class CarMySqlDao implements CarDao {
    private static List<Car> DB = new ArrayList<>();

    @Override
    public int insertCar(UUID id, Car car) {
        return 0;
    }

    @Override
    public List<Car> selectAllCars() {
        DB.add(new Car(UUID.randomUUID(), "SomeBrand", "SomeModel"));
        return DB;
    }

    @Override
    public int insertCar(Car car) {
        return 0;
    }

    @Override
    public Optional<Car> selectCarById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteCarById(UUID id) {
        return 0;
    }

    @Override
    public int updateCarById(UUID id, Car car) {
        return 0;
    }
}
