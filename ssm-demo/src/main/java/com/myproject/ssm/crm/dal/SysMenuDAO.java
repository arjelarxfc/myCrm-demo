package com.myproject.ssm.crm.dal;

import java.util.List;

import com.myproject.ssm.crm.common.domain.SysMenuKey;
import com.myproject.ssm.crm.dal.common.object.SysMenuDO;

public interface SysMenuDAO {
	
    int deleteByPrimaryKey(SysMenuKey key);

    int insert(SysMenuDO record);

    int insertSelective(SysMenuDO record);

    SysMenuDO selectByPrimaryKey(SysMenuKey key);

    int updateByPrimaryKeySelective(SysMenuDO record);

    int updateByPrimaryKeyWithBLOBs(SysMenuDO record);

    int updateByPrimaryKey(SysMenuDO record);

	List<SysMenuDO> findAllSysMenus();
}