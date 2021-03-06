/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Column;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author amd
 */
@Entity
@Table(name ="users")
@NamedQueries({
    @NamedQuery(name = "User.readAll",
            query = "SELECT u FROM User u ORDER BY u.username"),
    @NamedQuery(name = "User.findByUsername",
            query = "SELECT u FROM User u WHERE u.username = :username "),
    @NamedQuery(name = "User.getActiveDrivers", 
            query = "SELECT u FROM User u WHERE u.userRole = 'DRIVER'"
                + "AND u.ready = TRUE AND u.car != NULL AND u.car.carCategory >= :carCategory "
                + "AND u.car.passengers >= :passengers "),
    @NamedQuery(name = "User.getPagesCount",
            query = "SELECT COUNT(u) FROM User u")
})
public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private boolean ready = false;
    private boolean disabled = false;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    
    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    public User(){
        
    }
    
    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }


    public UserRole getUserRole() {
        return userRole;
    }
    
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + userId + ", username=" + username + ", name=" + firstname + ", lastname=" + lastname + '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        HashSet<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(("ROLE_"+getUserRole()));
        authorities.add(grantedAuthority);
        
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled() ;
    }

   
    
}
