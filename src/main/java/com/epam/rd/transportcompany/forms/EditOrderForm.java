/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.forms;

import com.epam.rd.transportcompany.entities.Order;
import com.epam.rd.transportcompany.entities.OrderStatus;
import com.epam.rd.transportcompany.entities.User;

/**
 *
 * @author amd
 */
public class EditOrderForm {
    
    private Long orderId;
    private String phone;
    private String fromWhere;
    private String toWhere;
    private Long passengers;
    private Long cargo;
    private boolean canceled = false;   
    private OrderStatus status;
    
    private Long driverId;

    public EditOrderForm() {
    }
    
    public EditOrderForm(Order order) {
        this.orderId = order.getOrderId();
        this.phone = order.getPhone();
        this.fromWhere = order.getFromWhere();
        this.toWhere = order.getToWhere();
        this.passengers = order.getPassengers();
        this.cargo = order.getCargo();
        this.status = order.getStatus();
        
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public String getToWhere() {
        return toWhere;
    }

    public void setToWhere(String toWhere) {
        this.toWhere = toWhere;
    }

    public Long getPassengers() {
        return passengers;
    }

    public void setPassengers(Long passengers) {
        this.passengers = passengers;
    }

    public Long getCargo() {
        return cargo;
    }

    public void setCargo(Long cargo) {
        this.cargo = cargo;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
    
    
}
