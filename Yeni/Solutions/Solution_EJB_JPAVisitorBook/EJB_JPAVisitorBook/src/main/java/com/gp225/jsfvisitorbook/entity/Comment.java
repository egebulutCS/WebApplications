package com.gp225.jsfvisitorbook.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@NamedQuery(name="findAllComments", query="SELECT c FROM Comment c ")

@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    String name;

    @NotNull
    String comment_str;

    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    Date visitDate;

    public Comment() {
    }

    public Comment(String name, String comment_str, Date visitDate) {
        this.name = name;
        this.comment_str = comment_str;
        this.visitDate = visitDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment_str() {
        return comment_str;
    }

    public void setComment_str(String comment_str) {
        this.comment_str = comment_str;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.comment_str);
        hash = 71 * hash + Objects.hashCode(this.visitDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.comment_str, other.comment_str)) {
            return false;
        }
        return Objects.equals(this.visitDate, other.visitDate);
    }

}
