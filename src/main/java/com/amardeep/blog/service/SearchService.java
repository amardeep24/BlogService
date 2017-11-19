package com.amardeep.blog.service;

import java.util.List;

import com.amardeep.blog.domain.Blog;

public interface SearchService {

	public List<Blog> searchBlog(String keyword);
}
