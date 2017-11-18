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
		return authorRepository.findOne(id);
	}

	@Override
	@Transactional
	public void deleteAuthor(Long id) {
		logger.info("####deleteAuthor invoked with id####",id);
		authorRepository.delete(id);
	}

	@Override
	@Transactional
	public Author updateAuthor(Author author) {
		logger.info("####updateAuthor invoked with data####",author);
		Assert.notNull(author,"Author is empty.");
		Author oldAuthor=authorRepository.findOne(author.getId());
		Assert.notNull(oldAuthor,"No author fund for given id");
		oldAuthor.setAuthorEmail(author.getAuthorEmail());
		oldAuthor.setAuthorName(author.getAuthorName());
		oldAuthor.setAuthorPhone(author.getAuthorPhone());
		oldAuthor.setUpdateDate(new Date());
		oldAuthor=authorRepository.save(oldAuthor);
		return oldAuthor;
	}

}
