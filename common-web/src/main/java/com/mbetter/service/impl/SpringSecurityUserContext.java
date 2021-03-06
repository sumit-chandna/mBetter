package com.mbetter.service.impl;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.mbetter.core.authority.UserDataAuthorityUtils;
import com.mbetter.domain.UserData;
import com.mbetter.service.UserContext;

@Component
public class SpringSecurityUserContext implements UserContext {

	@Override
	public UserData getCurrentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		if (authentication == null
				|| (authentication.getPrincipal() instanceof String && "anonymousUser"
						.equalsIgnoreCase((String) authentication
								.getPrincipal()))) {
			return null;
		}
		return (UserData) authentication.getPrincipal();
	}

	@Override
	public void setCurrentUser(UserData user) {
		Collection<? extends GrantedAuthority> authorities = UserDataAuthorityUtils
				.createAuthorities(user);
		Authentication authentication = new UsernamePasswordAuthenticationToken(
				user, user.getPassword(), authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	@Override
	public String getUserDepartmentInContext() {
		UserData user = getCurrentUser();
		String department = "";
		if (user != null) {
			String email = user.getEmail();
			if (email.contains("admin")) {
				department = "admin";
			} else if (email.contains("doctor")) {
				department = "doctor";
			} else if (email.contains("reception")) {
				department = "reception";
			} else if (email.contains("lab")) {
				department = "lab";
			} else if (email.contains("pharmacy")) {
				department = "pharmacy";
			}
		}
		return department;
	}
}
