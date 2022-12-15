package com.yanti.inventorycontroll.app.login;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.yanti.inventorycontroll.domain.dto.user.User;
import com.yanti.inventorycontroll.domain.utils.AuthenticationUtils;

public class AuthenticationSuccessHandlerEx extends SavedRequestAwareAuthenticationSuccessHandler {

	@Inject
	private AuthenticationUtils authenticationUtils;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		setSession(request);
		super.onAuthenticationSuccess(request, response, authentication);
	}

	private void setSession(HttpServletRequest request) {
		User userSession = authenticationUtils.getUserSession();
		if (userSession != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userSession", userSession);
		} else {
			setDefaultTargetUrl("/login/failed");
		}
	}
}
