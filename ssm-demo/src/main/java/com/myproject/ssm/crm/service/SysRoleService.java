package com.myproject.ssm.crm.service;

import java.util.List;

import com.myproject.ssm.crm.service.common.model.SysRoleModel;

public interface SysRoleService {

	/**
	 * 获取人事管理的所有用户角色
	 * @return
	 */
	List<SysRoleModel> getAllRoles();

	int roleAdd(SysRoleModel model);

	SysRoleModel getRoleById(String id);

	int roleUpdate(SysRoleModel model);

	int deleteRole(String ids);

}
