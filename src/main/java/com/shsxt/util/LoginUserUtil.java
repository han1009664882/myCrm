package com.shsxt.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class LoginUserUtil {

	/**
	 * 从cookie中获取userId
	 * @param req
	 * @return
	 */
	public static Integer loadUserIdFromCookie(HttpServletRequest req){
		String userIdStr = CookieUtil.getCookieValue(req, "userIdStr");
		if(StringUtils.isBlank(userIdStr)){
			return null;
		}
		return UserIDBase64.decoderUserID(userIdStr);
	}
}
