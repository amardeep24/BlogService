package com.amardeep.blog;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.amardeep.blog.domain.Blog;
import com.amardeep.blog.indexing.repository.BlogEsRepository;
import com.amardeep.blog.repository.BlogRepository;

@Component
public class BlogAppStartup implements ApplicationListener<ApplicationReadyEvent>  {

	private static final Logger logger = LoggerFactory.getLogger(BlogAppStartup.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	BlogEsRepository blogEsRepository;
	
	@Autowired 
	BlogRepository blogRepository;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		String[] profiles=this.environment.getActiveProfiles();
		for(String profile:profiles){
			if("uat".equalsIgnoreCase(profile.toLowerCase())){
				List<Blog> blogs=blogRepository.findAll();
				blogEsRepository.deleteAll();
				Iterable<Blog> itr=blogEsRepository.save(blogs);
				int countOfBlogs=0;
				for(Blog blog:itr){
					countOfBlogs++;
				}
				logger.info("####Indexes refresed####",countOfBlogs);
			}
		}
	}

}
