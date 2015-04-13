/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.repositories;

import com.epam.rd.transportcompany.entities.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author a
 */
@Repository("carRepository")
public class JpaCarRepository implements CarRepository{
    
    @PersistenceContext(name = "MySql")
    private EntityManager em;
    
    @Transactional
    @Override
    public Long save(Car car) {
        em.persist(car);
        return car.getCarId();
    }

    @Override
    public List<Car> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
