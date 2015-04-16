/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 *
 * @author amd
 */
@Entity
@Table(name ="orders")
@NamedQueries({
    @NamedQuery(name = "Order.getActiveOrders", 
            query = "SELECT o FROM Order o WHERE o.phone LIKE :phone AND (o.status ='ACTIVE' OR o.status ='NEW') ORDER BY o.date DESC "),
//    @NamedQuery(name = "Order.getActiveOrdersByPhone", 
//            query = "SELECT o FROM Order o WHERE o.phone LIKE :phone AND ( o.status ='ACTIVE' OR o.status ='NEW') ORDER BY o.date DESC " ),
    @NamedQuery(name = "Order.getArchiveOrders",
            query = "SELECT o FROM Order o WHERE o.phone LIKE :phone AND ( o.status ='COMPLITE' OR o.status ='CANCELED') ORDER BY o.date DESC "),
    @NamedQuery(name = "Order.getActiveOrdersByUserId",
            query = "SELECT o FROM Order o WHERE (o.status ='ACTIVE' OR o.status ='NEW') AND o.driver.userId = :userId "),
//    @NamedQuery(name = "Order.getArchiveOrdersByPhone",
//            query = "SELECT o FROM Order o WHERE o.phone LIKE :phone AND ( o.status ='COMPLITE' OR o.status ='CANCELED') ORDER BY o.date DESC "),
    @NamedQuery(name = "Order.getActivePagesCount", 
            query = "SELECT COUNT(o) FROM Order o WHERE o.phone LIKE :phone AND (o.status ='ACTIVE' OR o.status ='NEW') ORDER BY o.date DESC "),
    @NamedQuery(name = "Order.getArchivePagesCount", 
            query = "SELECT COUNT(o) FROM Order o WHERE o.phone LIKE :phone AND ( o.status ='COMPLITE' OR o.status ='CANCELED') ORDER BY o.date DESC ")
})
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    
    private String phone;
    private String fromWhere;
    private String toWhere;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Long passengers;
    private Long carCategory;
    private LocalDateTime date;
    @Transient
    String dateAndTime;
    
    @ManyToOne
    @JoinColumn(name =  "userId")
    private User driver;

    public Order() {
        this.status = OrderStatus.NEW;
        //this.date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        this.date = LocalDateTime.now();
        
    }

    public String getDateAndTime() {
        if(dateAndTime == null){
            dateAndTime = date.format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm"));
        }
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Long getPassengers() {
        return passengers;
    }

    public void setPassengers(Long passengers) {
        this.passengers = passengers;
    }

    public Long getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(Long carCategory) {
        this.carCategory = carCategory;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.orderId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.orderId, other.orderId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "OrderId=" + orderId + ", fromWhere=" + fromWhere + ", toWhere=" + toWhere + ", driver=" + driver + '}';
    }

    public Long getOrderId() {
        return orderId;
    }

    
    
}
