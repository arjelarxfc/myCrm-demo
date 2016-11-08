package com.myproject.ssm.crm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.myproject.ssm.crm.common.domain.SysPopedomKey;
import com.myproject.ssm.crm.dal.SysPopedomDAO;
import com.myproject.ssm.crm.dal.SysPopedomPrivilegeDAO;
import com.myproject.ssm.crm.dal.common.object.SysPopedomPrivilegeDO;
import com.myproject.ssm.crm.service.SysPopedomPrivilegeService;
import com.myproject.ssm.crm.service.common.enums.PopedomModuleEnum;
import com.myproject.ssm.crm.service.common.model.SysPopedomPrivilegeModel;
import com.myproject.ssm.utils.CollectionDataUtils;

@Service("SysPopedomPrivilegeService")
public class SysPopedomPrivilegeServiceImpl implements SysPopedomPrivilegeService {

	private Logger LOGGER = LoggerFactory.getLogger(SysPopedomPrivilegeServiceImpl.class);

	@Autowired
	private SysPopedomPrivilegeDAO sysPopedomPrivilegeDAO;
	@Autowired
	private SysPopedomDAO sysPopedomDAO;

	@Override
	public int deleteByPrimaryKey(SysPopedomPrivilegeModel key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysPopedomPrivilegeModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysPopedomPrivilegeModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysPopedomPrivilegeModel> selectAllPopedomPrivileges() {
		return null;
	}

	@Override
	public List<SysPopedomPrivilegeModel> selectPopedomPrivilegeByRoleId(String roleId) {
		List<SysPopedomPrivilegeDO> keyList = sysPopedomPrivilegeDAO.selectPopedomPrivilegeByRoleid(roleId);
		if (CollectionUtils.isEmpty(keyList)) {
			// 没有roleid下的值
		}
		List<SysPopedomPrivilegeModel> models = new ArrayList<SysPopedomPrivilegeModel>();
		SysPopedomPrivilegeModel model = null;
		SysPopedomKey key = null;
		for (SysPopedomPrivilegeDO temp : keyList) {
			model = new SysPopedomPrivilegeModel();
			key = new SysPopedomKey();
			//
			key.setPopedomModule(temp.getPopedomModule());
			key.setPopedomPrivilege(temp.getPopedomPrivilege());
			model.setRoleId(temp.getRoleId());
			model.setSysPopedomKey(key);

			models.add(model);
		}
		return models;
	}

	@Override
	public int updatePopedom(String id, String popedomModule) {
		if (StringUtils.isBlank(id)) {
			// 系统异常
			LOGGER.error("SysPopedomPrivilegeServiceImpl | updatePopedom" + id + "用户为空，系统异常");
			return -1;
		}
		if (StringUtils.isBlank(popedomModule)) {
			// 目录的模块不能为空，返回前端
			LOGGER.error("SysPopedomPrivilegeServiceImpl | updatePopedom" + id + "用户的 权限模块 不能为空，请重试");
			throw new NullPointerException();
		}
		final String roleId = id;
		// 转换list
		List<SysPopedomPrivilegeDO> sysPopePrivList = CollectionDataUtils.menuArr2List(new SysPopedomPrivilegeDO(),
				roleId, popedomModule);
		// 查询出已存在的权限
		List<SysPopedomPrivilegeDO> existPopePrivs = sysPopedomPrivilegeDAO.selectPopedomPrivilegeByRoleid(roleId);
		int i = 0;// 执行insert操作的数量
		try {
			if (CollectionUtils.isEmpty(existPopePrivs)) {
				// 数据库没有该role的权限数据，直接新增这些权限到DB
				i = sysPopedomPrivilegeDAO.insertPopePrivList(sysPopePrivList);
				LOGGER.info("SysPopedomPrivilegeServiceImpl | updatePopedom 对" + roleId + "用户新增这些权限 ：" + i + "条数据");
			} else {
				// 这里的操作权限组中的可访问菜单update的数据和数据库原有数据比较有多种可能，纯粹的新增；纯粹的删除；新增中有删除，删除中有新增
				Map<String, String> newaddMap = new HashMap<String, String>();// 存放新增目录权限映射关系
				Map<String, String> existPopeMap = new HashMap<String, String>();// 当前存在的目录权限映射关系
				List<SysPopedomPrivilegeDO> removingList = new ArrayList<SysPopedomPrivilegeDO>();// 要删除的数据
				List<SysPopedomPrivilegeDO> newAddList = new ArrayList<SysPopedomPrivilegeDO>();// 要新增的数据
				//
				for (SysPopedomPrivilegeDO tmp : sysPopePrivList) {
					StrEqualsMethod(newaddMap, tmp);
				}

				for (SysPopedomPrivilegeDO tmp : existPopePrivs) {
					StrEqualsMethod(existPopeMap, tmp);
				}
				// 获取操作权限表sys_popedom的所有module
				List<String> allModules = sysPopedomDAO.findAllModules();
				// 操作权限的枚举值放到list中
				List<String> enumList = new ArrayList<String>();
				for (PopedomModuleEnum tmp : PopedomModuleEnum.values()) {
					enumList.add(tmp.getKey());
				}
				// 遍历目录所有模块和权限映射关系
				for (String popeModule : allModules) {
					for (String enumStr : enumList) {
						if (StringUtils.equals(enumStr, popeModule)) {
							popedomPrivDataHandle(roleId, enumStr, newaddMap, existPopeMap, popeModule, newAddList,
									removingList, sysPopePrivList, existPopePrivs);
						}
					}
				}

			}
		} catch (Exception e) {
			LOGGER.error("SysPopedomPrivilegeServiceImpl |updatePopedom方法  向数据库新增目录权限发生异常：" + roleId + ",异常为:" + e);
		}

		return i;
	}

	/**
	 * 
	 * @param roleId
	 * @param enumStr
	 * @param newaddMap
	 * @param existPopeMap
	 * @param menuMod
	 * @param newAddList
	 * @param removingList
	 * @param sysPopePrivList
	 * @param existPopePrivs
	 */
	private void popedomPrivDataHandle(String roleId, String enumStr, Map<String, String> newaddMap,
			Map<String, String> existPopeMap, String popeModule, List<SysPopedomPrivilegeDO> newAddList,
			List<SysPopedomPrivilegeDO> removingList, List<SysPopedomPrivilegeDO> sysPopePrivList,
			List<SysPopedomPrivilegeDO> existPopePrivs) {

		SysPopedomPrivilegeDO popePrivDO = null;
		int i = 0;
		if (StringUtils.isNotBlank(newaddMap.get(enumStr)) && StringUtils.isNotBlank(existPopeMap.get(enumStr))) {
			// 获取数据库的目录权限映射,对比的是原先数据库没有的目录权限，所以都是新增的
			Map<String, String> popePrivMap = menuPrivMap(existPopePrivs, enumStr);
			for (SysPopedomPrivilegeDO tmp : sysPopePrivList) {
				if (StringUtils.isBlank(popePrivMap.get(tmp.getPopedomPrivilege()))
						&& StringUtils.equals(tmp.getPopedomModule(), enumStr)) {
					popePrivDO = new SysPopedomPrivilegeDO();
					popePrivDO.setRoleId(roleId);
					popePrivDO.setPopedomModule(tmp.getPopedomModule());
					popePrivDO.setPopedomPrivilege(tmp.getPopedomPrivilege());
					newAddList.add(popePrivDO);
				}
			}
			// 构造新增加的目录权限映射，对比的是数据库已有的而没有新增的，所以是要删除的
			popePrivMap = menuPrivMap(sysPopePrivList, enumStr);
			for (SysPopedomPrivilegeDO tmp : existPopePrivs) {
				if (StringUtils.isBlank(popePrivMap.get(tmp.getPopedomPrivilege()))
						&& StringUtils.equals(tmp.getPopedomModule(), enumStr)) {
					popePrivDO = new SysPopedomPrivilegeDO();
					popePrivDO.setRoleId(roleId);
					popePrivDO.setPopedomModule(tmp.getPopedomModule());
					popePrivDO.setPopedomPrivilege(tmp.getPopedomPrivilege());
					removingList.add(popePrivDO);
				}
			}
			// 执行批量删除操作
			if (!CollectionUtils.isEmpty(removingList)) {
				i = sysPopedomPrivilegeDAO.delPopedomPrivileges(removingList);
				removingList.clear();
				LOGGER.info("SysPopedomPrivilegeServiceImpl | updatePopedom 对" + roleId + "用户的" + enumStr
						+ "模块下的权限 执行批量删除操作，成功执行：" + i + "条数据");
			}
		} else if (StringUtils.isNotBlank(newaddMap.get(enumStr)) && StringUtils.isBlank(existPopeMap.get(enumStr))) {
			// 该模块完全新增一个module,是新增模块，说明整个整个模块之前是没有的，里面具体的privilege也就都是新增的了
			for (SysPopedomPrivilegeDO tmp : sysPopePrivList) {
				if (enumStr.equals(tmp.getPopedomModule())) {
					popePrivDO = new SysPopedomPrivilegeDO();
					popePrivDO.setRoleId(roleId);
					popePrivDO.setPopedomModule(tmp.getPopedomModule());
					popePrivDO.setPopedomPrivilege(tmp.getPopedomPrivilege());
					// 放到集合中批量操作，把新的目录权限模块新增落库
					newAddList.add(popePrivDO);
				}
			}
		} else if (StringUtils.isBlank(newaddMap.get(enumStr)) && StringUtils.isNotBlank(existPopeMap.get(enumStr))) {
			// 该模块完全删除一个module,是删除的模块
			popePrivDO = new SysPopedomPrivilegeDO();
			popePrivDO.setRoleId(roleId);
			popePrivDO.setPopedomModule(popeModule);
			// 调用sysPopedomPrivilegeDAO的删除方法，可以根据roleId和menuModule去删除
			i = sysPopedomPrivilegeDAO.deleteByPrimaryKey(popePrivDO);
			LOGGER.info("SysPopedomPrivilegeServiceImpl | updatePopedom 对" + roleId + "用户的" + enumStr
					+ "模块下的权限 执行删除整个模块操作，成功执行：" + i + "条数据");
		} else {
			// company模块都没有，不予以考虑
		}
		// removingList,newAddList
		if (!CollectionUtils.isEmpty(newAddList)) {
			i = sysPopedomPrivilegeDAO.insertPopePrivList(newAddList);
			newAddList.clear();
			LOGGER.info("SysPopedomPrivilegeServiceImpl | updatePopedom 对" + roleId + "用户的" + enumStr
					+ "权限模块执行批量新增目录权限操作，成功执行：" + i + "条数据");
		}

	}

	private Map<String, String> menuPrivMap(List<SysPopedomPrivilegeDO> existPopePrivs, String enumStr) {
		// 无需判断list为空
		Map<String, String> popePrivMap = new HashMap<String, String>();
		for (SysPopedomPrivilegeDO tmp : existPopePrivs) {
			if (StringUtils.equals(enumStr, tmp.getPopedomModule())) {
				popePrivMap.put(tmp.getPopedomPrivilege(), tmp.getPopedomPrivilege());
			}
		}
		return popePrivMap;
	}

	private void StrEqualsMethod(Map<String, String> strMap, SysPopedomPrivilegeDO tmp) {
		if (StringUtils.equals(PopedomModuleEnum.company.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.company.getKey(), tmp.getPopedomModule());
		} else if (StringUtils.equals(PopedomModuleEnum.report.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.report.getKey(), tmp.getPopedomModule());
		} else if (StringUtils.equals(PopedomModuleEnum.city.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.city.getKey(), tmp.getPopedomModule());
		} else if (StringUtils.equals(PopedomModuleEnum.code.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.code.getKey(), tmp.getPopedomModule());
		} else if (StringUtils.equals(PopedomModuleEnum.group.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.group.getKey(), tmp.getPopedomModule());
		} else if (StringUtils.equals(PopedomModuleEnum.linkman.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.linkman.getKey(), tmp.getPopedomModule());
		} else if (StringUtils.equals(PopedomModuleEnum.linktouch.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.linktouch.getKey(), tmp.getPopedomModule());
		} else if (StringUtils.equals(PopedomModuleEnum.province.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.province.getKey(), tmp.getPopedomModule());
		} else if (StringUtils.equals(PopedomModuleEnum.role.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.role.getKey(), tmp.getPopedomModule());
		} else if (StringUtils.equals(PopedomModuleEnum.rule.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.rule.getKey(), tmp.getPopedomModule());
		} else if (StringUtils.equals(PopedomModuleEnum.user.getKey(), tmp.getPopedomModule())) {
			strMap.put(PopedomModuleEnum.user.getKey(), tmp.getPopedomModule());
		} else {
			// 不存在
		}
	}

}
