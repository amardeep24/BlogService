/**
 * @since 1.0.0
 * @author Amardeep Bhowmick
 */
package com.amardeep.blog.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author AMARDEEP
 *
 */
@Entity
@Table(name="BLOG")
public class Blog implements Serializable,Comparable<Blog>,BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8057310798667303814L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_id_generator")
	@SequenceGenerator(name="blog_id_generator", sequenceName = "BLOG_ID_SEQ")
	@Column(name="BLOG_ID")
	private Long id;
	@Column(name="BLOG_TITLE")
	private String blogTitle;
	@Column(name="BLOG_TEXT")
	private String blogText;
	@Column(name="BLOG_AUTHOR")
	private Integer blogAuthor;
	@Column(name="CREATE_DATE")
	private Date blogDate;
	@Column(name="UPDATE_DATE")
	private Date blogUpdateDate;
	
	/**
	 * @return the id
	 */
	@Override
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
	/**
	 * @return the blogUpdateDate
	 */
	public Date getBlogUpdateDate() {
		return blogUpdateDate;
	}
	/**
	 * @param blogUpdateDate the blogUpdateDate to set
	 */
	public void setBlogUpdateDate(Date blogUpdateDate) {
		this.blogUpdateDate = blogUpdateDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogAuthor == null) ? 0 : blogAuthor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (!(obj instanceof Blog)) {
			return false;
		}
		Blog other = (Blog) obj;
		if (blogAuthor == null) {
			if (other.blogAuthor != null) {
				return false;
			}
		} else if (!blogAuthor.equals(other.blogAuthor)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
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
		return "Blog [id=" + id + ", blogTitle=" + blogTitle + ", blogText=" + blogText + ", blogAuthor="
				+ blogAuthor + "]";
	}
	@Override
	public int compareTo(Blog blog) {
		return this.blogDate.compareTo(blog.getBlogDate());
	}
	
	
}
