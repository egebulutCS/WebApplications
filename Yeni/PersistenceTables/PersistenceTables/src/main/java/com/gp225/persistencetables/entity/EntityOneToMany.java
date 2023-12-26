/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gp225.persistencetables.entity;

import java.io.Serializable;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author gp225
 */
@Entity
public class EntityOneToMany implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOneToMany;
    
    String string1;
    
    @ManyToOne(cascade = ALL)
    @JoinColumn
    Entity1 entity1;

    public Long getIdOneToMany() {
        return idOneToMany;
    }

    public void setIdOneToMany(Long idOneToMany) {
        this.idOneToMany = idOneToMany;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public Entity1 getEntity1() {
        return entity1;
    }

    public void setEntity1(Entity1 entity1) {
        this.entity1 = entity1;
    }
    
    
    
    
}
