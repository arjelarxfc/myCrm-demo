package com.myproject.ssm.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.ssm.crm.common.domain.SysMenuKey;
import com.myproject.ssm.crm.dal.SysMenuDAO;
import com.myproject.ssm.crm.dal.common.object.SysMenuDO;
import com.myproject.ssm.crm.service.SysMenuService;
import com.myproject.ssm.crm.service.common.model.SysMenuModel;

@Service("SysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	
	@Autowired
	private SysMenuDAO sysMenuDAO;
	
	@Override
	public List<SysMenuModel> findAllSysMenus() {
		
		List<SysMenuDO> sysMenuDOs=sysMenuDAO.findAllSysMenus();
		List<SysMenuModel> sysMenuModels=new ArrayList<SysMenuModel>();
		SysMenuModel sysMenuModel=null;
		SysMenuKey sysMenuKey=null;
		for(SysMenuDO sysMenuDO:sysMenuDOs){
			sysMenuModel=new SysMenuModel();
			sysMenuKey=new SysMenuKey();
			BeanUtils.copyProperties(sysMenuDO, sysMenuModel);
			sysMenuKey.setMenuModule(sysMenuDO.getMenuModule());
			sysMenuKey.setMenuPrivilege(sysMenuDO.getMenuPrivilege());
			sysMenuModel.setSysMenuKey(sysMenuKey);

			sysMenuModels.add(sysMenuModel);
		}
		
		return sysMenuModels;
	}

}
