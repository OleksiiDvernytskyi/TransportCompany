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
    
    static final Integer STRINGS_ON_PAGE = 20;
    
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
    public List getActiveOrders(Integer pageNumber, String phone) {
        Query query = em.createNamedQuery("Order.getActiveOrders");
        query.setParameter("phone", "%" + phone + "%");
        query.setFirstResult(((pageNumber-1) * STRINGS_ON_PAGE));
        query.setMaxResults(STRINGS_ON_PAGE);
        
        return query.getResultList();
    }

//    @Override
//    public List<Order> findByPhone(String phone) {
//        Query query = em.createNamedQuery("Order.getActiveOrdersByPhone");
//        query.setParameter("phone", "%" + phone + "%");
//        
//        return query.getResultList();
//    }

    @Override
    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> getArchiveOrders(Integer pageNumber, String phone) {
        Query query = em.createNamedQuery("Order.getArchiveOrders");
        query.setParameter("phone", "%" + phone + "%");
        query.setFirstResult(((pageNumber-1)* STRINGS_ON_PAGE));
        query.setMaxResults(STRINGS_ON_PAGE);
        
        return query.getResultList();
    }

    @Override
    public List<Order> getActiveOrdersByUserID(Long userId) {
        Query query = em.createNamedQuery("Order.getActiveOrdersByUserId");
        query.setParameter("userId", userId);
        
        return query.getResultList();
    }

    @Override
    public Long getActivePagesCount(String phone) {
        Query query = em.createNamedQuery("Order.getActivePagesCount");
        query.setParameter("phone", "%" + phone + "%");
        
        return ((Long)query.getSingleResult())/STRINGS_ON_PAGE;
    }
   
    @Override
    public Long getArchivePagesCount(String phone) {
        Query query = em.createNamedQuery("Order.getArchivePagesCount");
        query.setParameter("phone", "%" + phone + "%");

        return ((Long)query.getSingleResult())/STRINGS_ON_PAGE;
    }
}
