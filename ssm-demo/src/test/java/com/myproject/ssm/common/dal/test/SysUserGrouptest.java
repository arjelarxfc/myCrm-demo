package com.myproject.ssm.common.dal.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.dal.SysUserGroupDAO;
import com.myproject.ssm.crm.dal.common.object.SysUserGroupDO;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:configs/spring/spring-mybatis.xml" })
public class SysUserGrouptest {
	
	@Autowired
	private SysUserGroupDAO sysUserGroupDAO;
	
	@Test
	public void testGetGroupsByName(){
		String name="市场部";
		List<SysUserGroupDO> list = sysUserGroupDAO.getSysUserGroups(name);
		for(SysUserGroupDO tmp:list){
			System.out.println(tmp.getPrincipal());
		}
	}
	
	@Test
	public void testGetGroupsById(){
		Integer id=20;
		SysUserGroupDO tmp= sysUserGroupDAO.selectByPrimaryKey(id);
			System.out.println(tmp.getPrincipal());
	}
	
	
}
