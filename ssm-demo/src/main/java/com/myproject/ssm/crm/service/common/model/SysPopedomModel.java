package com.myproject.ssm.crm.service.common.model;

import com.myproject.ssm.crm.common.domain.SysPopedomKey;

public class SysPopedomModel {

	private String sort;
	private String title;
	private String popedomName;
	private String remark;
	private SysPopedomKey sysPopedomKey;

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPopedomName() {
		return popedomName;
	}

	public void setPopedomName(String popedomName) {
		this.popedomName = popedomName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SysPopedomKey getSysPopedomKey() {
		return sysPopedomKey;
	}

	public void setSysPopedomKey(SysPopedomKey sysPopedomKey) {
		this.sysPopedomKey = sysPopedomKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((popedomName == null) ? 0 : popedomName.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((sort == null) ? 0 : sort.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysPopedomModel other = (SysPopedomModel) obj;
		if (popedomName == null) {
			if (other.popedomName != null)
				return false;
		} else if (!popedomName.equals(other.popedomName))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (sort == null) {
			if (other.sort != null)
				return false;
		} else if (!sort.equals(other.sort))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SysPopedomModel [sort=" + sort + ", title=" + title + ", popedomName=" + popedomName + ", remark="
				+ remark + "]";
	}

}
