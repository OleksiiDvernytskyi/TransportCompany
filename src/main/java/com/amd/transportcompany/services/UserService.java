/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.services;

import com.amd.transportcompany.entities.User;
import java.util.List;

/**
 *
 * @author amd
 */
public interface UserService {
    
    public User getUserById(Long id);
    
    public List<User> getAllUsers();
    
    public Long saveUser(User user);

    public User findByName(String username);

    public List<User> getAllUsers(Integer pageNumber);

    public List<User> getActiveDrivers(Long passengers, Long carCategory);
    
    public Long getPagesCount();

}
