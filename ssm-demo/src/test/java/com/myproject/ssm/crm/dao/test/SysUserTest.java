package com.myproject.ssm.crm.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.dal.SysUserDAO;
import com.myproject.ssm.crm.dal.common.object.SysUserDOWithBLOBs;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:configs/spring/spring-mybatis.xml" })
public class SysUserTest {
	
	@Autowired
	private SysUserDAO sysUserDAO;	
	
	@Test
	public void testQueryById(){
		SysUserDOWithBLOBs sysUser=sysUserDAO.selectByPrimaryKey(7);
		System.out.println(sysUser.getBeginDate());
	}
	
}
