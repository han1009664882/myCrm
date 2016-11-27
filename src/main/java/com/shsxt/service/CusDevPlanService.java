package com.shsxt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shsxt.dao.CusDevPlanDao;
import com.shsxt.model.CusDevPlan;
import com.shsxt.util.AssertUtil;

@Service
public class CusDevPlanService {
	
	@Autowired
	private CusDevPlanDao cusDevPlanDao;
	
	@Autowired
	private SaleChanceService saleChanceService;
	
	/**
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		AssertUtil.isTrue(id==null||id<1, "请选择要删除的记录");
		cusDevPlanDao.delete(id);
	}
	
	/**
	 * 添加和修改
	 * @param cusDevPlan
	 */
	@Transactional
	public void addOrUpdate(CusDevPlan cusDevPlan){
		//参数校验
		AssertUtil.notEmpty(cusDevPlan.getPlanItem(), "请输入计划内容");
		AssertUtil.notEmpty(cusDevPlan.getExeAffect(), "请输入执行效果");
		AssertUtil.notNull(cusDevPlan.getPlanDate(), "请输入计划日期");
		if(cusDevPlan.getId()!=null){
			cusDevPlanDao.update(cusDevPlan);
		} else {
			cusDevPlanDao.insert(cusDevPlan);
			// 新增的话就要将saleChance表中的开发状态改成开发中
			saleChanceService.updateDevResult(cusDevPlan.getSaleChanceId(), 1);
		}
	}
	
	/**
	 * 获取客户开发进度
	 * @param saleChanceId
	 * @return
	 */
	public Map<String, List<CusDevPlan>> find(Integer saleChanceId){
		AssertUtil.isTrue(saleChanceId==null||saleChanceId<1, "请选择一条销售机会");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("saleChanceId", saleChanceId);
		List<CusDevPlan> list = cusDevPlanDao.find(param);
		Map<String, List<CusDevPlan>> result = new HashMap<String, List<CusDevPlan>>();
        result.put("rows", list);
		return result;
	}

}
