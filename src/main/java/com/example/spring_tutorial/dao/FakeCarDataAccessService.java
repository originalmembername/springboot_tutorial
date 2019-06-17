package com.example.spring_tutorial.dao;

import com.example.spring_tutorial.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakeDao")
public class FakeCarDataAccessService implements CarDao {
    private static List<Car> DB = new ArrayList<>();

    @Override
    public int insertCar(UUID id, Car car) {
        DB.add(new Car(id, car.getBrand(), car.getModel()));
        return 1;
    }

    @Override
    public List<Car> selectAllCars() {
        return DB;
    }

    @Override
    public int deleteCarById(UUID id) {
        Optional<Car> car = selectCarById(id);
        if (car.isEmpty()){
            return 0;
        }
        else{
            DB.remove(car.get());
            return 1;
        }
    }

    @Override
    public int updateCarById(UUID id, Car updatedCar) {
        //c = selectCarById(id)
        return selectCarById(id)
                .map((car->{
                    int indexOfCarToUpdate = DB.indexOf(car);
                    if(indexOfCarToUpdate >= 0){
                        DB.set(indexOfCarToUpdate, new Car(car.getId(),updatedCar.getBrand(),updatedCar.getModel()));
                        return 1;
                    }
                    return 0;
                }))
                .orElse(0);
    }

    @Override
    public Optional<Car> selectCarById(UUID id) {
        return DB.stream().
                filter(car -> car.getId().equals(id))
                .findFirst();
    }
}
