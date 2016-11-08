package com.myproject.ssm.crm.service;

import java.util.List;

import com.myproject.ssm.crm.service.common.model.SysMenuModel;

public interface SysMenuService {

	List<SysMenuModel> findAllSysMenus();

}
