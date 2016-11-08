package com.myproject.ssm.crm.service;

import java.util.List;
import java.util.Map;

import com.myproject.ssm.crm.service.common.model.SysUserModel;

public interface SysUserService {

	/**
	 * 通过用户名和密码查询用户信息
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public SysUserModel findSysUserByNameAndPassword(String name, String password);

	public List<SysUserModel> getAllSysUsers();

	public SysUserModel getUserById(String id);

	public int sysUserAdd(Map<String, Object> retMap);

	public int sysUserUpdate(Map<String, Object> retMap);

	public int sysUserDel(String ids);

	public int sysUserStatus(String ids, String string);

}
