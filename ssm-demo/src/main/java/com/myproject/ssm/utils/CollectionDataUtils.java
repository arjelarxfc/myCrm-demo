package com.myproject.ssm.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.myproject.ssm.crm.common.domain.SysMenuKey;
import com.myproject.ssm.crm.dal.common.object.SysMenuPrivilegeDO;
import com.myproject.ssm.crm.dal.common.object.SysPopedomPrivilegeDO;

public class CollectionDataUtils<E> {

	/**
	 * 
	 * @param roleId
	 * @param menuModule
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <E> List<E> menuArr2List(E privilegeModel, String roleId, String menuModule) {
		// 参数：company,company,company,linkTouch,report,report,report,khfx,sys,sys,sys,code
		List<String> strList = Arrays.asList(menuModule.split(","));
		List<E> list = new ArrayList<E>();
		int index = 0;
		if (privilegeModel instanceof SysMenuPrivilegeDO) {
			for (String menuStr : strList) {
				if (index % 2 == 0) {
					privilegeModel = (E) new SysMenuPrivilegeDO();
					((SysMenuPrivilegeDO) privilegeModel).setRoleId(roleId);
					((SysMenuPrivilegeDO) privilegeModel).setMenuModule(menuStr);
				} else {
					((SysMenuKey) privilegeModel).setMenuPrivilege(menuStr);
					list.add(privilegeModel);
				}
				index++;
			}
		} else if (privilegeModel instanceof SysPopedomPrivilegeDO) {
			for (String pri : strList) {
				if (index % 2 == 0) {
					privilegeModel = (E) new SysPopedomPrivilegeDO();
					((SysPopedomPrivilegeDO) privilegeModel).setRoleId(roleId);
					((SysPopedomPrivilegeDO) privilegeModel).setPopedomModule(pri);
				} else {
					((SysPopedomPrivilegeDO) privilegeModel).setPopedomPrivilege(pri);
					list.add(privilegeModel);
				}
				index++;
			}
		} else {

		}
		return list;
	}

	// main方法
	public static void main(String[] args) {

	}

}

class CollectionData<T> extends ArrayList<T> {

}