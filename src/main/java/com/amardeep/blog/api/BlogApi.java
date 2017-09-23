package com.amardeep.blog.api;

import com.amardeep.blog.domain.Blog;

public class BlogApi extends BaseApi<Blog>{
	
	public BlogApi(){
		super(Blog.class);
	}
	private Long id;
	private String blogTitle;
	private String blogText;
	private Integer blogAuthor;
	private String blogCreationDate;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the blogTitle
	 */
	public String getBlogTitle() {
		return blogTitle;
	}
	/**
	 * @param blogTitle the blogTitle to set
	 */
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	/**
	 * @return the blogText
	 */
	public String getBlogText() {
		return blogText;
	}
	/**
	 * @param blogText the blogText to set
	 */
	public void setBlogText(String blogText) {
		this.blogText = blogText;
	}
	/**
	 * @return the blogAuthor
	 */
	public Integer getBlogAuthor() {
		return blogAuthor;
	}
	/**
	 * @param blogAuthor the blogAuthor to set
	 */
	public void setBlogAuthor(Integer blogAuthor) {
		this.blogAuthor = blogAuthor;
	}
	/**
	 * @return the blogCreationDate
	 */
	public String getBlogCreationDate() {
		return blogCreationDate;
	}
	/**
	 * @param blogCreationDate the blogCreationDate to set
	 */
	public void setBlogCreationDate(String blogCreationDate) {
		this.blogCreationDate = blogCreationDate;
	}
	
	
}
