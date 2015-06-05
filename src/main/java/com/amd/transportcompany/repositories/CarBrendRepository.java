/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amd.transportcompany.repositories;

import com.amd.transportcompany.entities.CarBrend;
import java.util.List;

/**
 *
 * @author amd
 */
public interface CarBrendRepository {

    public CarBrend findByName(String name);

    public Long save(CarBrend carBrend);

    public List<CarBrend> readAll();

    public CarBrend findById(Long brendId);
    
}
