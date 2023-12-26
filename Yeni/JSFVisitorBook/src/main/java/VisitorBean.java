
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author egebu
 */
@Named("visitorBean")
@RequestScoped
public class VisitorBean {
    String name;
    String comment_str;
    Date visitDate;
    @Inject
    CommentStore ct;

    public VisitorBean() {
    }

    public VisitorBean(String name, String comment_str, Date visitDate) {
        this.name = name;
        this.comment_str = comment_str;
        this.visitDate = visitDate;
    }

    public String getName() {
        return name;
    }

    public String getComment_str() {
        return comment_str;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment_str(String comment_str) {
        this.comment_str = comment_str;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
    
    public String mySubmit(){
        ct.insertComment(name,comment_str,visitDate);
        return "result";
    }
    
    public List<Comment> getCommentList(){
        return ct.getCommentList();
    }
}