package com.shsxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.crm.base.BaseDao;
import com.shsxt.vo.CustomerVo;

public interface CustomerDao extends BaseDao<CustomerVo>{

	@Select("select id,name from t_customer where isValid = 1 and state = 0 ")
	public List<CustomerVo> listAll();
}
