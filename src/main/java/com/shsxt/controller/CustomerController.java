package com.shsxt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.base.BaseController;
import com.shsxt.query.CustomerQuery;
import com.shsxt.service.CustomerService;
import com.shsxt.vo.CustomerVo;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController{

	@Autowired
	private CustomerService customerService;
	
	/**
	 * 分页
	 * @param query
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object> selectForPage(CustomerQuery query){
		return customerService.selectForPage(query);
	}
	
	@RequestMapping("index")
	public String index(){
		return "customer";
	}
	
	@RequestMapping("find_all")
	@ResponseBody
	public List<CustomerVo> findAll(){
		return customerService.findAll();
	}
}
