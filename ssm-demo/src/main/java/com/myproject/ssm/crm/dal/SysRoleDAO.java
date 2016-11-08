package com.myproject.ssm.crm.dal;

import java.util.List;

import com.myproject.ssm.crm.dal.common.object.SysRoleDO;

public interface SysRoleDAO {
	
    int deleteByPrimaryKey(String id);

    int insert(SysRoleDO record);

    int insertSelective(SysRoleDO record);

    SysRoleDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRoleDO record);

    int updateByPrimaryKeyWithBLOBs(SysRoleDO record);

    int updateByPrimaryKey(SysRoleDO record);

	List<SysRoleDO> getAllRoles();

	int deleteRoles(List<String> idList);

}