package com.amardeep.blog.controller;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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

import com.amardeep.blog.api.BlogApi;
import com.amardeep.blog.api.SearchApi;
import com.amardeep.blog.domain.Blog;
import com.amardeep.blog.service.SearchService;

@RestController
@CrossOrigin
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	SearchService searchService;
	
	@GetMapping(value="search", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SearchApi> searchBlog(@RequestParam(value="keyword") String keyword,Pageable pageable){
		logger.info("####searchBlog invoked with keyWord####",keyword);
		List<Blog> blogs=searchService.searchBlog(keyword);
		Set<BlogApi> blogApis=blogs.stream()
									.filter(Objects::nonNull)
									.map(Blog::getApi)
									.collect(Collectors.toSet());
		SearchApi searchResults=new SearchApi();
		searchResults.setBlogApis(blogApis);
		searchResults.setHitCount(new Long(blogApis.size()));
		return new ResponseEntity<>(searchResults,HttpStatus.OK);
		
	}
	
}
