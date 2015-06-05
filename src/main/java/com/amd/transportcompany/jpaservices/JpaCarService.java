/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.jpaservices;

import com.amd.transportcompany.entities.Car;
import com.amd.transportcompany.repositories.CarRepository;
import com.amd.transportcompany.services.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author a
 */
@Service("carService")
public class JpaCarService implements CarService{
    
    @Autowired 
    private CarRepository carRepository;

    @Transactional
    @Override
    public Long saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> readAll() {
        List<Car> carList = carRepository.readAll();
        for(Car c: carList){
            c.getBrend().getBrendId();
        }
        return carList;
    }

    @Transactional
    @Override
    public Car findByName(String name) {
        return carRepository.findByName(name);
    }

    @Transactional
    @Override
    public Car findById(Long carId) {
        return carRepository.findByIg(carId);
    }
    
}
