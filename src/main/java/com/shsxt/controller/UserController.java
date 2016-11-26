package com.shsxt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.base.BaseController;
import com.crm.base.ResultInfo;
import com.shsxt.constant.Constant;
import com.shsxt.model.User;
import com.shsxt.service.UserService;
import com.shsxt.util.LoginUserUtil;
import com.shsxt.vo.UserLoginIdentity;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@RequestMapping("find_customer_manager")
	@ResponseBody
	public List<User> findByRoleName(){
		return userService.findByRoleName();
	}
	
	/**
	 * 修改密码
	 * @param oldPassword
	 * @param newPassword
	 * @param newPassword2
	 * @return
	 */
	@RequestMapping("updatePwd")
	@ResponseBody
	public ResultInfo updatePwd(String oldPassword,String newPassword,
			String confirmPassword,HttpServletRequest req){
		ResultInfo info = new ResultInfo();
		try {
			Integer userId = LoginUserUtil.loadUserIdFromCookie(req);
			info = userService.updatePwd(oldPassword, newPassword, confirmPassword, userId);
			return info;
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultInfo(Constant.RESULT_ERROR, e.getMessage());
		}
	}
	
	@RequestMapping("list")
	public String listAll(Model model){
		List<User> users = userService.listAll();
		model.addAttribute("users", users);
		System.err.println(1111);
		return "user_list";
	}
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @param roleName
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public ResultInfo login(String userName,String password,String roleName){
		try {
			UserLoginIdentity result = userService.login(userName, password, roleName);
			return new ResultInfo(result);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultInfo(Constant.RESULT_ERROR, e.getMessage());
		}
	}
}
