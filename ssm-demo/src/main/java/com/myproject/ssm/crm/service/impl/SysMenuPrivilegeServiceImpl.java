package com.myproject.ssm.crm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.myproject.ssm.crm.common.domain.SysMenuKey;
import com.myproject.ssm.crm.dal.SysMenuDAO;
import com.myproject.ssm.crm.dal.SysMenuPrivilegeDAO;
import com.myproject.ssm.crm.dal.common.object.SysMenuDO;
import com.myproject.ssm.crm.dal.common.object.SysMenuPrivilegeDO;
import com.myproject.ssm.crm.service.SysMenuPrivilegeService;
import com.myproject.ssm.crm.service.common.enums.MenuModuleEnum;
import com.myproject.ssm.crm.service.common.model.SysMenuPrivilegeModel;
import com.myproject.ssm.crm.service.common.model.SysRoleModel;
import com.myproject.ssm.utils.CollectionDataUtils;

/**
 * 菜单权限，对应页面上：操作权限组的可访问菜单设置
 * 
 * @author win7
 *
 */
@Service("SysMenuPrivilegeService")
public class SysMenuPrivilegeServiceImpl implements SysMenuPrivilegeService {

	private Logger LOGGER = LoggerFactory.getLogger(SysMenuPrivilegeServiceImpl.class);
	@Autowired
	private SysMenuPrivilegeDAO sysMenuPrivilegeDAO;
	@Autowired
	private SysMenuDAO sysMenuDAO;

	/**
	 * 
	 */
	@Override
	public List<SysMenuPrivilegeModel> findAllSysMenuPrivileges() {
		List<SysMenuPrivilegeDO> sysMenuPrivilegeDOs = sysMenuPrivilegeDAO.findAllSysMenuPrivileges();

		List<SysMenuPrivilegeModel> sysMenuPrivilegeList = new ArrayList<SysMenuPrivilegeModel>();
		// Collections.copy(sysMenuPrivilegeList, sysMenuPrivilegeDOs);
		SysMenuPrivilegeModel sysMenuPrivilegeModel = null;
		SysMenuKey sysMenuKey = null;
		for (SysMenuPrivilegeDO priDO : sysMenuPrivilegeDOs) {
			sysMenuPrivilegeModel = new SysMenuPrivilegeModel();
			sysMenuKey = new SysMenuKey();
			sysMenuKey.setMenuModule(priDO.getMenuModule());
			sysMenuKey.setMenuPrivilege(priDO.getMenuPrivilege());
			sysMenuPrivilegeModel.setSysMenuKey(sysMenuKey);
			sysMenuPrivilegeModel.setRoleId(priDO.getRoleId());
			sysMenuPrivilegeList.add(sysMenuPrivilegeModel);
		}
		return sysMenuPrivilegeList;
	}

	/**
	 * 
	 */
	@Override
	public List<SysMenuPrivilegeModel> findById(String sid) {
		List<SysMenuPrivilegeDO> DOs = sysMenuPrivilegeDAO.queryById(sid);
		if (CollectionUtils.isEmpty(DOs)) {
			// 根据roleId查询结果为空
		}
		List<SysMenuPrivilegeModel> models = new ArrayList<SysMenuPrivilegeModel>();
		SysMenuKey sysMenuKey = null;
		SysMenuPrivilegeModel model = null;
		for (SysMenuPrivilegeDO temp : DOs) {
			sysMenuKey = new SysMenuKey();
			model = new SysMenuPrivilegeModel();
			sysMenuKey.setMenuModule(temp.getMenuModule());
			sysMenuKey.setMenuPrivilege(temp.getMenuPrivilege());
			model.setSysMenuKey(sysMenuKey);
			model.setRoleId(temp.getRoleId());
			models.add(model);
		}
		return models;
	}

