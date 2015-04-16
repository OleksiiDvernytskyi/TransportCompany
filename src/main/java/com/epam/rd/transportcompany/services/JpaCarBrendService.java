/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.services;

import com.epam.rd.transportcompany.entities.CarBrend;
import com.epam.rd.transportcompany.repositories.CarBrendRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amd
 */
@Service("carBrendService")
public class JpaCarBrendService implements CarBrendService{

    @Autowired
    private CarBrendRepository carBrendRepository;
    
    @Transactional
    @Override
    public CarBrend findByName(String name) {
        return carBrendRepository.findByName( name); 
    }

    @Transactional
    @Override
    public Long save(CarBrend carBrend) {
        
        return carBrendRepository.save(carBrend);
    }

    @Override
    public List<CarBrend> readAll() {
        return carBrendRepository.readAll();
    }

    @Override
    public CarBrend findById(Long brendId) {
        return carBrendRepository.findById(brendId);
    }
    
}
