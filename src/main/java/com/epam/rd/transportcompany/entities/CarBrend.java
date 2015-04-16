/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.rd.transportcompany.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author amd
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "CarBrend.findByName", 
            query ="SELECT b FROM CarBrend b WHERE b.brendName = :name " ),
    @NamedQuery(name = "CarBrend.readAll", 
            query = "SELECT b FROM CarBrend b ORDER BY b.brendName")
})
public class CarBrend implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long brendId;

    private String brendName;

    public Long getBrendId() {
        return brendId;
    }

    public void setBrendId(Long brendId) {
        this.brendId = brendId;
    }

    public String getBrendName() {
        return brendName;
    }

    public void setBrendName(String brendName) {
        this.brendName = brendName;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brendId != null ? brendId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarBrend)) {
            return false;
        }
        CarBrend other = (CarBrend) object;
        if ((this.brendId == null && other.brendId != null) || (this.brendId != null && !this.brendId.equals(other.brendId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epam.rd.transportcompany.entities.CarBrend[ id=" + brendId + " ]";
    }
    
}
