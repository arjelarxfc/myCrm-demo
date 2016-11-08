package com.myproject.ssm.crm.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.dal.SysRoleDAO;
import com.myproject.ssm.crm.dal.common.object.SysRoleDO;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:configs/spring/spring-mybatis.xml" })
public class SysRoleTest {
	
	@Autowired
	private SysRoleDAO sysRoleDAO;
	
	@Test
	public void testQueryById(){
		
		SysRoleDO sysRole=sysRoleDAO.selectByPrimaryKey("402881e43250ee0b013250eee1450002");
		System.out.println(sysRole.getRemark());
	}
	
}
