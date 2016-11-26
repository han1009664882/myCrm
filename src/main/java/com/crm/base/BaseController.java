package com.crm.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

	@ModelAttribute
	public void preMethod(HttpServletRequest req,Model model){
		model.addAttribute("ctx", req.getContextPath());
	}
}
