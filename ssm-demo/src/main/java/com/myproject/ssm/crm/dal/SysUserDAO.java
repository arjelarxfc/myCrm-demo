package com.myproject.ssm.crm.dal;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myproject.ssm.crm.dal.common.object.SysUserDO;
import com.myproject.ssm.crm.dal.common.object.SysUserDOWithBLOBs;

public interface SysUserDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserDOWithBLOBs record);

    int insertSelective(SysUserDOWithBLOBs record);

    SysUserDOWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserDOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysUserDOWithBLOBs record);

    int updateByPrimaryKey(SysUserDO record);

	SysUserDO findSysUserByNameAndPassword(@Param("name") String name, @Param("pwd") String password);

	List<SysUserDO> getAllSysUsers();

	int deleteSysUsers(List<Integer> list);

	int updateUserStatus(Map<String, Object> retMap);
}