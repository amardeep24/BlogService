package com.amardeep.blog.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amardeep.blog.domain.Blog;
import com.amardeep.blog.service.SearchService;

@RestController
@CrossOrigin
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	SearchService searchService;
	
	@GetMapping(value="search", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Blog>> searchBlog(@RequestParam(value="keyWord") String keyWord,Pageable pageable){
		logger.info("####searchBlog invoked with keyWord####",keyWord);
		List<Blog> blogs=searchService.searchBlog(keyWord);
		return new ResponseEntity<>(blogs,HttpStatus.OK);
		
	}
	
}
