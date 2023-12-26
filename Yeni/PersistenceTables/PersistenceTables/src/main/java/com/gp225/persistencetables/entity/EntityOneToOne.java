/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp225.persistencetables.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author gp225
 */
@Entity
public class EntityOneToOne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOneToOne;
    
    String string1;

    @OneToOne(mappedBy = "entityOneToOne")
    Entity1 entity1;

    public Long getIdOneToOne() {
        return idOneToOne;
    }

    public void setIdOneToOne(Long idOneToOne) {
        this.idOneToOne = idOneToOne;
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
