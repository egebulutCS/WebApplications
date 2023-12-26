package com.eb431.jsfvisitorbook.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name="findAllComments", query="SELECT c FROM Comment c")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
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
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.comment_str);
        hash = 29 * hash + Objects.hashCode(this.visitDate);
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.comment_str, other.comment_str)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.visitDate, other.visitDate)) {
            return false;
        }
        return true;
    }

}
