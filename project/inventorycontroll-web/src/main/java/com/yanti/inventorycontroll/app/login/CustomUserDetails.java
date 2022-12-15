package com.yanti.inventorycontroll.app.login;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yanti.inventorycontroll.domain.dto.user.AuthAccount;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final AuthAccount account;

	public CustomUserDetails(AuthAccount account) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.account.getAuthorities();
	}

	@Override
	public String getPassword() {
		return this.account.getPassword();
	}

	@Override
	public String getUsername() {
		return this.account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.account.getAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.account.getAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.account.getCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return this.isAccountNonLocked();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomUserDetails other = (CustomUserDetails) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		return true;
	}
}
