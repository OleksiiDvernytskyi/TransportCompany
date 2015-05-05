/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.jparepositories;

import com.epam.rd.transportcompany.entities.CarBrend;
import com.epam.rd.transportcompany.repositories.CarBrendRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amd
 */
@Repository("carBrendRepository")
public class JpaCarBrendRepository implements CarBrendRepository{

    @PersistenceContext(name = "MySql")
    private EntityManager em;
    
    @Override
    public CarBrend findByName(String name) {
        Query query = em.createNamedQuery("CarBrend.findByName", CarBrend.class);
        query.setParameter("name", name);
        List<CarBrend> list = query.getResultList();
        if(list != null && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Long save(CarBrend carBrend) {
        if(carBrend.getBrendId() == null){
            em.persist(carBrend);
        }else{
            em.merge(carBrend);
        }
        
        return carBrend.getBrendId();
    }

    @Override
    public List<CarBrend> readAll() {
        Query query = em.createNamedQuery("CarBrend.readAll");
        return query.getResultList();
    }

    @Override
    public CarBrend findById(Long brendId) {
        return em.find(CarBrend.class, brendId);
    }
    
}
