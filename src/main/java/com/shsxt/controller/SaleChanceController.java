package com.shsxt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class SaleChanceController extends BaseController {

	@Autowired
	private SaleChanceService saleChanceService;

	/**
	 * 修改开发结果
	 * @param saleChanceId
	 * @param devResult
	 * @return
	 */
	@RequestMapping("update_devResult")
	@ResponseBody
	public ResultInfo updateDevResult(Integer saleChanceId,Integer devResult){
		saleChanceService.updateDevResult(saleChanceId, devResult);
		return success(Constant.OPT_SUCCESS);
	}
	
	/**
	 * 详细信息
	 * @param saleChanceId
	 * @param show
	 * @param model
	 * @return
	 */
	@RequestMapping("detail")
	public String detail(Integer saleChanceId, Integer show, Model model){
		SaleChance saleChance = saleChanceService.findById(saleChanceId);
		model.addAttribute("saleChance",saleChance);
		model.addAttribute("show", show);
		return "cus_dev_plan_detail";
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public ResultInfo delete(String ids) {
		saleChanceService.delete(ids);
		return success(Constant.OPT_SUCCESS);
	}

	/**
	 * 增加、修改
	 * @param saleChance
	 * @return
	 */
	@RequestMapping("add_update")
	@ResponseBody
	public ResultInfo addOrUpdate(SaleChance saleChance) {
		saleChanceService.addOrUpdate(saleChance);
		return success(Constant.OPT_SUCCESS);
	}

	/**
	 * 分页
	 * @param query
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public Map<String, Object> selectForPage(SaleChanceQuery query) {
		return saleChanceService.selectForPage(query);
	}

	@RequestMapping("index")
	public String index(Integer state) {
		if (state == null) {
			return "sale_chance";
		} else {
			return "cus_dev_plan";
		}
	}
}