	/**
	 * 
	 */
	@Override
	public int updateMenuPrivilege(SysRoleModel model, String roleId, String menuModule) {
		// 对参数做判空校验
		if (StringUtils.isBlank(roleId)) {
			// 系统异常
			LOGGER.error(roleId + "用户为空，系统异常");
			return -1;
		}
		if (StringUtils.isBlank(menuModule)) {
			// 目录的模块不能为空，返回前端
			LOGGER.error(roleId + "用户的目录模块不能为空，请重试");
			throw new NullPointerException();
		}
		// 转换list
		List<SysMenuPrivilegeDO> sysMenuPrivlist = CollectionDataUtils.menuArr2List(new SysMenuPrivilegeDO(), roleId,
				menuModule);
		// 根据roleId先从数据库查询相关目录权限，为空表示这个角色一个权限都没有可以直接插入现在的数据
		// 若不空，则对比看哪些是数据库里没有的新加的，重复的不用管，新加的加入数据库即可。
		List<SysMenuPrivilegeDO> existMenuPrivs = sysMenuPrivilegeDAO.queryById(roleId);
		int i = 0;// 执行insert操作的数量
		try {
			if (CollectionUtils.isEmpty(existMenuPrivs)) {
				// 数据库没有该role的权限数据，直接新增这些权限到DB
				i = sysMenuPrivilegeDAO.insertMenuPrivList(sysMenuPrivlist);
			} else {
				// 这里的操作权限组中的可访问菜单update的数据和数据库原有数据比较有多种可能，纯粹的新增；纯粹的删除；新增中有删除，删除中有新增
				Map<String, String> newaddMap = new HashMap<String, String>();// 存放新增目录权限映射关系
				Map<String, String> existMenuMap = new HashMap<String, String>();// 当前存在的目录权限映射关系
				List<SysMenuPrivilegeDO> removingList = new ArrayList<SysMenuPrivilegeDO>();// 要删除的数据
				List<SysMenuPrivilegeDO> newAddList = new ArrayList<SysMenuPrivilegeDO>();// 要新增的数据

				for (SysMenuPrivilegeDO tmp : sysMenuPrivlist) {
					StrEqualsMethod(newaddMap, tmp);
				}

				for (SysMenuPrivilegeDO tmp : existMenuPrivs) {
					StrEqualsMethod(existMenuMap, tmp);
				}
				// 获取数据库所有module和privilege，可以新建个方法只获取menu主键
				List<SysMenuDO> allMenus = sysMenuDAO.findAllSysMenus();
				Set<String> allModules = new HashSet<String>();
				for (SysMenuDO tmp : allMenus) {
					allModules.add(tmp.getMenuModule());
				}
				List<String> enumList = new ArrayList<String>();
				for (MenuModuleEnum tmp : MenuModuleEnum.values()) {
					enumList.add(tmp.name());
				}
				// 遍历目录所有模块和权限映射关系
				for (String menuMod : allModules) {
					for (String enumStr : enumList) {
						if (StringUtils.equals(enumStr, menuMod)) {
							menuPrivDataHandle(roleId, enumStr, newaddMap, existMenuMap, menuMod, newAddList,
									removingList, sysMenuPrivlist, existMenuPrivs);
						}
					}
					/*
					 * if (StringUtils.equals(MenuModuleEnum.company.name(),
					 * menuMod)) { // new和exist都有的模块,在具体比较privilege
					 * menuPrivDataHandle(roleId, MenuModuleEnum.company.name(),
					 * newaddMap, existMenuMap, menuMod, newAddList,
					 * removingList, sysMenuPrivlist, existMenuPrivs); } else if
					 * (StringUtils.equals(MenuModuleEnum.report.getValue(),
					 * menuMod)) { // new有，exist没有的模块，说明有新增的模块
					 * menuPrivDataHandle(roleId, MenuModuleEnum.report.name(),
					 * newaddMap, existMenuMap, menuMod, newAddList,
					 * removingList, sysMenuPrivlist, existMenuPrivs); } else if
					 * (StringUtils.equals(MenuModuleEnum.sys.getValue(),
					 * menuMod)) { // new没有，exist有的模块 menuPrivDataHandle(roleId,
					 * MenuModuleEnum.sys.name(), newaddMap, existMenuMap,
					 * menuMod, newAddList, removingList, sysMenuPrivlist,
					 * existMenuPrivs); } else { // 同时没有的模块，不予考虑 }
					 */
				}
			}
		} catch (Exception e) {
			LOGGER.error("SysMenuPrivilegeServiceImpl | updateMenuPrivilege方法  向数据库新增目录权限发生异常：" + roleId + ",异常为:" + e);
		}
		return i;
	}

