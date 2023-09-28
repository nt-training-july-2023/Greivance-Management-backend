package com.grievance.Grievance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grievance.Grievance.entity.Comment;

/**
 *  It provides CRUD
 * (Create, Read, Update, Delete) operations for Comment entities in the
 * database.
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
