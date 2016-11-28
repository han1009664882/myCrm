package com.shsxt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.dao.CustomerDao;
import com.shsxt.model.Customer;
import com.shsxt.query.CustomerQuery;
import com.shsxt.util.MathUtil;
import com.shsxt.vo.CustomerVo;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	/**
	 * 增加和修改
	 * @param customer
	 */
	public void addOrUpdate(Customer customer){
		if(customer.getId()==null){
			customer.setKhno(MathUtil.genereateKhCode());
			customerDao.insert(customer);
		} else {
			customerDao.update(customer);
		}
	}
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	public Map<String,Object> selectForPage(CustomerQuery query){
		List<Customer> customers = customerDao.selectForPage(query, query.initPageBounds());
		PageList<Customer> list = (PageList<Customer>) customers;
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("rows", list);
		result.put("paginator", list.getPaginator());
		result.put("total", list.getPaginator().getTotalCount());
		return result;
	}
	
	/**
	 * 获取所有的客户
	 * @return
	 */
	public List<CustomerVo> findAll(){
		return customerDao.listAll();
	}
	
}
