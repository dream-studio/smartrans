package com.dream.smartrans.action.json;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.james.common.utils.Pagination;
import org.james.common.utils.ajax.Reply;

import com.dream.smartrans.action.BaseAction;
import com.dream.smartrans.condition.AbstractCondition;

@Results({ @Result(name = "json", type = "json", params = { "root", "reply" }) })
public class JsonAction extends BaseAction {

	private static final long serialVersionUID = 8256468859982232293L;

	public static final String JSON = "json";
	
	private int page;
	private int start;
	private int limit;
	
	@Override
	public String invalidUser() {
		this.setFailure("Invalid User!");
		return JSON;
	}
	
	@Override
	public boolean testUser() {
		return false;
	}

	public String execute() {
		reply.setMsg("It Works!!");
		return JSON;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	protected void collectPaginationData(AbstractCondition condition){
		Pagination p = new Pagination(page, limit, true);
		condition.setPage(p);
	}
}
