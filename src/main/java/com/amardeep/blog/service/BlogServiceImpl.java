/**
 * @since 1.0.0
 * @author Amardeep Bhowmick
 */
package com.amardeep.blog.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amardeep.blog.controller.BlogController;
import com.amardeep.blog.domain.Blog;
import com.amardeep.blog.repository.BlogRepository;

/**
 * @author AMARDEEP
 *
 */
@Service
//@Transactional
public class BlogServiceImpl implements BlogService{

	private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);
	
	/*@Autowired*/
	BlogRepository blogRepository;
	
	@Override
	public Blog createBlog(Blog blog) {
		logger.info("####createBlog invoked with data####",blog);
		return blogRepository.createEntity(blog);
	}

	@Override
	public Blog getBlog(Long id) {
		logger.info("####getBlog invoked with id####",id);
		return blogRepository.getEntity(id);
	}

	@Override
	public void updateBlog(Blog blog) {
		logger.info("####updateBlog invoked with data####",blog);
		blogRepository.updateEntity(blog);
	}

	@Override
	public void deleteBlog(Long id) {
		logger.info("####deleteBlog invoked with id####",id);
		blogRepository.deleteEntity(id);
	}

}
