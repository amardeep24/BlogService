/**
 * 
 */
package com.amardeep.blog.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.amardeep.blog.domain.Author;

/**
 * @author AMARDEEP
 *
 */
public class AuthorApi extends BaseApi<Author>{
	
	
	private Long id;
	private String authorName;
	private String authorEmail;
	private String authorPhone;
	private String joiningDate;
	private String hashedPassword;
	
	public AuthorApi(){
		super(Author.class);
	}
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
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	/**
	 * @return the authorEmail
	 */
	public String getAuthorEmail() {
		return authorEmail;
	}
	/**
	 * @param authorEmail the authorEmail to set
	 */
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	/**
	 * @return the authorPhone
	 */
	public String getAuthorPhone() {
		return authorPhone;
	}
	/**
	 * @param authorPhone the authorPhone to set
	 */
	public void setAuthorPhone(String authorPhone) {
		this.authorPhone = authorPhone;
	}
	/**
	 * @return the joiningDate
	 */
	public String getJoiningDate() {
		return joiningDate;
	}
	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	/**
	 * @return the hashedPassword
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}
	/**
	 * @param hashedPassword the hashedPassword to set
	 */
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorEmail == null) ? 0 : authorEmail.hashCode());
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((authorPhone == null) ? 0 : authorPhone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (!(obj instanceof AuthorApi)) {
			return false;
		}
		AuthorApi other = (AuthorApi) obj;
		if (authorEmail == null) {
			if (other.authorEmail != null) {
				return false;
			}
		} else if (!authorEmail.equals(other.authorEmail)) {
			return false;
		}
		if (authorName == null) {
			if (other.authorName != null) {
				return false;
			}
		} else if (!authorName.equals(other.authorName)) {
			return false;
		}
		if (authorPhone == null) {
			if (other.authorPhone != null) {
				return false;
			}
		} else if (!authorPhone.equals(other.authorPhone)) {
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthorApi [id=" + id + ", authorName=" + authorName + ", authorEmail=" + authorEmail + ", authorPhone="
				+ authorPhone + "]";
	}
	
}
