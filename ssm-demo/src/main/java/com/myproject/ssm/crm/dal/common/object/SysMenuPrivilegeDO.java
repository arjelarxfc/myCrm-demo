package com.myproject.ssm.crm.dal.common.object;

import java.io.Serializable;

import com.myproject.ssm.crm.common.domain.SysMenuKey;

public class SysMenuPrivilegeDO extends SysMenuKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5154392534260634179L;
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

}