package com.gp225.persistencetables.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Entity1 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id1;

    String string1;

    @ElementCollection
    List<String> listOfStrings;

    @ElementCollection
    Set<String> setOfStrings;

    @ElementCollection
    List<EmbeddableClass1> listOfEmbeddableClass;


    @ElementCollection
    Set<EmbeddableClass1> setOfEmbeddableClass;

    /**
     * **********************ASSOCIATIONS***********************
     */
    /////////////OneToOne//////////////
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    EntityOneToOne entityOneToOne;

    /////////////OneToMany//////////////
    @OneToMany(mappedBy = "entity1")
    List<EntityOneToMany> entityOneToMany;

    ///////////ManyToMany//////////////
    @ManyToMany
    @JoinTable
    List<EntityManyToMany> entityManyToMany;

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public List<String> getListOfStrings() {
        return listOfStrings;
    }

    public void setListOfStrings(List<String> listOfStrings) {
        this.listOfStrings = listOfStrings;
    }

    public Set<String> getSetOfStrings() {
        return setOfStrings;
    }

    public void setSetOfStrings(Set<String> setOfStrings) {
        this.setOfStrings = setOfStrings;
    }

    public List<EmbeddableClass1> getListOfEmbeddableClass() {
        return listOfEmbeddableClass;
    }

    public void setListOfEmbeddableClass(List<EmbeddableClass1> listOfEmbeddableClass) {
        this.listOfEmbeddableClass = listOfEmbeddableClass;
    }
    public Set<EmbeddableClass1> getSetOfEmbeddableClass() {
        return setOfEmbeddableClass;
    }

    public void setSetOfEmbeddableClass(Set<EmbeddableClass1> setOfEmbeddableClass) {
        this.setOfEmbeddableClass = setOfEmbeddableClass;
    }

    public EntityOneToOne getEntityOneToOne() {
        return entityOneToOne;
    }

    public void setEntityOneToOne(EntityOneToOne entityOneToOne) {
        this.entityOneToOne = entityOneToOne;
    }

    public List<EntityOneToMany> getEntityOneToMany() {
        return entityOneToMany;
    }

    public void setEntityOneToMany(List<EntityOneToMany> entityOneToMany) {
        this.entityOneToMany = entityOneToMany;
    }

    public List<EntityManyToMany> getEntityManyToMany() {
        return entityManyToMany;
    }

    public void setEntityManyToMany(List<EntityManyToMany> entityManyToMany) {
        this.entityManyToMany = entityManyToMany;
    }
    
    
    
}
