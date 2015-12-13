package com.mbetter.service;

import com.mbetter.domain.UserData;

/**
 * Manages the current {@link UserData}. This demonstrates how in larger
 * applications it is good to abstract out accessing the current user to return
 * the application specific user rather than interacting with Spring Security
 * classes directly.
 *
 * @author Sumit Chandna
 *
 */
public interface UserContext {

	/**
	 * Gets the currently logged in {@link UserData} or null if there is no
	 * authenticated user.
	 *
	 * @return
	 */
	UserData getCurrentUser();

	/**
	 * Sets the currently logged in {@link UserData}.
	 * 
	 * @param user
	 *            the logged in {@link UserData}. Cannot be null.
	 * @throws IllegalArgumentException
	 *             if the {@link UserData} is null.
	 */
	void setCurrentUser(UserData user);

	String getUserDepartmentInContext();
}
