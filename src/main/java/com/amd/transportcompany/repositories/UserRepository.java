/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.repositories;

import com.amd.transportcompany.entities.User;
import java.util.List;

/**
 *
 * @author amd
 */
public interface UserRepository {
  
    public Long save(User user);
   
    public List<User> readAll();
  
    public User findByUsername(String username);

    public void merge(User user);

    public List<User> readAll(Integer pageNumber);

    public List<User> getActiveDrivers(Long passengers, Long carCategory);

    public User findById(Long userId);

    public Long getPagesCount();
}
