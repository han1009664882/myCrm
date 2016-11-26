package com.shsxt.constant;

public enum SaleChanceState {

	UN_ASSIGN(0),// 未分配
	
	ASSIGN(1);  // 已分配
	
	private int type;

	private SaleChanceState() {
		
	}

	private SaleChanceState(int type){
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
