package com.gp225.jsfvisitorbook.jsf;

import com.gp225.jsfvisitorbook.ejb.CommentStorageService;
import com.gp225.jsfvisitorbook.entity.Comment;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class VisitorBean {
    
    String name;
    String comment_str;
    Date visitDate;
    
    @EJB
    CommentStorageService store;
    
    public VisitorBean() {
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
    
    public String mySubmit() {
        store.insertComment(name, comment_str, visitDate);
        return "result";
    }
    
    public List<Comment> getCommentList() {
        return store.getCommentList();
    }
}
