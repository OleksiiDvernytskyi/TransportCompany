/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.services;

import com.epam.rd.transportcompany.entities.CarBrend;
import java.util.List;

/**
 *
 * @author amd
 */
public interface CarBrendService {

    public CarBrend findByName(String name);

    public Long save(CarBrend carBrend);

    public List<CarBrend> readAll();

    public CarBrend findById(Long brendId);
    
}
