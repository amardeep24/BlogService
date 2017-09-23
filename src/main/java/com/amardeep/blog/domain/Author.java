/**
 * @since 1.0.0
 * @author Amardeep Bhowmick
 */
package com.amardeep.blog.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.amardeep.blog.api.AuthorApi;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author AMARDEEP
 *
 */
@Entity
@Table(name="AUTHOR")
public class Author implements Serializable,Comparable<Author>,BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -805125615284300488L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_generator")
	@SequenceGenerator(name="author_id_generator", sequenceName = "AUTHOR_ID_SEQ")
	@Column(name="AUTHOR_ID")
	private Long id;
	@Column(name="AUTHOR_NAME")
	private String authorName;
	@Column(name="AUTHOR_EMAIL")
	private String authorEmail;
	@Column(name="AUTHOR_PHONE")
	private String authorPhone;
	@Column(name="HASHED_PASSWORD")
	private String hashedPassword;
	@Column(name="CREATE_DATE")
	private LocalDateTime joinDate;
	@Column(name="UPDATE_DATE")
	private LocalDateTime updateDate;
	
	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getAuthorPhone() {
		return authorPhone;
	}
	public void setAuthorPhone(String authorPhone) {
		this.authorPhone = authorPhone;
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
	/**
	 * @return the joinDate
	 */
	public LocalDateTime getJoinDate() {
		return joinDate;
	}
	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	/**
	 * @return the updateDate
	 */
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorEmail == null) ? 0 : authorEmail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((authorPhone == null) ? 0 : authorPhone.hashCode());
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
		if (!(obj instanceof Author)) {
			return false;
		}
		Author other = (Author) obj;
		if (authorEmail == null) {
			if (other.authorEmail != null) {
				return false;
			}
		} else if (!authorEmail.equals(other.authorEmail)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
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
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Author [id=" + id + ", authorName=" + authorName + ", authorEmail=" + authorEmail
				+ ", authorPhone=" + authorPhone + "]";
	}
	@Override
	public int compareTo(Author author) {
		return this.authorName.compareTo(author.getAuthorName());
	}
	
	@JsonIgnore
	public AuthorApi getApi(){
		DateFormat formatter=new SimpleDateFormat("d MMM yyyy");
		AuthorApi authorApi=new AuthorApi();
		authorApi.setAuthorEmail(this.authorEmail);
		authorApi.setAuthorName(this.authorName);
		authorApi.setAuthorPhone(this.authorPhone);
		return authorApi;
	}
}
