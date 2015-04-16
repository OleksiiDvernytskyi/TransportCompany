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
import javax.persistence.Query;
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
    
    @Override
    public Long save(Car car) {
        em.persist(car);
        return car.getCarId();
    }

    @Override
    public List<Car> readAll() {
        Query query = em.createQuery("SELECT u FROM Car u ORDER BY u.carModel");
        return query.getResultList();
    }

    @Override
    public Car findByIg(Long carId) {
        return em.find(Car.class, carId);
    }

    @Override
    public Car findByName(String name) {
        Query query = em.createQuery("SELECT u FROM Car u WHERE u.carModel =:name");
        query.setParameter("name", name);
        List<Car> list = query.getResultList();
        if( !list.isEmpty() ){
            return list.get(0);
        }
        return null;
    }
}
