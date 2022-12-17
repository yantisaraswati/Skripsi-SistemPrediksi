package com.yanti.inventorycontroll.app.apriori;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanti.inventorycontroll.domain.bean.apriori.AprioriCalculateServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriCalculateServiceOutputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.apriori.AprioriLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.user.User;
import com.yanti.inventorycontroll.domain.service.apriori.AprioriCalculateService;
import com.yanti.inventorycontroll.domain.service.apriori.AprioriLoadService;

@Controller
@RequestMapping("apriori")
public class AprioriController {

	@Inject
	private AprioriLoadService aprioriLoadService;
	@Inject
	private AprioriCalculateService aprioriCalculateService;
	
	@ModelAttribute
	public AprioriForm setUpForm() {
		AprioriForm form = new AprioriForm();
		return form;
	}
	
	@RequestMapping(value = "load", method = { RequestMethod.GET})
	public String load(AprioriForm form, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		AprioriLoadServiceInputBean input = new AprioriLoadServiceInputBean();
		input.setMinSupport((Integer) model.asMap().get("minSupport"));
		input.setMinConfidence((Integer) model.asMap().get("minConfidence"));
		input.setOrganizationId((Long) model.asMap().get("organizationId"));
		AprioriLoadServiceOutputBean output = aprioriLoadService.execute(input);
		model.addAttribute("message", output.getMessage() != null ? output.getMessage() : (String) model.asMap().get("message"));
		model.addAttribute("organizationList", output.getOrganizationList());
		model.addAttribute("itemSetSupportList", output.getItemSetSupportList());
		model.addAttribute("associationRuleList", output.getAssociationRuleList());
		form.setMinSupport(input.getMinSupport());
		form.setMinConfidence(input.getMinConfidence());
		form.setOrganizationId(input.getOrganizationId());
		return "apriori/apriori";
	}
	
	@RequestMapping(value = "decission", method = { RequestMethod.POST })
	public String decistion(HttpServletRequest request) {
    	if (request.getParameter("load") != null) {
            return "forward:/apriori/process-load";
        } else {
            return "forward:/apriori/process-calculate";
        }
    }
	
	@RequestMapping(value = "process-load", method = { RequestMethod.POST })
	public String processLoad(AprioriForm form, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("minSupport", form.getMinSupport());
		redirectAttributes.addFlashAttribute("minConfidence", form.getMinConfidence());
		redirectAttributes.addFlashAttribute("organizationId", form.getOrganizationId());
		return "redirect:/apriori/load";
	}
	
	@RequestMapping(value = "process-calculate", method = { RequestMethod.POST })
	public String processCalculate(AprioriForm form, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		AprioriCalculateServiceInputBean input = new AprioriCalculateServiceInputBean();
		input.setUserAccountId(((User)session.getAttribute("userSession")).getUserId());
		input.setMinSupport(form.getMinSupport());
		input.setMinConfidence(form.getMinConfidence());
		input.setOrganizationId(form.getOrganizationId());
		AprioriCalculateServiceOutputBean output = aprioriCalculateService.execute(input);
		redirectAttributes.addFlashAttribute("minSupport", form.getMinSupport());
		redirectAttributes.addFlashAttribute("minConfidence", form.getMinConfidence());
		redirectAttributes.addFlashAttribute("organizationId", form.getOrganizationId());
		if(!output.getSuccess()) {
			redirectAttributes.addFlashAttribute("message", output.getMessage());
		}
		return "redirect:/apriori/load";
	}
}
