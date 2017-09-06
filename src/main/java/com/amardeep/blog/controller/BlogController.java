/**
 * @since 1.0.0
 * @author Amardeep Bhowmick
 */
package com.amardeep.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amardeep.blog.dto.BlogDto;
import com.amardeep.blog.service.BlogService;

/**
 * @author AMARDEEP
 *
 */
@RestController
public class BlogController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	BlogService blogService;
	
	@GetMapping(value="blog/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogDto> getBlog(@PathVariable("id") Long id){
		logger.info("####getBlog invoked with id####",id);
		BlogDto blogDummy=new BlogDto();
		blogDummy.setBlogId(1000L);
		blogDummy.setBlogText("Hello World");
		blogDummy.setBlogText("Foo Bar");
		return new ResponseEntity<>(blogDummy,HttpStatus.OK);
		
	}
	@PostMapping(value="blog/", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public BlogDto createBlog(BlogDto blog){
		logger.info("####createBlog invoked with data####", blog);
		BlogDto blogDummy=new BlogDto();
		blogDummy.setBlogId(1000L);
		blogDummy.setBlogText("Hello World");
		blogDummy.setBlogText("Foo Bar");
		return blogDummy;
	}
	@PutMapping(value="blog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogDto> updateBlog(@PathVariable("id") Long id,@RequestBody BlogDto blog){
		logger.info("####updateBlog invoked with data####",blog);
		BlogDto blogDummy=new BlogDto();
		blogDummy.setBlogId(1000L);
		blogDummy.setBlogText("Hello World");
		blogDummy.setBlogText("Foo Bar");
		return new ResponseEntity<>(blogDummy,HttpStatus.OK);
	}
	@DeleteMapping(value="blog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogDto> deleteBlog(@PathVariable("id") Long id){
		logger.info("####deleteBlog invoked with id####"+id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
