package com.example.spring_tutorial.dao;

import com.example.spring_tutorial.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
