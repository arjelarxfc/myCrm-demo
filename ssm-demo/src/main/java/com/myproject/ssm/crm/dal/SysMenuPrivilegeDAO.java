package com.myproject.ssm.crm.dal;

import java.util.List;

import com.myproject.ssm.crm.dal.common.object.SysMenuPrivilegeDO;

public interface SysMenuPrivilegeDAO {

	public int deleteByPrimaryKey(SysMenuPrivilegeDO key);

	public int insert(SysMenuPrivilegeDO record);

	public int insertSelective(SysMenuPrivilegeDO record);

	public List<SysMenuPrivilegeDO> queryById(String roleId);

	public List<SysMenuPrivilegeDO> findAllSysMenuPrivileges();

	public int insertMenuPrivList(List<SysMenuPrivilegeDO> list);
	
	public int delMenuPrivileges(List<SysMenuPrivilegeDO> list);

}