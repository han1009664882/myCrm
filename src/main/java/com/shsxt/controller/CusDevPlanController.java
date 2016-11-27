package com.shsxt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.base.ResultInfo;
import com.shsxt.constant.Constant;
import com.shsxt.model.CusDevPlan;
import com.shsxt.service.CusDevPlanService;

@Controller
@RequestMapping("cus_dev_plan")
public class CusDevPlanController {

	@Autowired
	private CusDevPlanService cusDevPlanservice;
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(Integer id){
		cusDevPlanservice.delete(id);
		return new ResultInfo(Constant.OPT_SUCCESS);
	}
	
	/**
	 * 添加和修改
	 * @param cusDevPlan
	 * @return
	 */
	@RequestMapping("add_update")
	@ResponseBody
	public ResultInfo addOrUpdate(CusDevPlan cusDevPlan){
		cusDevPlanservice.addOrUpdate(cusDevPlan);
		return new ResultInfo(Constant.OPT_SUCCESS);
	}
	
	/**
	 * 
	 * @param saleChanceId
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public Map<String,List<CusDevPlan>> list(Integer saleChanceId){
		return cusDevPlanservice.find(saleChanceId);
	}
}
