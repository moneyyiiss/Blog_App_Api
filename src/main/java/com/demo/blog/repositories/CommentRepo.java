package com.demo.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{
	
}
