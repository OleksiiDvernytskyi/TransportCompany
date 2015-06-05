/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.jpaservices;

import com.amd.transportcompany.entities.User;
import com.amd.transportcompany.repositories.UserRepository;
import com.amd.transportcompany.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amd
 */

@Service("userService")
public class JpaUserService implements UserService, UserDetailsService{
    
    @Autowired 
    private UserRepository userRepository;
   
    @Transactional
    @Override
    public Long saveUser(User user) {
        if ( userRepository.findByUsername(user.getUsername()) == null){
            return userRepository.save(user);
        }else{
            if(user.getUserId()!= null ){
                userRepository.merge(user);
                return user.getUserId();
            }
            return null;
        }
            
    }
    
    @Override
    public List<User> getAllUsers(Integer pageNumber) {
        return userRepository.readAll(pageNumber);
    }
        @Override
    public List<User> getAllUsers() {
        return userRepository.readAll();
    }

    @Transactional
    @Override
    public User findByName(String username) {
        User user = userRepository.findByUsername(username);
        if(user != null){
            if( user.getCar() != null){
                user.getCar().getCarId();
            }
        }
        return user; 
    }
    
    @Transactional
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  findByName(username);
         
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
       
        return userDetails;
    }

    @Transactional
    @Override
    public List<User> getActiveDrivers(Long passengers, Long carCategory) {
        
        List<User> userList = userRepository.getActiveDrivers(passengers, carCategory);
        for(User u: userList){
            u.getCar().getBrend().getBrendId();
        }
        
        return userList;
    }

    @Transactional
    @Override
    public Long getPagesCount() {
        return userRepository.getPagesCount();
    }



   
}
