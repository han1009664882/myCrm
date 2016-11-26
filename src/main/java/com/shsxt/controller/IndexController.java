package com.shsxt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm.base.BaseController;
import com.shsxt.service.UserService;
import com.shsxt.util.LoginUserUtil;
import com.shsxt.vo.LoginUserInfo;

@Controller
@RequestMapping("")
public class IndexController extends BaseController{

	@Autowired
	UserService userService;
	
	@RequestMapping("index")
	public String index(){
		System.err.println(11);
		return "index";
	}
	
	@RequestMapping("main")
	public String main(Model model,HttpServletRequest req){
		Integer userId = LoginUserUtil.loadUserIdFromCookie(req);
		LoginUserInfo userInfo = userService.findLoginUser(userId);
		model.addAttribute("currentUser", userInfo);
		return "main";
	}
	
}
