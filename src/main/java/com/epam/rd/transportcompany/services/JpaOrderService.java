/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.services;

import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.entities.OrderStatus;
import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.repositories.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amd
 */
@Service("orderService")
public class JpaOrderService implements OrderService{
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    @Override
    public Long saveOrder(Order order) {
        return orderRepository.save(order);
    }
    @Transactional
    @Override
    public List<Order> getActiveOrders(Integer pageNumber){
        return getActiveOrders(pageNumber, null);
    }
    
    @Transactional
    @Override
    public List<Order> getActiveOrders(Integer pageNumber, String phone ) {
        if(phone == null) 
            phone = "";
        List<Order> orderList = orderRepository.getActiveOrders(pageNumber, phone);
        
        for(Order o: orderList){
            if(o.getDriver() != null){
                o.getDriver().getUsername();
            }
            
        }
        
       return orderList;
    }

    @Transactional
    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id);
    }
    
    @Transactional
    @Override
    public void setDriver(Order order, Long driverId) {
           
            User driver = userRepository.findById(driverId);
            order.setDriver(driver);
            order.getDriver().setReady(false);
            order.setStatus(OrderStatus.ACTIVE);
            userRepository.save(driver);
            orderRepository.save(order);
            
    }
    @Transactional
    @Override
    public void setStatus(Order order, OrderStatus orderStatus) {
       order.setStatus(orderStatus);
        saveOrder(order);
    }
    
    @Override
    public List<Order> getArchiveOrders(Integer pageNumber){
        return getArchiveOrders(pageNumber, "");
    }
    
    @Transactional
    @Override
    public List<Order> getArchiveOrders(Integer pageNumber, String phone ) {
        if(phone == null) 
            phone = "";
        List<Order> orderList = orderRepository.getArchiveOrders(pageNumber, phone );
        
        for(Order o: orderList){
            if(o.getDriver() != null){
                o.getDriver().getUsername();
            }
            
        }
        
       return orderList;
    }
    @Transactional
    @Override
    public List<Order> getActiveOrdersByUserID(Long userId) {
        return orderRepository.getActiveOrdersByUserID(userId);
    }
    
//    @Override
//    public List<Order> findArchiveOrdersByPhone(String phone) {
//          List<Order> orderList = orderRepository.findArchiveOrdersByPhone(phone);
//         
//        for(Order o: orderList){
//            if(o.getDriver() != null){
//                o.getDriver().getUsername();
//            }
//        }
//        return orderList;
//    }

    @Transactional
    @Override
    public Long getActivePagesCount(String phone) {
        if(phone == null)
            phone= "";
        return orderRepository.getActivePagesCount(phone);
    }
    
    @Transactional
    @Override
    public Long getArchivePagesCount(String phone) {
        if(phone == null)
            phone= "";
        return orderRepository.getArchivePagesCount(phone);
    }
}
