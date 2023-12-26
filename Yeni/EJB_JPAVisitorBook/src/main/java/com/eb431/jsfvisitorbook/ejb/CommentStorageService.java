/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eb431.jsfvisitorbook.ejb;

import com.eb431.jsfvisitorbook.entity.Comment;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author egebu
 */
@Local
public interface CommentStorageService {
    public List<Comment> getCommentList();
    
    public void insertComment(String name, String comment_str, Date visitDate);
}
