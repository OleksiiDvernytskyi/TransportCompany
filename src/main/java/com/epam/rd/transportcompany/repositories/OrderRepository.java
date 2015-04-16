/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.repositories;

import com.epam.rd.transportcompany.entities.Order;
import java.util.List;

/**
 *
 * @author amd
 */
public interface OrderRepository {
    
    public Long save(Order order);
    
    public List getActiveOrders(Integer pageNumber, String phone);
    
//    public List<Order> findByPhone(String phone);
    
    public Order findById(Long id);

    public List<Order> getArchiveOrders(Integer pageNumber, String phone);

    public List<Order> getActiveOrdersByUserID(Long userId);

//    public List<Order> findArchiveOrdersByPhone(String phone);

    public Long getActivePagesCount(String phone);
    
    public Long getArchivePagesCount(String phone);
}
