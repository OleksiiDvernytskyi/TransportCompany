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
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amd
 */
@Repository("orderRepository")
public class JpaOrderRepository implements OrderRepository{
    
    static final Integer STRINGS_ON_PAGE = 5;
    
    @PersistenceContext(name = "MySql")
    private EntityManager em;
    
    @Override
    public Long save(Order order) {
        if(order.getOrderId() == null){
            em.persist(order);
        }else{
            em.merge(order);
        }
        return order.getOrderId();
    }

    @Override
    public List getActiveOrders(Integer pageNumber) {
        Query query = em.createQuery("SELECT o FROM Order o WHERE o.status ='ACTIVE' OR o.status ='NEW' ORDER BY o.date " );
        query.setFirstResult((pageNumber * STRINGS_ON_PAGE));
        query.setMaxResults(STRINGS_ON_PAGE);
        
        return query.getResultList();
    }

    @Override
    public List<Order> findByPhone(String phone) {
        Query query = em.createQuery("SELECT o FROM Order o WHERE o.phone LIKE :phone AND ( o.status ='ACTIVE' OR o.status ='NEW') ORDER BY o.date " );
        query.setParameter("phone", "%" + phone + "%");
        
        return query.getResultList();
    }

    @Override
    public Order findById(Long id) {
        return em.find(Order.class, id);
    }
    
}
