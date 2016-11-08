package com.myproject.ssm.crm.dal.common.object;

import com.myproject.ssm.crm.common.domain.SysPopedomKey;

public class SysPopedomDO extends SysPopedomKey {

	private Integer sort;
	private String title;
	private String popedomName;
	private String remark;

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getPopedomName() {
		return popedomName;
	}

	public void setPopedomName(String popedomName) {
		this.popedomName = popedomName == null ? null : popedomName.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}