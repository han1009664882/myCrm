package com.shsxt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.dao.CustomerDao;
import com.shsxt.vo.CustomerVo;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	/**
	 * 获取所有的客户
	 * @return
	 */
	public List<CustomerVo> findAll(){
		return customerDao.listAll();
	}
	
}
