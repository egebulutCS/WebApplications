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
public class Notifications implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    String requester;
    @NotNull
    int amount;
    @NotNull
    String target;

    public Notifications() {
    }

    public Notifications(String requester, int amount, String target) {
        this.requester = requester;
        this.amount = amount;
        this.target = target;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.requester);
        hash = 37 * hash + this.amount;
        hash = 37 * hash + Objects.hashCode(this.target);
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
        final Notifications other = (Notifications) obj;
        if (this.amount != other.amount) {
            return false;
        }
        if (!Objects.equals(this.requester, other.requester)) {
            return false;
        }
        if (!Objects.equals(this.target, other.target)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eb431.assignment.entity.Notifications[ id=" + id + " ]";
    }
    
}
