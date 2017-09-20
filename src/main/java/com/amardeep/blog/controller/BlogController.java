/**
 * @since 1.0.0
 * @author Amardeep Bhowmick
 */
package com.amardeep.blog.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amardeep.blog.domain.Blog;
import com.amardeep.blog.service.BlogService;

/**
 * @author AMARDEEP
 *
 */
@CrossOrigin
@RestController
public class BlogController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	BlogService blogService;
	
	@GetMapping(value="blog",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Blog>> getAllBlogs(){
		logger.info("####getAllBlogs invoked####");
		List<Blog> blogList=blogService.getAllBlogs();
		return new ResponseEntity<>(blogList,HttpStatus.OK);
		
	}
	
	@GetMapping(value="blog/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> getBlog(@PathVariable("id") Long id){
		logger.info("####getBlog invoked with id####",id);
		Blog blog=blogService.getBlog(id);
		return new ResponseEntity<>(blog,HttpStatus.OK);
		
	}
	
	@PostMapping(value="blog", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
		logger.info("####createBlog invoked with data####", blog);
		blog.setBlogDate(new Date());
		return new ResponseEntity<>(blogService.createBlog(blog),HttpStatus.CREATED);
	}
	@PutMapping(value="blog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> updateBlog(@PathVariable("id") Long id,@RequestBody Blog blog){
		logger.info("####updateBlog invoked with data####",blog);
		Blog blogUpdated=blogService.updateBlog(blog);
		return new ResponseEntity<>(blogUpdated,HttpStatus.OK);
	}
	@DeleteMapping(value="blog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public HttpStatus deleteBlog(@PathVariable("id") Long id){
		logger.info("####deleteBlog invoked with id####"+id);
		blogService.deleteBlog(id);
		return HttpStatus.OK;
	}
}
