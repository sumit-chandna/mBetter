package com.mbetter.service.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mbetter.core.authority.UserDataAuthorityUtils;
import com.mbetter.domain.UserData;
import com.mbetter.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService,
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserData user = userRepository.findUserByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username/password.");
		}
		return new CustomUserDetails(user);
	}

	private final class CustomUserDetails extends UserData implements
			UserDetails {
		private static final long serialVersionUID = 1L;

		public CustomUserDetails(UserData user) {
			setId(user.getId());
			setEmail(user.getEmail());
			setFirstName(user.getFirstName());
			setLastName(user.getLastName());
			setPassword(user.getPassword());
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return UserDataAuthorityUtils.createAuthorities(this);
		}

		@Override
		public String getUsername() {
			return getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
	}
}
