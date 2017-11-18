package com.amardeep.blog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amardeep.blog.domain.Blog;
import com.amardeep.blog.indexing.repository.BlogEsRepository;

@Service
public class SearchServiceImpl implements SearchService{

	private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);
	
	@Autowired
	BlogEsRepository blogEsRepository;
	
	@Override
	public List<Blog> searchBlog(String keyWord) {
		logger.info("####searchBlog invoked with keyWord####",keyWord);
		return blogEsRepository.findByBlogTitleOrBlogText(keyWord,keyWord);
	}

}
