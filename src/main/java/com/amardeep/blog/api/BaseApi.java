package com.amardeep.blog.api;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseApi<T> {

	private Class<T> clazz;
	
	BaseApi(Class<T> clazz){
		this.clazz=clazz;
	}
	@JsonIgnore
	public T getEntity(){
		ModelMapper mapper=new ModelMapper();
		return mapper.map(this,clazz);
	}
		
}
