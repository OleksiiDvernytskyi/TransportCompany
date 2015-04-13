/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.services;

import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.repositories.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author amd
 */
@Service("orderService")
public class JpaOrderService implements OrderService{
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public Long saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
