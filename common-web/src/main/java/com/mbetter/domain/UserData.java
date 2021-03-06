package com.mbetter.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * {@link UserData} is this applications notion of a user. It is good to use
 * your own objects to interact with a user especially in large applications.
 * This ensures that as you evolve your security requirements (update Spring
 * Security, leverage new Spring Security modules, or even swap out security
 * implementations) you can do so easily.
 * 
 * @author Sumit Chandna
 * 
 */
@Entity
@Table(name = "USER_DATA")
@NamedQueries(value = {
		@NamedQuery(name = "UserData.getUser", query = "select c from UserData c where c.id=:id "),
		@NamedQuery(name = "UserData.findUserByEmail", query = "select c from UserData c where c.email = :email "),
		@NamedQuery(name = "UserData.findUsersByEmail", query = "select c from UserData c where c.email LIKE :email ") })
public class UserData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8433999509932007961L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * Gets the email address for this user. When authenticating against this
	 * data directly, this is also used as the username.
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the first name of the user.
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the id for this user. When creating a new user this should be null,
	 * otherwise it will be non-null.
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the last name of the user.
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the password for this user. In some instances, this password is not
	 * actually used. For example, when an in memory authentication is used the
	 * password on the spring security User object is used.
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	// --- convenience methods ---

	/**
	 * Gets the full name in a formatted fashion. Note in a real application a
	 * formatter may be more appropriate, but in this application simplicity is
	 * more important.
	 * 
	 * @return
	 */
	public String getName() {
		return getLastName() + ", " + getFirstName();
	}

	// --- override Object ---

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final UserData other = (UserData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}