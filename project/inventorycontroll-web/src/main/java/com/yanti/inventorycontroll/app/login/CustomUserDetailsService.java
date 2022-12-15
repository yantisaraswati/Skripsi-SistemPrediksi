package com.yanti.inventorycontroll.app.login;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yanti.inventorycontroll.domain.dto.user.AuthAccount;
import com.yanti.inventorycontroll.domain.model.user.MUser;
import com.yanti.inventorycontroll.domain.repository.user.MUserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Inject
	private MUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	MUser user = userRepo.findOneByUsername(username);
    	if (user == null) {			
    		throw new UsernameNotFoundException("Username atau password tidak sesuai. Silahkan coba lagi");
		}
    	AuthAccount authAccount = new AuthAccount();
    	authAccount.setUserId(user.getUserId());
    	authAccount.setOrganizationId(user.getOrganizationId());
    	authAccount.setName(user.getName());
    	authAccount.setUsername(user.getUsername());
    	authAccount.setPassword(user.getPassword());
    	authAccount.setAuthorities(getAuthorities(Collections.emptyList()));
    	authAccount.setAccountNonExpired(true);
    	authAccount.setAccountNonLocked(true);
    	authAccount.setCredentialsNonExpired(true);
		return new CustomUserDetails(authAccount);
	}
	
	private List<GrantedAuthority> getAuthorities(List<String> permissions) {
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
		for (String per : permissions) {
			result.add(new SimpleGrantedAuthority(per));
		}
		return result;
	}
}
