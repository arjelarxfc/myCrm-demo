package com.myproject.ssm.crm.dal;

import java.util.List;

import com.myproject.ssm.crm.dal.common.object.SysUserGroupDO;

public interface SysUserGroupDAO {

	int deleteByPrimaryKey(Integer id);

	int insert(SysUserGroupDO record);

	int insertSelective(SysUserGroupDO record);

	SysUserGroupDO selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysUserGroupDO record);

	int updateByPrimaryKeyWithBLOBs(SysUserGroupDO record);

	int updateByPrimaryKey(SysUserGroupDO record);

	List<SysUserGroupDO> getSysUserGroups(String name);

	public int deleteGroups(List<Integer> list);
}