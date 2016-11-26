package com.shsxt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crm.base.ResultInfo;
import com.crm.base.exception.ParamException;

@RestControllerAdvice
public class ParamExceptionHandlder {

	private static Logger logger = 
			LoggerFactory.getLogger(ParamException.class);
	
	@ExceptionHandler(value = ParamException.class)
	public ResultInfo exceptionHandler(ParamException exception){
		ResultInfo info = new ResultInfo();
		Integer errorCode = exception.getErrorCode();
		String message = exception.getMessage();
		info.setResultCode(errorCode);
		info.setResult(message);
		logger.error("参数异常：{}", exception); // 打印异常
		return info;
	}
}
