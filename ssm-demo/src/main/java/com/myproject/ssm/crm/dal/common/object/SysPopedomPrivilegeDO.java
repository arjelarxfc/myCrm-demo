package com.myproject.ssm.crm.dal.common.object;

import java.io.Serializable;

import com.myproject.ssm.crm.common.domain.SysPopedomKey;

public class SysPopedomPrivilegeDO extends SysPopedomKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4073101889432884609L;

	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
