package com.shsxt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.base.BaseController;
import com.crm.base.ResultInfo;
import com.shsxt.constant.Constant;
import com.shsxt.model.SaleChance;
import com.shsxt.query.SaleChanceQuery;
import com.shsxt.service.SaleChanceService;

@Controller
@RequestMapping("sale_chance")
public class SaleChanceController extends BaseController{

	@Autowired
	private SaleChanceService saleChanceService;
	
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(String ids){
		try {
			saleChanceService.delete(ids);
			return success(Constant.OPT_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return failure(Constant.OPT_FAILURE);
		}
	}
	
	/**
	 * 增加、修改
	 * @param saleChance
	 * @return
	 */
	@RequestMapping("add_update")
	@ResponseBody
	public ResultInfo addOrUpdate(SaleChance saleChance){
		try {
			saleChanceService.addOrUpdate(saleChance);
			return success(Constant.OPT_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return failure(Constant.OPT_FAILURE);
		}
	}
	
	/**
	 * 分页
	 * @param query
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> selectForPage(SaleChanceQuery query){
		return saleChanceService.selectForPage(query);
	}
	
	@RequestMapping("index")
	public String index(Integer state){
		if(state==null){
			return "sale_chance";
		} else {
			return "cus_dev_plan";
		}
	}
}
