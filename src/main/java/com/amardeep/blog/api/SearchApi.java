package com.amardeep.blog.api;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @author AMARDEEP
 *
 */
public class SearchApi{
	
	private Set<BlogApi> blogApis;
	private Long hitCount;
	
	/**
	 * @return the blogApi
	 */
	public Set<BlogApi> getBlogApis() {
		return blogApis;
	}
	/**
	 * @param blogApi the blogApi to set
	 */
	public void setBlogApis(Set<BlogApi> blogApis) {
		this.blogApis = blogApis;
	}
	/**
	 * @return the hitCount
	 */
	public Long getHitCount() {
		return hitCount;
	}
	/**
	 * @param hitCount the hitCount to set
	 */
	public void setHitCount(Long hitCount) {
		this.hitCount = hitCount;
	}

}
