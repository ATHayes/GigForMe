/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.DAO;

import com.gigForMe.model.Comment;
import java.util.ArrayList;

/**
 *
 * @author anthonyhayes
 */
public interface CommentDAO {
   public ArrayList<Comment> getAllComments();
   public Comment getComment(int commentID);
   public void insertComment(Comment comment);
   public void updateComment(Comment comment);
   public void deleteComment(int commentID);

   public int countRecords();
}
