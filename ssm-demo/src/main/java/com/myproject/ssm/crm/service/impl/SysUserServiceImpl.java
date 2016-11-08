package com.myproject.ssm.crm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.myproject.ssm.crm.dal.SysRoleDAO;
import com.myproject.ssm.crm.dal.SysUserDAO;
import com.myproject.ssm.crm.dal.SysUserGroupDAO;
import com.myproject.ssm.crm.dal.common.object.SysRoleDO;
import com.myproject.ssm.crm.dal.common.object.SysUserDO;
import com.myproject.ssm.crm.dal.common.object.SysUserDOWithBLOBs;
import com.myproject.ssm.crm.dal.common.object.SysUserGroupDO;
import com.myproject.ssm.crm.service.SysUserService;
import com.myproject.ssm.crm.service.common.model.SysRoleModel;
import com.myproject.ssm.crm.service.common.model.SysUserGroupModel;
import com.myproject.ssm.crm.service.common.model.SysUserModel;
import com.myproject.ssm.utils.MD5keyBean;

@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {

	private Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);
	@Autowired
	private SysUserDAO sysUserDAO;
	@Autowired
	private SysUserGroupDAO sysUserGroupDAO;
	@Autowired
	private SysRoleDAO sysRoleDAO;

	@Override
	public SysUserModel findSysUserByNameAndPassword(String name, String password) {
		SysUserDO sysUserDO = sysUserDAO.findSysUserByNameAndPassword(name, password);
		SysUserModel sysUserModel = new SysUserModel();
		String[] ignoreProperties = { "beginDate", "endDate", "birthday", "workDate", "finishSchoolDate" };
		BeanUtils.copyProperties(sysUserDO, sysUserModel, ignoreProperties);
		// 为sysUserModel获取部门对象
		SysUserGroupDO sysUserGroupDO = sysUserGroupDAO.selectByPrimaryKey(sysUserDO.getGroupId());
		SysUserGroupModel sysUserGroupModel = new SysUserGroupModel();
		BeanUtils.copyProperties(sysUserGroupDO, sysUserGroupModel);
		// 为sysUserModel获取用户角色
		SysRoleDO sysRoleDO = sysRoleDAO.selectByPrimaryKey(sysUserDO.getRoleId());
		SysRoleModel sysRoleModel = new SysRoleModel();
		BeanUtils.copyProperties(sysRoleDO, sysRoleModel);
		// 添加
		sysUserModel.setSysUserGroupModel(sysUserGroupModel);
		sysUserModel.setSysRoleModel(sysRoleModel);

		return sysUserModel;
	}

	@Override
	public List<SysUserModel> getAllSysUsers() {
		List<SysUserDO> DOs = sysUserDAO.getAllSysUsers();
		if (CollectionUtils.isEmpty(DOs)) {
			LOGGER.error("SysUserServiceImpl getAllSysUsers|DOs is null");
		}
		List<SysUserModel> models = new ArrayList<SysUserModel>();
		SysUserModel model = null;
		SysRoleModel sysRoleModel = null;
		SysUserGroupModel sysUserGroupModel = null;
		// 使用对象转换需要忽略的属性，然后使用手动方式设置
		String[] ignoreProperties = { "beginDate", "endDate", "birthday", "workDate", "finishSchoolDate" };
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (SysUserDO tmp : DOs) {
			model = new SysUserModel();
			sysRoleModel = new SysRoleModel();
			sysUserGroupModel = new SysUserGroupModel();
			BeanUtils.copyProperties(tmp, model, ignoreProperties);
			if (tmp.getBeginDate() != null) {
				model.setBeginDate(sdf.format(tmp.getBeginDate()));
			}
			if (tmp.getEndDate() != null) {
				model.setEndDate(sdf.format(tmp.getEndDate()));
			}
			if (tmp.getBirthday() != null) {
				model.setBirthday(sdf.format(tmp.getBirthday()));
			}
			if (tmp.getWorkDate() != null) {
				model.setWorkDate(sdf.format(tmp.getWorkDate()));
			}
			if (tmp.getFinishSchoolDate() != null) {
				model.setFinishSchoolDate(sdf.format(tmp.getFinishSchoolDate()));
			}
			BeanUtils.copyProperties(sysRoleDAO.selectByPrimaryKey(tmp.getRoleId()), sysRoleModel);
			BeanUtils.copyProperties(sysUserGroupDAO.selectByPrimaryKey(tmp.getGroupId()), sysUserGroupModel);
			model.setSysUserGroupModel(sysUserGroupModel);
			model.setSysRoleModel(sysRoleModel);
			models.add(model);
		}
		return models;
	}

	@Override
	public SysUserModel getUserById(String id) {
		SysUserDOWithBLOBs sysUserDO = sysUserDAO.selectByPrimaryKey(Integer.valueOf(id));
		if (sysUserDO == null) {
			LOGGER.error("数据库查询该对象为空不存在,id=" + id);
			return null;
		}
		// 使用对象转换需要忽略的属性，然后使用手动方式设置
		String[] ignoreProperties = { "beginDate", "endDate", "birthday", "workDate", "finishSchoolDate" };
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SysUserModel model = new SysUserModel();
		SysRoleModel sysRoleModel = new SysRoleModel();
		SysUserGroupModel sysUserGroupModel = new SysUserGroupModel();
		BeanUtils.copyProperties(sysUserDO, model, ignoreProperties);
		if (sysUserDO.getBeginDate() != null) {
			model.setBeginDate(sdf.format(sysUserDO.getBeginDate()));
		}
		if (sysUserDO.getEndDate() != null) {
			model.setEndDate(sdf.format(sysUserDO.getEndDate()));
		}
		if (sysUserDO.getBirthday() != null) {
			model.setBirthday(sdf.format(sysUserDO.getBirthday()));
		}
		if (sysUserDO.getWorkDate() != null) {
			model.setWorkDate(sdf.format(sysUserDO.getWorkDate()));
		}
		if (sysUserDO.getFinishSchoolDate() != null) {
			model.setFinishSchoolDate(sdf.format(sysUserDO.getFinishSchoolDate()));
		}
		BeanUtils.copyProperties(sysUserGroupDAO.selectByPrimaryKey(sysUserDO.getGroupId()), sysUserGroupModel);
		BeanUtils.copyProperties(sysRoleDAO.selectByPrimaryKey(sysUserDO.getRoleId()), sysRoleModel);
		model.setSysUserGroupModel(sysUserGroupModel);
		model.setSysRoleModel(sysRoleModel);
		return model;
	}

	@Override
	public int sysUserAdd(Map<String, Object> retMap) {
		// 使用对象转换需要忽略的属性，然后使用手动方式设置
		String[] ignoreProperties = { "beginDate", "endDate", "birthday", "workDate", "finishSchoolDate" };
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 设置MD5加密密码
		MD5keyBean m = new MD5keyBean();
		SysUserDOWithBLOBs sysUserDO = new SysUserDOWithBLOBs();
		SysUserModel model = (SysUserModel) retMap.get("sysUserModel");
		BeanUtils.copyProperties(model, sysUserDO, ignoreProperties);
		try {
			if (StringUtils.isNotBlank(model.getBeginDate())) {
				sysUserDO.setBeginDate(sdf.parse(model.getBeginDate()));
			}
			if (StringUtils.isNotBlank(model.getEndDate())) {
				sysUserDO.setEndDate(sdf.parse(model.getEndDate()));
			}
			if (StringUtils.isNotBlank(model.getBirthday())) {
				sysUserDO.setBirthday(sdf.parse(model.getBirthday()));
			}
			if (StringUtils.isNotBlank(model.getWorkDate())) {
				sysUserDO.setWorkDate(sdf.parse(model.getWorkDate()));
			}
			if (StringUtils.isNotBlank(model.getFinishSchoolDate())) {
				sysUserDO.setFinishSchoolDate(sdf.parse(model.getFinishSchoolDate()));
			}
		} catch (ParseException e) {
			LOGGER.error("SysUserServiceImpl | sysUserAdd | sysUserModel对象日期解析错误" + e);
			return 0;
		}
		sysUserDO.setPassword(m.getkeyBeanofStr(model.getPassword()));
		sysUserDO.setRoleId((String) retMap.get("sysRoleId"));
		sysUserDO.setGroupId(Integer.valueOf((String) retMap.get("sysUserGroupId")));
		// 执行保存操作
		return sysUserDAO.insertSelective(sysUserDO);
	}

	@Override
	public int sysUserUpdate(Map<String, Object> retMap) {
		String[] ignoreProperties = { "beginDate", "endDate", "birthday", "workDate", "finishSchoolDate" };
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SysUserDOWithBLOBs sysUserDO = new SysUserDOWithBLOBs();
		SysUserModel model = (SysUserModel) retMap.get("sysUserModel");
		BeanUtils.copyProperties(model, sysUserDO, ignoreProperties);
		try {
			if (StringUtils.isNotBlank(model.getBeginDate())) {
				sysUserDO.setBeginDate(sdf.parse(model.getBeginDate()));
			}
			if (StringUtils.isNotBlank(model.getEndDate())) {
				sysUserDO.setEndDate(sdf.parse(model.getEndDate()));
			}
			if (StringUtils.isNotBlank(model.getBirthday())) {
				sysUserDO.setBirthday(sdf.parse(model.getBirthday()));
			}
			if (StringUtils.isNotBlank(model.getWorkDate())) {
				sysUserDO.setWorkDate(sdf.parse(model.getWorkDate()));
			}
			if (StringUtils.isNotBlank(model.getFinishSchoolDate())) {
				sysUserDO.setFinishSchoolDate(sdf.parse(model.getFinishSchoolDate()));
			}
		} catch (ParseException e) {
			LOGGER.error("SysUserServiceImpl | sysUserAdd | sysUserModel对象日期解析错误" + e);
			return 0;
		}
		sysUserDO.setRoleId((String) retMap.get("sysRoleId"));
		sysUserDO.setGroupId(Integer.valueOf((String) retMap.get("sysUserGroupId")));
		return sysUserDAO.updateByPrimaryKeyWithBLOBs(sysUserDO);
	}

	@Override
	public int sysUserDel(String ids) {
		int i = 0;
		if (ids.contains(",")) {
			String[] arrId = ids.split(",");
			List<String> idList = Arrays.asList(arrId);
			List<Integer> list = new ArrayList<Integer>();
			for (String tmp : idList) {
				list.add(Integer.valueOf(tmp));
			}
			i = sysUserDAO.deleteSysUsers(list);
		} else {
			i = sysUserDAO.deleteByPrimaryKey(Integer.valueOf(ids));
		}
		return i;
	}

	@Override
	public int sysUserStatus(String ids, String status) {
		Map<String, Object> retMap=new HashMap<String,Object>();
		List<Integer> list = new ArrayList<Integer>();
		if (ids.contains(",")) {
			String[] arrId = ids.split(",");
			List<String> idList = Arrays.asList(arrId);
			for (String tmp : idList) {
				list.add(Integer.valueOf(tmp));
			}
		}else{
			list.add(Integer.valueOf(ids));
		}
		if("enable".equals(status)){
			status="Y";
		}else{
			status="N";
		}
		retMap.put("list", list);
		retMap.put("status",status);
		return sysUserDAO.updateUserStatus(retMap);
	}

}
