/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.services;

import com.epam.rd.transportcompany.entities.Order;
import java.util.List;

/**
 *
 * @author amd
 */
public interface OrderService {
    
    public Long saveOrder(Order order);
    public List<Order> readAll();
}
