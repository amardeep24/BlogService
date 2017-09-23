package com.amardeep.blog.utils;

import org.modelmapper.ModelMapper;

public class BlogUtils {
	
	private static ModelMapper modelMapper=new ModelMapper();
	
	public static ModelMapper getMapper(){
		return modelMapper;
	}

}
