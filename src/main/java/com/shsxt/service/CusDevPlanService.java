package com.shsxt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.dao.CusDevPlanDao;
import com.shsxt.model.CusDevPlan;
import com.shsxt.util.AssertUtil;

@Service
public class CusDevPlanService {
	
	@Autowired
	private CusDevPlanDao cusDevPlanDao;
	
	
	/**
	 * 获取客户开发进度
	 * @param saleChanceId
	 * @return
	 */
	public Map<String, Object> find(Integer saleChanceId){
		AssertUtil.isTrue(saleChanceId==null||saleChanceId<1, "请选择一条销售机会");
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("saleChanceId", saleChanceId);
		List<CusDevPlan> list = cusDevPlanDao.find(param);
		Map<String, Object> result = new HashMap<String, Object>();
        result.put("rows", list);
		return result;
	}
}
