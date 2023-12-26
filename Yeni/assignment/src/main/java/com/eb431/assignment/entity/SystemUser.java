package com.eb431.assignment.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eb431
 */
@Entity
public class SystemUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    String username;
    @NotNull
    String userpassword;
    @NotNull
    String currency;
    @NotNull
    double balance;

    public SystemUser() {
    }

    public SystemUser(String username, String userpassword, String currency, double balance) {
        this.username = username;
        this.userpassword = userpassword;
        this.currency = currency;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.username);
        hash = 43 * hash + Objects.hashCode(this.userpassword);
        hash = 43 * hash + Objects.hashCode(this.currency);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.balance) ^ (Double.doubleToLongBits(this.balance) >>> 32));
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
        final SystemUser other = (SystemUser) obj;
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.userpassword, other.userpassword)) {
            return false;
        }
        if (!Objects.equals(this.currency, other.currency)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eb431.assignment.entity.SystemUser[ id=" + id + " ]";
    }
    
}
