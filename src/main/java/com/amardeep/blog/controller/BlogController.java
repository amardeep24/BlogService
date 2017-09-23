/**
 * @since 1.0.0
 * @author Amardeep Bhowmick
 */
package com.amardeep.blog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.amardeep.blog.api.BlogApi;
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
	public ResponseEntity<List<BlogApi>> getAllBlogs(){
		logger.info("####getAllBlogs invoked####");
		List<BlogApi> blogList=blogService.getAllBlogs().stream()
								 .map(Blog::getApi)
								 .collect(Collectors.toList());
		return new ResponseEntity<>(blogList,HttpStatus.OK);
		
	}
	
	@GetMapping(value="blog/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogApi> getBlog(@PathVariable("id") Long id){
		logger.info("####getBlog invoked with id####",id);
		BlogApi blogApi=blogService.getBlog(id).getApi();
		return new ResponseEntity<>(blogApi,HttpStatus.OK);
		
	}
	
	@PostMapping(value="blog", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogApi> createBlog(@RequestBody BlogApi blogApi,UriComponentsBuilder builder){
		logger.info("####createBlog invoked with data####", blogApi);
		BlogApi createdBlog=blogService.createBlog(blogApi.getEntity()).getApi();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/blog/{id}").buildAndExpand(createdBlog.getId()).toUri());
		return new ResponseEntity<>(createdBlog,headers,HttpStatus.CREATED);
	}
	@PutMapping(value="blog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BlogApi> updateBlog(@PathVariable("id") Long id,@RequestBody BlogApi blogApi){
		logger.info("####updateBlog invoked with data####",blogApi);
		BlogApi blogUpdated=blogService.updateBlog(blogApi.getEntity()).getApi();
		return new ResponseEntity<>(blogUpdated,HttpStatus.OK);
	}
	@DeleteMapping(value="blog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public HttpStatus deleteBlog(@PathVariable("id") Long id){
		logger.info("####deleteBlog invoked with id####",id);
		blogService.deleteBlog(id);
		return HttpStatus.OK;
	}
	
}
