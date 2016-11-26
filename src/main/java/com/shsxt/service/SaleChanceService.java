package com.shsxt.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.base.exception.ParamException;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.constant.SaleChanceDevResult;
import com.shsxt.constant.SaleChanceState;
import com.shsxt.dao.SaleChanceDao;
import com.shsxt.model.SaleChance;
import com.shsxt.query.SaleChanceQuery;
import com.shsxt.util.AssertUtil;

@Service
public class SaleChanceService {

	@Autowired
	private SaleChanceDao saleChanceDao;


	/**
	 * 删除 delete * from 表 where id in (1, 2)
	 * @param ids 多个以逗号分隔 1,2
	 */
	public void delete(String ids) {
		if (StringUtils.isBlank(ids)) {
			throw new ParamException("请选择要删除的记录");
		}
		saleChanceDao.deleteBatch(ids);
	}
	
	/**
	 * 根据Id添加或修改
	 * @param saleChance
	 */
	public void addOrUpdate(SaleChance saleChance) {
		// 基本参数验证
		Integer customerId = saleChance.getCustomerId();
		if (customerId == null || customerId < 1) {
			throw new ParamException("请选择客户");
		}

		String customerName = saleChance.getCustomerName();
		AssertUtil.notEmpty(customerName, "请选择客户");
		
		int cgjl = saleChance.getCgjl();
		if(cgjl<1){
			throw new ParamException("请输入成功几率");
		}
		
		Integer id = saleChance.getId();
		
		// 如果id为空则添加
		if(id==null || id<1){
			String assignMan = saleChance.getAssignMan();
			//如果是分配好的
			if(!StringUtils.isBlank(assignMan)){
				saleChance.setAssignTime(new Date());
				saleChance.setState(SaleChanceState.ASSIGN.getType());
			}
			saleChance.setState(SaleChanceDevResult.UN_DEVELOPE.getType());
			saleChance.setCreateDate(new Date());
			saleChance.setUpdateDate(new Date());
			saleChanceDao.insert(saleChance);
		} else { // 修改
			String assignMan = saleChance.getAssignMan();
			//如果是分配好的
			if(!StringUtils.isBlank(assignMan)){
				saleChance.setAssignTime(new Date());
				saleChance.setState(SaleChanceState.ASSIGN.getType());
			}
			saleChance.setUpdateDate(new Date());
			saleChanceDao.update(saleChance);
		}
	}
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	public Map<String, Object> selectForPage(SaleChanceQuery query) {

		// 构建查询的分页参数
		PageBounds pageBounds = new PageBounds(query.getPage(), query.getLimit(), Order.formString(query.getSort()));

		// 分页查询
		List<SaleChance> saleChances = saleChanceDao.selectForPage(query, pageBounds);

		// 获得结果集
		PageList<SaleChance> pageList = (PageList<SaleChance>) saleChances;

		// 构建返回结果
		Map<String, Object> result = new HashMap<>();
		result.put("rows", pageList);
		result.put("paginator", pageList.getPaginator());
		result.put("total", pageList.getPaginator().getTotalCount());// 总记录数
		return result;
	}

}
