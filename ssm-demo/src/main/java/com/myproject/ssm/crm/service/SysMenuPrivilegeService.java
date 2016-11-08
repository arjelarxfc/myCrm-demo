package com.myproject.ssm.crm.service;

import java.util.List;

import com.myproject.ssm.crm.service.common.model.SysMenuPrivilegeModel;
import com.myproject.ssm.crm.service.common.model.SysRoleModel;

public interface SysMenuPrivilegeService {

	public List<SysMenuPrivilegeModel> findAllSysMenuPrivileges();

	public List<SysMenuPrivilegeModel> findById(String sid);

	public int updateMenuPrivilege(SysRoleModel model, String roleId, String menuModule);

}
