/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.services;

import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.entities.UserRole;
import com.epam.rd.transportcompany.repositories.UserRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
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
    private ShaPasswordEncoder passwordEncoder;
    
    @PostConstruct
    private void addUsers(){
        User user = new User();
        user.setUsername("root");
        user.setPassword(passwordEncoder.encodePassword("root", user.getUsername()));
        user.setUserRole(UserRole.ADMIN);
        saveUser(user);
        
        user = new User();
        user.setUsername("dis1");
        user.setPassword(passwordEncoder.encodePassword("root", user.getUsername()));
        user.setUserRole(UserRole.DISPATCHER);
        saveUser(user);
        
        user = new User();
        user.setUsername("dis2");
        user.setPassword(passwordEncoder.encodePassword("root", user.getUsername()));
        user.setUserRole(UserRole.DISPATCHER);
        saveUser(user);
        
        user = new User();
        user.setUsername("driver1");
        user.setPassword(passwordEncoder.encodePassword("root", user.getUsername()));
        user.setUserRole(UserRole.DRIVER);
        saveUser(user);
        
        user = new User();
        user.setUsername("driver2");
        user.setPassword(passwordEncoder.encodePassword("root", user.getUsername()));
        user.setUserRole(UserRole.DRIVER);
        saveUser(user);
        
        user = new User();
        user.setUsername("driver3");
        user.setPassword(passwordEncoder.encodePassword("root", user.getUsername()));
        user.setUserRole(UserRole.DRIVER);
        saveUser(user);
        
        user = new User();
        user.setUsername("driver4");
        user.setPassword(passwordEncoder.encodePassword("root", user.getUsername()));
        user.setUserRole(UserRole.DRIVER);
        saveUser(user);
        
        user = new User();
        user.setUsername("driver5");
        user.setPassword(passwordEncoder.encodePassword("root", user.getUsername()));
        user.setUserRole(UserRole.DRIVER);
        saveUser(user);
    }
    
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
    
    @Override
    public User getUserById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            u.getCar().getCarId();
        }
        
        return userList;
    }



   
}
