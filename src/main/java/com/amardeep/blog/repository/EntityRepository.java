package com.amardeep.blog.repository;

public interface EntityRepository<T>{
	public T getEntity(Long id);
	
	public T createEntity(T entity);
	
	public boolean updateEntity(T entity);
	
	public boolean deleteEntity(Long id);
}
