/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.services;

import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.entities.OrderStatus;
import com.epam.rd.transportcompany.entities.User;
import java.util.List;

/**
 *
 * @author amd
 */
public interface OrderService {
    
    public Long saveOrder(Order order);
    public List<Order> getActiveOrders(Integer pageNumber);
    public List<Order> findByPhone(String phone);
    public Order findById(Long id);

    public void setDriver(Order order, Long driverId);

    public void setStatus(Order order, OrderStatus orderStatus);

    public List<Order> getArchiveOrders(Integer pageNumber);

    public List<Order> getActiveOrdersByUserID(Long userId);
}
