package com.myproject.ssm.crm.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.myproject.ssm.crm.dal.SysRoleDAO;
import com.myproject.ssm.crm.dal.common.object.SysRoleDO;
import com.myproject.ssm.crm.service.SysRoleService;
import com.myproject.ssm.crm.service.common.model.SysRoleModel;

@Service("SysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	private Logger LOGGER = LoggerFactory.getLogger(SysRoleServiceImpl.class);
	@Autowired
	private SysRoleDAO sysRoleDAO;

	@Override
	public List<SysRoleModel> getAllRoles() {
		List<SysRoleDO> DOs = sysRoleDAO.getAllRoles();
		if (CollectionUtils.isEmpty(DOs)) {
			LOGGER.error("SysRoleServiceImpl getAllRoles|DOs is null");
			return null;
		}
		List<SysRoleModel> models = new ArrayList<SysRoleModel>();
		SysRoleModel sysRoleModel = null;
		for (SysRoleDO tmp : DOs) {
			sysRoleModel = new SysRoleModel();
			BeanUtils.copyProperties(tmp, sysRoleModel);
			models.add(sysRoleModel);
		}
		return models;
	}

	@Override
	public int roleAdd(SysRoleModel model) {
		SysRoleDO sysRoleDO = new SysRoleDO();
		BeanUtils.copyProperties(model, sysRoleDO);
		return sysRoleDAO.insert(sysRoleDO);
	}

	@Override
	public SysRoleModel getRoleById(String id) {
		SysRoleDO roleDO = sysRoleDAO.selectByPrimaryKey(id);
		SysRoleModel model = new SysRoleModel();
		BeanUtils.copyProperties(roleDO, model);
		return model;
	}

	@Override
	public int roleUpdate(SysRoleModel model) {
		SysRoleDO roleDO = new SysRoleDO();
		BeanUtils.copyProperties(model, roleDO);
		return sysRoleDAO.updateByPrimaryKeySelective(roleDO);
	}

	@Override
	public int deleteRole(String ids) {
		int i = 0;
		if (ids.contains(",")) {
			// 批量
			String[] arrId = ids.split(",");
			List<String> idList = Arrays.asList(arrId);
			i = sysRoleDAO.deleteRoles(idList);
		} else {
			// 单条
			i = sysRoleDAO.deleteByPrimaryKey(ids);
		}
		return i;
	}

}
