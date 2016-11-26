package com.shsxt.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.base.ResultInfo;
import com.crm.base.exception.LoginBizException;
import com.crm.base.exception.ParamException;
import com.shsxt.constant.Constant;
import com.shsxt.dao.UserDao;
import com.shsxt.model.User;
import com.shsxt.util.MD5Util;
import com.shsxt.util.UserIDBase64;
import com.shsxt.vo.LoginUserInfo;
import com.shsxt.vo.UserLoginIdentity;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 获取客户经理
	 * @return
	 */
	public List<User> findByRoleName(){
		return userDao.findByRoleName("客户经理");
	}
	
	/**
	 * 修改密码
	 * @param oldPassword
	 * @param newPassword
	 * @param newPassword2
	 * @param userId
	 * @return
	 */
	public ResultInfo updatePwd(String oldPassword, String newPassword, 
			String confirmPassword, Integer userId){
		// 基本参数校验
		checkUpdatePwd(oldPassword,newPassword,confirmPassword);
		
		// 通过用户ID获取用户信息
		User user = findUserById(userId);
		
		// 校验旧密码是否正确
		if(!MD5Util.md5Method(oldPassword).equals(user.getPassword())){
			throw new ParamException("旧密码输入错误，请重新输入");
		}
		
		if(userDao.updatePwd(userId, MD5Util.md5Method(newPassword))<1){
			throw new ParamException(Constant.OPT_FAILURE); 
		}
		return new ResultInfo(Constant.RESULT_OK,"密码修改成功");
	}
	
	/**
	 * 校验密码参数
	 * @param oldPassword  旧密码
	 * @param newPassword	新密码
	 * @param newPassword2   确认密码
	 */
	private void checkUpdatePwd(String oldPassword,
			String newPassword, String newPassword2) {
		if (StringUtils.isBlank(oldPassword)) {
			throw new ParamException("请输入旧密码");
		}
		
		if (StringUtils.isBlank(newPassword)) {
			throw new ParamException("请输入新密码");
		}
		
		if (StringUtils.isBlank(newPassword2)) {
			throw new ParamException("请输入确认密码");
		}
		
		if (!newPassword2.equals(newPassword)) {
			throw new ParamException("确认密码不一致");
		}
	}

	public List<User> listAll(){
		return userDao.listAll();
	}
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @param roleName
	 * @return
	 */
	public UserLoginIdentity login(String userName,String password,String roleName){
		
		//基本参数验证
		if(StringUtils.isBlank(userName)){
			throw new ParamException("请输入用户名");
		}
		
		if(StringUtils.isBlank(password)){
			throw new ParamException("请输入密码");
		}
		
		if(StringUtils.isBlank(password)){
			throw new ParamException("请选择用户类型");
		}
		
		password = MD5Util.md5Method(password);
		User user = userDao.findUserByUserNamePwdRole(userName, password, roleName);
		if(user==null){
			throw new ParamException("用户名或密码错误");
		}
		
		// 封装返回对象
		UserLoginIdentity userLoginIdentity = new UserLoginIdentity();
		userLoginIdentity.setUserIdStr(UserIDBase64.encoderUserID(user.getId()));
		userLoginIdentity.setUserName(userName);
		return userLoginIdentity;
	}
	
	/**
	 * 获取登录用户的信息
	 * @param userId
	 * @return
	 */
	public LoginUserInfo findLoginUser(Integer userId){
		User user = findUserById(userId);
		LoginUserInfo userInfo = new LoginUserInfo();
		userInfo.setUserName(user.getUsername());
		userInfo.setRealName(user.getTrueName());
		userInfo.setRoleName(user.getRoleName());
		return userInfo;
	}
	
	/**
	 * 通过userId获取用户信息
	 * @param userId
	 * @return
	 */
	public User findUserById(Integer userId){
		if(userId==null || userId<1){
			throw new LoginBizException(Constant.LOGIN_FIRST);
		}
		
		User user = userDao.findUserById(userId);
		if(user == null){
			throw new LoginBizException(Constant.LOGIN_FIRST);
		}
		return user;
	}
}
