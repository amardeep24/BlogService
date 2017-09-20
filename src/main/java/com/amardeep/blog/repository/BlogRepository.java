/**
 * 
 */
package com.amardeep.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amardeep.blog.domain.Blog;

/**
 * @author AMARDEEP
 *
 */
public interface BlogRepository extends JpaRepository<Blog, Long>{
	Blog findByBlogTitleOrderByBlogTitleAsc(String blogTitle);
	
}
