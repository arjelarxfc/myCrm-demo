package com.myproject.ssm.crm.service.common.model;

import com.myproject.ssm.crm.common.domain.SysPopedomKey;

public class SysPopedomPrivilegeModel {

	private String roleId;
	private SysPopedomKey sysPopedomKey;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	public SysPopedomKey getSysPopedomKey() {
		return sysPopedomKey;
	}

	public void setSysPopedomKey(SysPopedomKey sysPopedomKey) {
		this.sysPopedomKey = sysPopedomKey;
	}

}