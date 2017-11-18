package com.amardeep.blog.indexing.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.amardeep.blog.domain.Blog;

public interface BlogEsRepository extends ElasticsearchRepository<Blog, Long>  {
	public List<Blog> findByBlogTitleOrBlogText(String title,String text);
}
