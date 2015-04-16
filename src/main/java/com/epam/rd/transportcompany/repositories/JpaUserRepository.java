/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.repositories;

import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.entities.UserRole;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amd
 */
@Repository("userRepository")
public class JpaUserRepository implements UserRepository{
     
    static final Integer STRINGS_ON_PAGE = 5;
    static final Integer MAX_NUMBER_RESULTS = 10;
    
    @PersistenceContext(name = "MySql")
    private EntityManager em;
    
    @Transactional
    @Override
    public Long save(User user) {
        em.persist(user);
        return user.getUserId();
    }

    @Override
    public List<User> readAll() {
        Query query = em.createQuery("SELECT u FROM User u ORDER BY u.username");
        
        return query.getResultList();
    }
    
    @Override
    public List<User> readAll(Integer pageNumber) {
        Query query = em.createQuery("SELECT u FROM User u ORDER BY u.username" );
        query.setFirstResult((pageNumber * STRINGS_ON_PAGE));
        query.setMaxResults(STRINGS_ON_PAGE);
       // query.setParameter("start", );
        //uery.setParameter("end", );
        
        return query.getResultList();
    }
    
    @Override
    public User findByUsername(String username) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username ");
        query.setParameter("username", username );
        List<User> userList = query.getResultList();
        
        if(userList == null || userList.isEmpty()){
            return null;
        }
        return userList.get(0);
    }

    @Override
    public void merge(User user) {
        em.merge(user);
    }

    @Override
    public List<User> getActiveDrivers(Long passengers, Long carCategory) {
        if(passengers == null ){
            passengers = 0L;
        }
        if(carCategory == null){
            carCategory = 0L;
        }
        
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userRole = 'DRIVER' "
                + "AND u.ready = TRUE AND u.car != NULL AND u.car.carCategory >= :carCategory "
                + "AND u.car.passengers >= :passengers  ");
        query.setParameter("carCategory", carCategory);
        query.setParameter("passengers", passengers);
        query.setMaxResults(MAX_NUMBER_RESULTS);
        
        return query.getResultList();
    }

    @Override
    public User findById(Long userId) {
        return em.find(User.class, userId);
    }

   
    
}
