package com.grievance.Grievance.EntityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.grievance.Grievance.entity.Comment;
import com.grievance.Grievance.entity.Ticket;

public class CommentTest {
	
	  @Test
	    public void testCommentConstructorAndGetters() {
	        long commentId = 1L;
	        String content = "content";
	        Date lastUpdatedAt = new Date();
	        String memberName = "Sneha";
	        Ticket ticket = new Ticket();         
	        Comment comment = new Comment(commentId, content, lastUpdatedAt, memberName, ticket);   
	        assertEquals(commentId, comment.getCommentId());
	        assertEquals(content, comment.getContent());
	        assertEquals(lastUpdatedAt, comment.getLastUpdatedAt());
	        assertEquals(memberName, comment.getMemberName());
	        assertEquals(ticket, comment.getTicket());
	    }

	    @Test
	    public void testCommentSetters() {
	       
	        Comment comment = new Comment();
	        long commentId = 2L;
	        String content = "content";
	        Date lastUpdatedAt = new Date();
	        String memberName = "Sneha";
	        Ticket ticket = new Ticket();
	        
	        comment.setCommentId(commentId);
	        comment.setContent(content);
	        comment.setLastUpdatedAt(lastUpdatedAt);
	        comment.setMemberName(memberName);
	        comment.setTicket(ticket);

	        assertEquals(commentId, comment.getCommentId());
	        assertEquals(content, comment.getContent());
	        assertEquals(lastUpdatedAt, comment.getLastUpdatedAt());
	        assertEquals(memberName, comment.getMemberName());
	        assertEquals(ticket, comment.getTicket());
	    }
	}
	

