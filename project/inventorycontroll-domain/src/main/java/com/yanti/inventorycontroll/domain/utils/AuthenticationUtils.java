
package com.yanti.inventorycontroll.domain.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.yanti.inventorycontroll.domain.dto.user.User;
import com.yanti.inventorycontroll.domain.model.user.MUser;
import com.yanti.inventorycontroll.domain.repository.user.MUserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationUtils {

	@Inject
	private MUserRepository userRepo;

	public User getUserSession() {
		User userSession = new User();
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();
			Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			List<String> authorityList = new ArrayList<String>();
			for (GrantedAuthority a : authorities) {
				authorityList.add(a.getAuthority());
			}

			MUser user = userRepo.findOneByUsername(username);

			userSession.setUserId(user.getUserId());
			userSession.setOrganizationId(user.getOrganizationId());
			userSession.setName(user.getName());
			userSession.setUsername(user.getUsername());
			userSession.setAuthorities(Collections.emptyList());
		} catch (Exception e) {
			log.error("EXCEPTION", e);
		}
		return userSession;
	}

	public Boolean isUserAlreadyLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || auth instanceof AnonymousAuthenticationToken) {
			return false;
		}
		return true;
	}
}
