package com.demo.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.blog.payloads.ApiResponse;
import com.demo.blog.payloads.PostDto;
import com.demo.blog.payloads.PostResponse;
import com.demo.blog.services.PostService;


@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//create
	//http://localhost:9090/api/user/2/category/2/posts this is api in the postman
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId
			)
	{
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
		
	}
	
	
	// get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		List<PostDto> posts = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	// get by category
		@GetMapping("/category/{categoryId}/posts")
		public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
			List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
			return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
		}
		
		
		// get all posts
		//http://localhost:9090/api/posts?pageNumber=1&pageSize=5
		//http://localhost:9090/api/posts?pageNumber=0&pageSize=5&sortBy=postId -> this is for sortBy
		//http://localhost:9090/api/posts?pageNumber=0&pageSize=5&sortBy=title
		//http://localhost:9090/api/posts?pageNumber=0&pageSize=5&sortBy=postId&sortDir=desc
		@GetMapping("/posts")
		public ResponseEntity<PostResponse> getAllPost(
				@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
				@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
				@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
				@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
				){
			PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
			return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
		}
		
		
		// get post details by id
		
		@GetMapping("/posts/{postId}")
		public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
			PostDto postDto = this.postService.getPostById(postId);
			return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
			
		}
		
		// delete post
		@DeleteMapping("/posts/{postId}")
		public ApiResponse deletePost(@PathVariable Integer postId) {
			this.postService.deletePost(postId);
			return new ApiResponse("Post is successfully deleted !!", true);
		}
		
		// update post
		@PutMapping("/posts/{postId}")
		public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
			PostDto updatePost = this.postService.updatePost(postDto, postId);
			return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
