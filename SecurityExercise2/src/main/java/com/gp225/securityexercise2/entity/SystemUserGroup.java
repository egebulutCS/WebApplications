/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp225.securityexercise2.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author egebu
 */
@Entity
public class SystemUserGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String username;
    String groupname;

    public SystemUserGroup() {
    }

    public SystemUserGroup(String username, String users) {
        this.username = username;
        this.groupname = users;
    }

    public String getUsername() {
        return username;
    }

    public String getGroupname() {
        return groupname;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.groupname);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SystemUserGroup other = (SystemUserGroup) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.groupname, other.groupname)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gp225.securityexercise2.entity.SystemUserGroup[ id=" + id + " ]";
    }
    
}
