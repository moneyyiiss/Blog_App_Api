package com.demo.blog.services;

import com.demo.blog.payloads.CommentDto;

public interface CommentService {
	
	// this is for create comment
	CommentDto createComment(CommentDto commentDto, Integer postId);
	// this is for delete
	void deleteComment(Integer commentId);
}
