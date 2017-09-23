package com.amardeep.blog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.amardeep.blog.domain.Author;
import com.amardeep.blog.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{

	private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	@Transactional
	public Author registerAuthor(Author author) {
		logger.info("####registerAuthor invoked with data####",author);
		Assert.notNull(author,"Author is empty.");
		return authorRepository.save(author);
	}

}
