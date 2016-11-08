package com.myproject.ssm.crm.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.ssm.crm.dal.SysUserGroupDAO;
import com.myproject.ssm.crm.dal.common.object.SysUserGroupDO;
import com.myproject.ssm.crm.service.SysUserGroupService;
import com.myproject.ssm.crm.service.common.model.SysUserGroupModel;

@Service("SysUserGroupService")
public class SysUserGroupServiceImpl implements SysUserGroupService {

	private Logger LOGGER = LoggerFactory.getLogger(SysUserGroupServiceImpl.class);

	@Autowired
	private SysUserGroupDAO sysUserGroupDAO;

	@Override
	public List<SysUserGroupModel> getGroups(String name) {
		List<SysUserGroupModel> list = new ArrayList<SysUserGroupModel>();
		List<SysUserGroupDO> groups = null;
		if (StringUtils.isNotBlank(name)) {
			groups = sysUserGroupDAO.getSysUserGroups(name);
		} else {
			groups = sysUserGroupDAO.getSysUserGroups(null);
		}
		SysUserGroupModel model = null;
		for (SysUserGroupDO tmp : groups) {
			model = new SysUserGroupModel();
			BeanUtils.copyProperties(tmp, model);
			list.add(model);
		}
		return list;
	}

	@Override
	public int groupAdd(SysUserGroupModel model) {
		SysUserGroupDO groupDO = new SysUserGroupDO();
		BeanUtils.copyProperties(model, groupDO);
		int i = sysUserGroupDAO.insert(groupDO);
		return i;
	}

	@Override
	public SysUserGroupModel getGroupById(Integer id) {
		SysUserGroupDO groupDO = sysUserGroupDAO.selectByPrimaryKey(id);
		if (groupDO == null) {
			LOGGER.error("查询的部门不存在,id=" + id);
			return new SysUserGroupModel();
		}
		// 要传值的对象
		SysUserGroupModel groupModel = new SysUserGroupModel();
		BeanUtils.copyProperties(groupDO, groupModel);
		return groupModel;
	}

	@Override
	public int groupUpdate(SysUserGroupModel model) {
		SysUserGroupDO groupDO = new SysUserGroupDO();
		BeanUtils.copyProperties(model, groupDO);
		return sysUserGroupDAO.updateByPrimaryKeySelective(groupDO);
	}

	@Override
	public int deleteGroup(String ids) {
		int i = 0;
		if (ids.contains(",")) {
			String[] arrId = ids.split(",");
			List<String> idList = Arrays.asList(arrId);
			List<Integer> list = new ArrayList<Integer>();
			for (String tmp : idList) {
				list.add(Integer.valueOf(tmp));
			}
			i = sysUserGroupDAO.deleteGroups(list);
		} else {
			i = sysUserGroupDAO.deleteByPrimaryKey(Integer.valueOf(ids));
		}
		return i;
	}

}
