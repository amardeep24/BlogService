/**
 * 
 */
package com.amardeep.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amardeep.blog.domain.Author;

/**
 * @author AMARDEEP
 *
 */
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
