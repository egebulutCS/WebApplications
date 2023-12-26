/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gp225.persistencetables.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author gp225
 */
@Entity
public class EntityManyToMany implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idManyToMany;
    
    String string1;
    
    @ManyToMany(mappedBy="entityManyToMany")
    List<Entity1> entity1List;

    public Long getIdManyToMany() {
        return idManyToMany;
    }

    public void setIdManyToMany(Long idManyToMany) {
        this.idManyToMany = idManyToMany;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public List<Entity1> getEntity1List() {
        return entity1List;
    }

    public void setEntity1List(List<Entity1> entity1List) {
        this.entity1List = entity1List;
    }
    
    
    
}
