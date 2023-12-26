/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eb431.servletcommentstore;

/**
 *
 * @author eb431
 */
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.Enumeration;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Date;
import java.util.Iterator;
import javax.ejb.EJB;
import java.util.List;

@WebServlet("/commentstore")
public class CommentStoreServlet extends HttpServlet {
    
    @EJB
    CommentStore store;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Received a GET HTTP Request");
        // read all headers - will set respective HTTP header
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
          String header = headers.nextElement();
          System.out.println(header + ": " + req.getHeader(header));
        }
        PrintWriter pw;
        try {
          String htmlToWrite = "<?xml version='1.0' encoding='UTF-8' ?>\n"
          + "<!DOCTYPE html>\n"
          + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
          + "<body>\n"
          + "<form method=\"post\" action=\" " + req.getRequestURI() + "\" enctype=\"application/x-www-form-urlencoded\">\n"
          + " Please enter your name:\n"
          + " <input type=\"text\" name=\"name\" title=\"Please enter your name\" />\n"
          + " <br>\n"
          + " Please enter the date of your visit:\n"
          + " <input type=\"text\" name=\"date\" title=\"Please enter the date of your visit\" />\n"
          + " <br>\n"
          + " Please enter your comment:\n"
          + " <textarea name=\"comment\" title=\"Enter your comment\"></textarea>\n"
          + " <br>\n"
          + " <input type=\"submit\" value=\"Submit Comment\" title=\"Submit your comment\" />\n"
          + " <input type=\"reset\" value=\"Reset Form\" title=\"Reset Form\" />\n"
          + "</form>\n"
          + "</body>\n"
          + "</html>";
          // set response's content type to html MIME
          resp.setContentType("text/html");
          // set response's content length - will set respective HTTP header
          resp.setContentLength(htmlToWrite.length());
          // get a PrintWriter from the HttpServletResponse object
          pw = resp.getWriter();
          // Write the html to the PrintWriter object
          pw.print(htmlToWrite);
        } catch (IOException ex) {
          Logger.getLogger(CommentStoreServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("name");
        System.out.println("submitted name: " + name);
        String date = req.getParameter("date");
        System.out.println("submitted date: " + date);
        String comment = req.getParameter("comment");
        System.out.println("submitted comment: " + comment);
        
        Date dateToStore = new Date(date);
        store.insertComment(name, comment, dateToStore);
        
        List<Comment> comments = store.getCommentList();
        //for(Comment cmnt:comments){
        Iterator iter = comments.iterator();
        while (iter.hasNext()){
            Comment cmnt = (Comment) iter.next();
            name = cmnt.getName();
            date = cmnt.getVisitDate().toString();
            comment = cmnt.getComment_str();
            PrintWriter pw;
            try {
              String htmlToWrite = "<?xml version='1.0' encoding='UTF-8' ?>\n"
              + "<!DOCTYPE html>\n"
              + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
              + "<body>\n"
              + "<table>\n"
              + " <tr>\n"
              + "  <th>Name</th>\n"
              + "  <th>Date</th>\n"
              + "  <th>Comment</th>\n"
              + " </tr>\n"
              + " <tr>\n"
              + "  <td>" + name + "</td>\n"
              + "  <td>" + date + "</td>\n"
              + "  <td>" + comment + "</td>\n"
              + " </tr>\n"
              + "</table>\n"
              + "</body>\n"
              + "</html>";
              // set response's content type to html MIME
              resp.setContentType("text/html");
              // set response's content length - will set respective HTTP header
              resp.setContentLength(htmlToWrite.length());
              // get a PrintWriter from the HttpServletResponse object
              pw = resp.getWriter();
              // Write the html to the PrintWriter object
              pw.print(htmlToWrite);
            } catch (IOException ex) {
              Logger.getLogger(CommentStoreServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
