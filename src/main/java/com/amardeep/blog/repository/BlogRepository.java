package com.amardeep.blog.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.amardeep.blog.domain.Blog;

//@Repository
public class BlogRepository extends AbstractEntityRepository<Blog>{

	private static final Logger logger = LoggerFactory.getLogger(BlogRepository.class);
	
	public BlogRepository() {
		super(Blog.class);
	}

}
