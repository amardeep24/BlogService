/**
 * @since 1.0.0
 * @author Amardeep Bhowmick
 */
package com.amardeep.blog.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Autowired
	BlogRepository blogRepository;
	
	@Override
	public Blog createBlog(Blog blog) {
		logger.info("####createBlog invoked with data####",blog);
		return blogRepository.save(blog);
	}

	@Override
	public Blog getBlog(Long id) {
		logger.info("####getBlog invoked with id####",id);
		return blogRepository.findOne(id);
	}

	@Override
	public Blog updateBlog(Blog blog) {
		logger.info("####updateBlog invoked with data####",blog);
		Long id=blog.getId();
		Blog oldBlog=blogRepository.findOne(id);
		oldBlog.setBlogText(blog.getBlogText());
		oldBlog.setBlogTitle(blog.getBlogTitle());
		oldBlog.setBlogUpdateDate(new Date());
		return blogRepository.save(oldBlog);
		
	}

	@Override
	public void deleteBlog(Long id) {
		logger.info("####deleteBlog invoked with id####",id);
		blogRepository.delete(id);
	}

	@Override
	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

}
