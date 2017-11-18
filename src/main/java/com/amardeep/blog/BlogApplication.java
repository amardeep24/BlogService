package com.amardeep.blog;

import org.elasticsearch.node.NodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.amardeep")
@EntityScan(basePackages = {"com.amardeep.blog.domain"})
@EnableTransactionManagement
@EnableSpringDataWebSupport
@EnableJpaRepositories(basePackages = "com.amardeep.blog.repository")
@EnableElasticsearchRepositories(basePackages = "com.amardeep.blog.indexing.repository")
public class BlogApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	@Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }
 
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
    	 NodeBuilder nodeBuilder = new NodeBuilder();
         nodeBuilder.local(true)
         			.node()
         			.client();
         
         nodeBuilder.settings()
                 	.put("http.enabled", true);
         
        return new ElasticsearchTemplate(nodeBuilder.node().client());
    }
	
	
}
