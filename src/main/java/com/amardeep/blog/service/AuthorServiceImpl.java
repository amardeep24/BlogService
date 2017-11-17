package com.amardeep.blog.service;

import java.util.Date;
import java.util.List;

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
	public List<Author> getAllAuthors() {
		logger.info("####getAllAuthors invoked####");
		List<Author> authorList=authorRepository.findAll();
		return authorList;
	}
	
	@Override
	@Transactional
	public Author saveAuthor(Author author) {
		logger.info("####registerAuthor invoked with data####",author);
		Assert.notNull(author,"Author is empty.");
		author.setJoinDate(new Date());
		return authorRepository.save(author);
	}

	@Override
	public Author getAuthor(Long id) {
		Author author=authorRepository.findOne(id);
		return author;
	}

}
