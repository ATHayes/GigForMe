/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.model;

/**
 *
 * @author anthonyhayes
 */
public class CommentBox implements Comparable<CommentBox>{
    private Person person;
    private Comment comment;

    public CommentBox(Person person, Comment comment) {
        this.person = person;
        this.comment = comment;
    }

    public CommentBox() {

    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the comment
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(Comment comment) {
        this.comment = comment;
    }
    
     //compare method for sort - http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
    public int compareTo(CommentBox compareCommentBox) {
		int compareCommentID = ((CommentBox) compareCommentBox).getComment().getCommentID(); 
		//descending order
		return compareCommentID - this.comment.getCommentID();
	}	
}
