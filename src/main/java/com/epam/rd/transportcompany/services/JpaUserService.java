/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.services;

import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.entities.UserRole;
import com.epam.rd.transportcompany.repositories.UserRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amd
 */

@Service("userService")
public class JpaUserService implements UserService, UserDetailsService{
    
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    
    
    @PostConstruct
    private void addRoot(){
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        user.setUserRole(UserRole.ADMIN);
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
        
        return userRepository.findByUsername(username);
    }
    
    @Override
    public User getUserById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  findByName(username);
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getUserRole().name()));
         
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),roles );
       
        return userDetails;
    }

    @Transactional
    @Override
    public List<User> getActiveDrivers(Long passengers, Long cargo) {
        
        List<User> userList = userRepository.getActiveDrivers(passengers, cargo);
        for(User u: userList){
            u.getCar().getCarId();
        }
        return userList;
    }



   
}
