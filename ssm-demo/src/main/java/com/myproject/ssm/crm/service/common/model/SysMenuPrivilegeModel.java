package com.myproject.ssm.crm.service.common.model;

import com.myproject.ssm.crm.common.domain.SysMenuKey;

public class SysMenuPrivilegeModel {
	
	private String roleId;
    private SysMenuKey sysMenuKey;
    
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public SysMenuKey getSysMenuKey() {
		return sysMenuKey;
	}
	public void setSysMenuKey(SysMenuKey sysMenuKey) {
		this.sysMenuKey = sysMenuKey;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((sysMenuKey == null) ? 0 : sysMenuKey.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysMenuPrivilegeModel other = (SysMenuPrivilegeModel) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (sysMenuKey == null) {
			if (other.sysMenuKey != null)
				return false;
		} else if (!sysMenuKey.equals(other.sysMenuKey))
			return false;
		return true;
	}
	
}
