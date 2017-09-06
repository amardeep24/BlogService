/**
 * @since 1.0.0
 * @author Amardeep Bhowmick
 */
package com.amardeep.blog.dto;

import java.io.Serializable;
import java.util.Date;

import com.amardeep.blog.domain.Author;

/**
 * @author AMARDEEP
 *
 */
public class BlogDto  implements Serializable,Comparable<BlogDto> {

	private static final long serialVersionUID = 16311247059497619L;
	/**
	 * 
	 */
	private Long blogId;
	private String blogTitle;
	private String blogText;
	private Author blogAuthor;
	private Date blogDate;
	
	/**
	 * @return the blogId
	 */
	public Long getBlogId() {
		return blogId;
	}

	/**
	 * @param blogId the blogId to set
	 */
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
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
	public Author getBlogAuthor() {
		return blogAuthor;
	}

	/**
	 * @param blogAuthor the blogAuthor to set
	 */
	public void setBlogAuthor(Author blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	/**
	 * @return the blogDate
	 */
	public Date getBlogDate() {
		return blogDate;
	}

	/**
	 * @param blogDate the blogDate to set
	 */
	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogAuthor == null) ? 0 : blogAuthor.hashCode());
		result = prime * result + ((blogDate == null) ? 0 : blogDate.hashCode());
		result = prime * result + ((blogId == null) ? 0 : blogId.hashCode());
		result = prime * result + ((blogText == null) ? 0 : blogText.hashCode());
		result = prime * result + ((blogTitle == null) ? 0 : blogTitle.hashCode());
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
		if (!(obj instanceof BlogDto)) {
			return false;
		}
		BlogDto other = (BlogDto) obj;
		if (blogAuthor == null) {
			if (other.blogAuthor != null) {
				return false;
			}
		} else if (!blogAuthor.equals(other.blogAuthor)) {
			return false;
		}
		if (blogDate == null) {
			if (other.blogDate != null) {
				return false;
			}
		} else if (!blogDate.equals(other.blogDate)) {
			return false;
		}
		if (blogId == null) {
			if (other.blogId != null) {
				return false;
			}
		} else if (!blogId.equals(other.blogId)) {
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
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BlogDto [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogText=" + blogText + ", blogAuthor="
				+ blogAuthor + ", blogDate=" + blogDate + "]";
	}

	@Override
	public int compareTo(BlogDto blog) {
		return this.blogDate.compareTo(blog.getBlogDate());
	}
	
	
	
}
