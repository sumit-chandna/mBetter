package com.mbetter.core.authority;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.mbetter.domain.UserData;

/*
 * A utility class used for creating the {@link GrantedAuthority}'s given a
 * {@link UserData}. In a real solution this would be looked up in the
 * existing system, but for simplicity our original system had no notion of
 * authorities.
 *
 * @author Sumit chandna
 *
 */
public final class UserDataAuthorityUtils {
	private static final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils
			.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
	private static final List<GrantedAuthority> USER_ROLES = AuthorityUtils
			.createAuthorityList("ROLE_USER");

	public static Collection<? extends GrantedAuthority> createAuthorities(
			UserData UserData) {
		String username = UserData.getEmail();
		if (username.startsWith("admin")) {
			return ADMIN_ROLES;
		}
		return USER_ROLES;
	}

	private UserDataAuthorityUtils() {
	}
}
