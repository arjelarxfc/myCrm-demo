package com.myproject.ssm.crm.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.dal.SysMenuPrivilegeDAO;
import com.myproject.ssm.crm.dal.common.object.SysMenuPrivilegeDO;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:configs/spring/applicationContext.xml" })
public class SysMenuPrivilegeTest {

	@Autowired
	private SysMenuPrivilegeDAO sysMenuPrivilegeDAO;

	@Test
	public void testQueryById() {
		List<SysMenuPrivilegeDO> privilegeIdDOs = sysMenuPrivilegeDAO.queryById("");
		System.out.println(privilegeIdDOs.size());
	}
}