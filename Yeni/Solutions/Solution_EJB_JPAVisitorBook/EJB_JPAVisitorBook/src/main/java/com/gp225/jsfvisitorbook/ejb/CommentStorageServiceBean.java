package com.gp225.jsfvisitorbook.ejb;

import com.gp225.jsfvisitorbook.entity.Comment;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CommentStorageServiceBean implements CommentStorageService {

    @PersistenceContext
    EntityManager em;

    public CommentStorageServiceBean() {
    }

    @Override
    public synchronized List<Comment> getCommentList() {
        List<Comment> comments = em.createNamedQuery("findAllComments").getResultList();
        return comments;
    }

    @Override
    public synchronized void insertComment(String name, String comment_str, Date visitDate) {
        Comment cmnt = new Comment(name, comment_str, visitDate);
        em.persist(cmnt);
        System.out.println("Inserted the following comment in the store:");
        System.out.println("name: " + name);
        System.out.println("date: " + visitDate);
        System.out.println("comment: " + comment_str);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("CommentStore: PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("CommentStore: PreDestroy");
    }
}
