package com.shsxt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.service.CusDevPlanService;

@Controller
@RequestMapping("cus_dev_plan")
public class CusDevPlanController {

	@Autowired
	private CusDevPlanService cusDevPlanservice;
	
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> list(Integer saleChanceId){
		return cusDevPlanservice.find(saleChanceId);
	}
}
