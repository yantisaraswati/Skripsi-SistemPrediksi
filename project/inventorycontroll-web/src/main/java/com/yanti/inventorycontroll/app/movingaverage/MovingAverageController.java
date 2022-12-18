package com.yanti.inventorycontroll.app.movingaverage;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageCalculateServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageCalculateServiceOutputBean;
import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageLoadServiceInputBean;
import com.yanti.inventorycontroll.domain.bean.movingaverage.MovingAverageLoadServiceOutputBean;
import com.yanti.inventorycontroll.domain.dto.user.User;
import com.yanti.inventorycontroll.domain.service.movingaverage.MovingAverageCalculateService;
import com.yanti.inventorycontroll.domain.service.movingaverage.MovingAverageLoadService;

@Controller
@RequestMapping("movingaverage")
public class MovingAverageController {

	@Inject
	private MovingAverageLoadService movingAverageLoadService;
	@Inject
	private MovingAverageCalculateService movingAverageCalculateService;
	
	@ModelAttribute
	public MovingAverageForm setUpForm() {
		MovingAverageForm form = new MovingAverageForm();
		return form;
	}
	
	@RequestMapping(value = "load", method = { RequestMethod.GET})
	public String load(MovingAverageForm form, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		MovingAverageLoadServiceInputBean input = new MovingAverageLoadServiceInputBean();
		input.setTimeFrame((Integer) model.asMap().get("timeFrame"));
		input.setPredictedMonth((Integer) model.asMap().get("predictedMonth"));
		input.setOrganizationId((Long) model.asMap().get("organizationId"));
		MovingAverageLoadServiceOutputBean output = movingAverageLoadService.execute(input);
		model.addAttribute("message", (String) model.asMap().get("message") != null ? (String) model.asMap().get("message") : output.getMessage());
		model.addAttribute("organizationList", output.getOrganizationList());
		model.addAttribute("movingAverageList", output.getMovingAverageList());
		form.setLastPeriod(output.getLastPeriod());
		form.setTimeFrame(input.getTimeFrame());
		form.setPredictedMonth(input.getPredictedMonth());
		form.setOrganizationId(input.getOrganizationId());
		return "movingaverage/movingaverage";
	}
	
	@RequestMapping(value = "decission", method = { RequestMethod.POST })
	public String decistion(HttpServletRequest request) {
    	if (request.getParameter("load") != null) {
            return "forward:/movingaverage/process-load";
        } else {
            return "forward:/movingaverage/process-calculate";
        }
    }
	
	@RequestMapping(value = "process-load", method = { RequestMethod.POST })
	public String processLoad(MovingAverageForm form, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("timeFrame", form.getTimeFrame());
		redirectAttributes.addFlashAttribute("predictedMonth", form.getPredictedMonth());
		redirectAttributes.addFlashAttribute("organizationId", form.getOrganizationId());
		return "redirect:/movingaverage/load";
	}
	
	@RequestMapping(value = "process-calculate", method = { RequestMethod.POST })
	public String processCalculate(MovingAverageForm form, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		MovingAverageCalculateServiceInputBean input = new MovingAverageCalculateServiceInputBean();
		input.setUserAccountId(((User)session.getAttribute("userSession")).getUserId());
		input.setTimeFrame(form.getTimeFrame());
		input.setPredictedMonth(form.getPredictedMonth());
		input.setOrganizationId(form.getOrganizationId());
		MovingAverageCalculateServiceOutputBean output = movingAverageCalculateService.execute(input);
		redirectAttributes.addFlashAttribute("timeFrame", form.getTimeFrame());
		redirectAttributes.addFlashAttribute("predictedMonth", form.getPredictedMonth());
		redirectAttributes.addFlashAttribute("organizationId", form.getOrganizationId());
		if(!output.getSuccess()) {
			redirectAttributes.addFlashAttribute("message", output.getMessage());
		}
		return "redirect:/movingaverage/load";
	}
}
