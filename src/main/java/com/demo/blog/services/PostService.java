package com.demo.blog.services;

import java.util.List;

import com.demo.blog.entities.Post;
import com.demo.blog.payloads.PostDto;

public interface PostService {
	//create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	
	Post updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all posts
	
	List<Post> getAllPost();
	
	//get single post
	
	Post getPostById(Integer postId);
	
	//get all posts by category
	
	List<Post> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<Post> getPostsByUser(Integer userId);
	
	//search posts
	List<Post> searchPosts(String keyword);
}
