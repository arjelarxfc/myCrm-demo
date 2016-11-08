package com.myproject.ssm.crm.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.dal.SysUserGroupDAO;
import com.myproject.ssm.crm.dal.common.object.SysUserGroupDO;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:configs/spring/spring-mybatis.xml" })
public class SysUserGroupTest {
	
	@Autowired
	private SysUserGroupDAO sysUserGroupDAO;
	
	@Test
	public void testQueryById(){
		SysUserGroupDO sysUserGroup=sysUserGroupDAO.selectByPrimaryKey(21);
		System.out.println(sysUserGroup.getRemark());
		
		
	}
	
	
	
	
}
