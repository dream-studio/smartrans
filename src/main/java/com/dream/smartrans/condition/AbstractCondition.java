package com.dream.smartrans.condition;

import org.james.common.utils.Pagination;

public abstract class AbstractCondition {
	private String q;
	private String startDate;
	private String endDate;

	private Pagination page;
	
	public abstract boolean isUsePaging();
	
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public Pagination getPage() {
		return page;
	}
	public void setPage(Pagination page) {
		this.page = page;
	}
}