	/**
	 * 
	 * @param strMap
	 * @param tmp
	 */
	private void StrEqualsMethod(Map<String, String> strMap, SysMenuPrivilegeDO tmp) {
		if (StringUtils.equals(MenuModuleEnum.company.name(), tmp.getMenuModule())) {
			strMap.put(MenuModuleEnum.company.name(), tmp.getMenuModule());
		} else if (StringUtils.equals(MenuModuleEnum.report.name(), tmp.getMenuModule())) {
			strMap.put(MenuModuleEnum.report.name(), tmp.getMenuModule());
		} else if (StringUtils.equals(MenuModuleEnum.sys.name(), tmp.getMenuModule())) {
			strMap.put(MenuModuleEnum.sys.name(), tmp.getMenuModule());
		} else {
			// 不存在
		}
	}

	/**
	 * 
	 * @param roleId
	 * @param moduleEnumStr
	 * @param newaddMap
	 * @param existMenuMap
	 * @param menuMod
	 * @param newAddList
	 * @param removingList
	 * @param sysMenuPrivlist
	 * @param existMenuPrivs
	 */
	private void menuPrivDataHandle(String roleId, String moduleEnumStr, Map<String, String> newaddMap,
			Map<String, String> existMenuMap, String menuMod, List<SysMenuPrivilegeDO> newAddList,
			List<SysMenuPrivilegeDO> removingList, List<SysMenuPrivilegeDO> sysMenuPrivlist,
			List<SysMenuPrivilegeDO> existMenuPrivs) {

		SysMenuPrivilegeDO sysMenuPrivilegeDO = null;
		int i = 0;
		// sysMenuPrivlist,existMenuPrivs =====> newAddList,removingList
		if (StringUtils.isNotBlank(newaddMap.get(moduleEnumStr))
				&& StringUtils.isNotBlank(existMenuMap.get(moduleEnumStr))) {
			//
			// 目录权限的示例图：
			// 从页面上新加入的目录模块里的权限 原来拥有的目录权限
			// sysMenuPrivlist menuPrivMap
			// newADD exist
			// 空 1
			// 2 空
			// 3 3
			// 4 空
			// 空 5
			// 空 6
			//
			// 操作思路 :
			// 1.比如上图原来有的权限现在也有就不用动，比如3
			// 2.原来有现在没有的就要删除这个权限，比如1，5，6
			// 3.原来没有现在新加就要新建到数据库里，比如2，4
			//
			// 获取数据库的目录权限映射,对比的是原先数据库没有的目录权限，所以都是新增的
			Map<String, String> menuPrivMap = menuPrivMap(existMenuPrivs, moduleEnumStr);
			for (SysMenuPrivilegeDO tmp : sysMenuPrivlist) {
				if (StringUtils.isBlank(menuPrivMap.get(tmp.getMenuPrivilege()))
						&& StringUtils.equals(tmp.getMenuModule(), moduleEnumStr)) {
					sysMenuPrivilegeDO = new SysMenuPrivilegeDO();
					sysMenuPrivilegeDO.setRoleId(roleId);
					sysMenuPrivilegeDO.setMenuModule(tmp.getMenuModule());
					sysMenuPrivilegeDO.setMenuPrivilege(tmp.getMenuPrivilege());
					newAddList.add(sysMenuPrivilegeDO);
				}
			}
			// 构造新增加的目录权限映射，对比的是数据库已有的而没有新增的，所以是要删除的
			menuPrivMap = menuPrivMap(sysMenuPrivlist, moduleEnumStr);
			List<String> privileges = new ArrayList<String>();
			for (SysMenuPrivilegeDO tmp : existMenuPrivs) {
				if (StringUtils.isBlank(menuPrivMap.get(tmp.getMenuPrivilege()))
						&& StringUtils.equals(tmp.getMenuModule(), moduleEnumStr)) {
					sysMenuPrivilegeDO = new SysMenuPrivilegeDO();
					sysMenuPrivilegeDO.setRoleId(roleId);
					sysMenuPrivilegeDO.setMenuModule(tmp.getMenuModule());
					sysMenuPrivilegeDO.setMenuPrivilege(tmp.getMenuPrivilege());
					removingList.add(sysMenuPrivilegeDO);
					// 注明：这里要删除的list元素是同一个module下的不同privilege
					// privileges.add(tmp.getMenuPrivilege());
				}
			}

			// 该方法暂时不用
			if (!CollectionUtils.isEmpty(privileges)) {
				sysMenuPrivilegeDO = new SysMenuPrivilegeDO();
				sysMenuPrivilegeDO.setRoleId(roleId);
				sysMenuPrivilegeDO.setMenuModule(moduleEnumStr);
				// sysMenuPrivilegeDO.setMenuPrivileges(privileges);
				i = sysMenuPrivilegeDAO.deleteByPrimaryKey(sysMenuPrivilegeDO);
				LOGGER.info("使用简化方法1对" + roleId + "用户的" + moduleEnumStr + "模块下的目录权限执行批量删除操作，成功执行：" + i + "条数据");
			}

			// 执行批量删除操作
			if (!CollectionUtils.isEmpty(removingList)) {
				i = sysMenuPrivilegeDAO.delMenuPrivileges(removingList);
				removingList.clear();
				LOGGER.info("对" + roleId + "用户的" + moduleEnumStr + "模块下的目录权限执行批量删除操作，成功执行：" + i + "条数据");
			}
		} else if (StringUtils.isNotBlank(newaddMap.get(moduleEnumStr))
				&& StringUtils.isBlank(existMenuMap.get(moduleEnumStr))) {
			//  该模块完全新增一个module,是新增模块，说明整个整个模块之前是没有的，里面具体的privilege也就都是新增的了
			for (SysMenuPrivilegeDO tmp : sysMenuPrivlist) {
				if (moduleEnumStr.equals(tmp.getMenuModule())) {
					sysMenuPrivilegeDO = new SysMenuPrivilegeDO();
					sysMenuPrivilegeDO.setRoleId(roleId);
					sysMenuPrivilegeDO.setMenuModule(tmp.getMenuModule());
					sysMenuPrivilegeDO.setMenuPrivilege(tmp.getMenuPrivilege());
					// 调用sysMenuPrivilegeDAO的新增方法，把新的目录权限模块新增落库
					newAddList.add(sysMenuPrivilegeDO);
				}
			}
		} else if (StringUtils.isBlank(newaddMap.get(moduleEnumStr))
				&& StringUtils.isNotBlank(existMenuMap.get(moduleEnumStr))) {
			// 该模块完全删除一个module,是删除的模块
			sysMenuPrivilegeDO = new SysMenuPrivilegeDO();
			sysMenuPrivilegeDO.setRoleId(roleId);
			sysMenuPrivilegeDO.setMenuModule(menuMod);
			// 调用sysMenuPrivilegeDAO的删除方法，可以根据roleId和menuModule去删除
			i = sysMenuPrivilegeDAO.deleteByPrimaryKey(sysMenuPrivilegeDO);
			LOGGER.info("对" + roleId + "用户的" + moduleEnumStr + "模块下的目录权限执行删除整个模块操作，成功执行：" + i + "条数据");
		} else {
			// company模块都没有，不予以考虑
		}
		// removingList,newAddList
		if (!CollectionUtils.isEmpty(newAddList)) {
			i = sysMenuPrivilegeDAO.insertMenuPrivList(newAddList);
			newAddList.clear();
			LOGGER.info("对" + roleId + "用户的" + moduleEnumStr + "模块执行批量新增目录权限操作，成功执行：" + i + "条数据");
		}
	}

	/**
	 * 
	 * @param MenuPrivilegeList
	 * @param moduleEnumName
	 * @return
	 */
	private Map<String, String> menuPrivMap(List<SysMenuPrivilegeDO> MenuPrivilegeList, String moduleEnumName) {
		// 无需判断list为空
		Map<String, String> menuPrivMap = new HashMap<String, String>();
		for (SysMenuPrivilegeDO tmp : MenuPrivilegeList) {
			if (StringUtils.equals(moduleEnumName, tmp.getMenuModule())) {
				menuPrivMap.put(tmp.getMenuPrivilege(), tmp.getMenuPrivilege());
			}
		}
		return menuPrivMap;
	}

}
