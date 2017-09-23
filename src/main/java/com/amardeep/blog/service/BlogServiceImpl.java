/**
 * @since 1.0.0
 * @author Amardeep Bhowmick
 */
package com.amardeep.blog.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.amardeep.blog.domain.Blog;
import com.amardeep.blog.repository.BlogRepository;

/**
 * @author AMARDEEP
 *
 */
@Service
public class BlogServiceImpl implements BlogService{

	private static final Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);
	
	@Autowired
	BlogRepository blogRepository;
	
	@Override
	@Transactional
	public Blog createBlog(Blog blog) {
		logger.info("####createBlog invoked with data####",blog);
		blog.setBlogDate(new Date());
		Assert.notNull(blog,"Blog is empty.");
		return blogRepository.save(blog);
	}

	@Override
	public Blog getBlog(Long id) {
		logger.info("####getBlog invoked with id####",id);
		Blog blog= blogRepository.findOne(id);
		Assert.notNull(blog,"No blog found for given ID.");
		return blog;
	}

	@Override
	@Transactional
	public Blog updateBlog(Blog blog) {
		logger.info("####updateBlog invoked with data####",blog);
		Assert.notNull(blog,"Blog is empty.");
		Long id=blog.getId();
		Blog oldBlog=blogRepository.findOne(id);
		Assert.notNull(blog,"No blog found for given ID.");
		oldBlog.setBlogText(blog.getBlogText());
		oldBlog.setBlogTitle(blog.getBlogTitle());
		oldBlog.setBlogUpdateDate(new Date());
		return blogRepository.save(oldBlog);
		
	}

	@Override
	@Transactional
	public void deleteBlog(Long id) {
		logger.info("####deleteBlog invoked with id####",id);
		blogRepository.delete(id);
	}

	@Override
	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

}
