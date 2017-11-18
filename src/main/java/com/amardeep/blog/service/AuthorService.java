package com.amardeep.blog.service;

import java.util.List;

import com.amardeep.blog.domain.Author;

public interface AuthorService {
	public Author saveAuthor(Author author);
	public List<Author> getAllAuthors();
	public Author getAuthor(Long id);
	public void deleteAuthor(Long id);
	public Author updateAuthor(Author author);
}
