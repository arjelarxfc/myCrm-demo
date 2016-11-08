package com.myproject.ssm.crm.service;

import java.util.List;

import com.myproject.ssm.crm.service.common.model.SysPopedomPrivilegeModel;

public interface SysPopedomPrivilegeService {

	int deleteByPrimaryKey(SysPopedomPrivilegeModel key);

	int insert(SysPopedomPrivilegeModel record);

	int insertSelective(SysPopedomPrivilegeModel record);

	List<SysPopedomPrivilegeModel> selectAllPopedomPrivileges();

	List<SysPopedomPrivilegeModel> selectPopedomPrivilegeByRoleId(String roleId);

	int updatePopedom(String id, String popedomModule);
}
