package com.myproject.ssm.crm.service;

import java.util.List;

import com.myproject.ssm.crm.service.common.model.SysUserGroupModel;

public interface SysUserGroupService {
	
	/**
	 * 根据部门名称查询
	 * @param name
	 * @return
	 */
	public List<SysUserGroupModel> getGroups(String name);
	
	/**
	 * 创建一个新的部门
	 * @param model
	 * @return 
	 */
	public int groupAdd(SysUserGroupModel model);
	
	/**
	 * 根据id获取一个部门
	 * @param id
	 * @return
	 */
	public SysUserGroupModel getGroupById(Integer id);

	/**
	 * 更新一个部门信息
	 * @param model
	 * @return
	 */
	public int groupUpdate(SysUserGroupModel model);

	/**
	 * 可批量删除部门
	 * @param ids
	 * @return
	 */
	public int deleteGroup(String ids);

}
