package com.gp225.jsfvisitorbook;

import java.util.Date;

public class Comment {

    String name;
    String comment_str;
    Date visitDate;

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

}
