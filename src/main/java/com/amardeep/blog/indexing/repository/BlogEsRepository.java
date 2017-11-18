package com.amardeep.blog.indexing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.amardeep.blog.domain.Blog;

public interface BlogEsRepository extends ElasticsearchRepository<Blog, Long>  {
	public Page<Blog> findByBlogTitleOrBlogText(String keyWord,Pageable pageable);
}
