/**
 * 
 */
package com.amardeep.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amardeep.blog.api.AuthorApi;
import com.amardeep.blog.domain.Author;
import com.amardeep.blog.service.AuthorService;

/**
 * @author AMARDEEP
 *
 */
@RestController
@CrossOrigin
public class AuthorController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	AuthorService authorService;

	@PostMapping(value="author", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthorApi> registerAuthor(@RequestBody AuthorApi authorApi,UriComponentsBuilder builder){
		logger.info("####createBlog invoked with data####", authorApi);
		AuthorApi authorRegistered=authorService.registerAuthor(authorApi.getEntity()).getApi();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/author/{id}").buildAndExpand(authorRegistered.getId()).toUri());
		return new ResponseEntity<>(authorRegistered,headers,HttpStatus.CREATED);
	}
}
