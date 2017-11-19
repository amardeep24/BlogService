package com.amardeep.blog.api;

import com.amardeep.blog.domain.Blog;

public class BlogApi extends BaseApi<Blog>{
	
	public BlogApi(){
		super(Blog.class);
	}
	private Long id;
	private String blogTitle;
	private String blogText;
	private Long blogAuthor;
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
	public Long getBlogAuthor() {
		return blogAuthor;
	}
	/**
	 * @param blogAuthor the blogAuthor to set
	 */
	public void setBlogAuthor(Long blogAuthor) {
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogAuthor == null) ? 0 : this.blogAuthor.hashCode());
		result = prime * result + ((blogCreationDate == null) ? 0 : this.blogCreationDate.hashCode());
		result = prime * result + ((blogText == null) ? 0 : this.blogText.hashCode());
		result = prime * result + ((blogTitle == null) ? 0 : this.blogTitle.hashCode());
		result = prime * result + ((id == null) ? 0 : this.id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BlogApi)) {
			return false;
		}
		BlogApi other = (BlogApi) obj;
		if (blogAuthor == null) {
			if (other.blogAuthor != null) {
				return false;
			}
		} else if (!blogAuthor.equals(other.blogAuthor)) {
			return false;
		}
		if (blogCreationDate == null) {
			if (other.blogCreationDate != null) {
				return false;
			}
		} else if (!blogCreationDate.equals(other.blogCreationDate)) {
			return false;
		}
		if (blogText == null) {
			if (other.blogText != null) {
				return false;
			}
		} else if (!blogText.equals(other.blogText)) {
			return false;
		}
		if (blogTitle == null) {
			if (other.blogTitle != null) {
				return false;
			}
		} else if (!blogTitle.equals(other.blogTitle)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	
}
