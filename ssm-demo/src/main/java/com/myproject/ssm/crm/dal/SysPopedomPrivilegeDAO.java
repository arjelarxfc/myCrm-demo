package com.myproject.ssm.crm.dal;

import java.util.List;

import com.myproject.ssm.crm.dal.common.object.SysPopedomPrivilegeDO;

public interface SysPopedomPrivilegeDAO {
	int deleteByPrimaryKey(SysPopedomPrivilegeDO key);

	int insert(SysPopedomPrivilegeDO record);

	int insertSelective(SysPopedomPrivilegeDO record);

	List<SysPopedomPrivilegeDO> selectAllPopedomPrivileges();

	List<SysPopedomPrivilegeDO> selectPopedomPrivilegeByRoleid(String roleId);

	int insertPopePrivList(List<SysPopedomPrivilegeDO> sysPopePrivList);

	int delPopedomPrivileges(List<SysPopedomPrivilegeDO> removingList);
}