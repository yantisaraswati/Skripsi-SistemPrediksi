package com.yanti.inventorycontroll.app.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class AuthenticationFailureHandlerEx extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		loginFailed(exception);
		super.onAuthenticationFailure(request, response, exception);
	}

	private void loginFailed(AuthenticationException exception) {
		if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
			setDefaultFailureUrl("/login/failed?message=Username atau password tidak sesuai. Silahkan coba lagi");
		}
	}

}
