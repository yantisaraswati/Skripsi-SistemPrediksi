package com.yanti.inventorycontroll.app.login;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.yanti.inventorycontroll.domain.dto.user.User;
import com.yanti.inventorycontroll.domain.utils.AuthenticationUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("login")
public class LoginController {

	@Inject
	private AuthenticationUtils authenticationUtils;

	@ModelAttribute
	public LoginForm setUpForm() {
		LoginForm form = new LoginForm();
		return form;
	}

	@RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
	public String login() {
		Boolean isUserAlreadyLogin = authenticationUtils.isUserAlreadyLogin();
		if (isUserAlreadyLogin) {
			return "redirect:/";
		}
		return "login/login";
	}

	@RequestMapping(value = "authchecking")
	public String authchecking(LoginForm form, Model model) {
		try {
			return "forward:/login/success";
		} catch (Exception e) {
			model.addAttribute(ResultMessages.error().add(ResultMessage.fromText(e.getMessage())));
			return "forward:/login/failed";
		}
	}

	@RequestMapping(value = "success")
    public String loginSuccessProcessService(LoginForm form, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        User user = authenticationUtils.getUserSession();
        if (user != null) {
        	session.setAttribute("userSession", user);
        	return "redirect:/";
		}
    	return "redirect:/login/failed";
    }
	
	@RequestMapping(value = "failed")
	public String failed(@RequestParam("message") String message, LoginForm form, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("userMessage", message);
		return "redirect:/login";
	}
}
