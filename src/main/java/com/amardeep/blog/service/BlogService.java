/**
 * @since 1.0.0
 * @author Amardeep Bhowmick
 */
package com.amardeep.blog.service;

import java.util.List;

import com.amardeep.blog.domain.Blog;

/**
 * @author AMARDEEP
 *
 */
public interface BlogService {
	
	public Blog createBlog(Blog blog);
	public Blog getBlog(Long id);
	public List<Blog> getAllBlogs();
	public Blog updateBlog(Blog blog);
	public void deleteBlog(Long id);

}
