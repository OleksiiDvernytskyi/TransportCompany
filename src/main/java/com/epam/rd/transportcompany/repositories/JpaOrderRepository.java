/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.repositories;

import com.epam.rd.transportcompany.entities.Order;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amd
 */
@Repository("orderRepository")
public class JpaOrderRepository implements OrderRepository{

    @PersistenceContext(name = "MySql")
    private EntityManager em;
    
    @Transactional
    @Override
    public Long save(Order order) {
        em.persist(order);
        return order.getOrderId();
    }

    @Override
    public List<Order> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
