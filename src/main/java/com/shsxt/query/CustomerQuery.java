package com.shsxt.query;

import com.crm.base.BaseQuery;

@SuppressWarnings("serial")
public class CustomerQuery extends BaseQuery {

	private String khno; // 客户编号 动态生成

	private String name; // 客户名称

	public String getKhno() {
		return khno;
	}

	public void setKhno(String khno) {
		this.khno = khno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
