package com.shsxt.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.crm.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 客户开发计划实体类
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CusDevPlan extends BaseModel{
	
	private Integer id; // 编号
	
	private Integer saleChanceId; // 销售机会
	
	private String planItem; // 计划项
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date planDate; // 计划日期
	
	private String exeAffect; // 执行效果

	public CusDevPlan() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSaleChanceId() {
		return saleChanceId;
	}

	public void setSaleChanceId(Integer saleChanceId) {
		this.saleChanceId = saleChanceId;
	}

	public String getPlanItem() {
		return planItem;
	}

	public void setPlanItem(String planItem) {
		this.planItem = planItem;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public String getExeAffect() {
		return exeAffect;
	}

	public void setExeAffect(String exeAffect) {
		this.exeAffect = exeAffect;
	}
	
	
}
