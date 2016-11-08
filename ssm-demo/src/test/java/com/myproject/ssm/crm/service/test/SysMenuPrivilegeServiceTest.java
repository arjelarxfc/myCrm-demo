package com.myproject.ssm.crm.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.service.SysMenuPrivilegeService;
import com.myproject.ssm.crm.service.common.model.SysMenuPrivilegeModel;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:configs/spring/applicationContext.xml" })
public class SysMenuPrivilegeServiceTest {
	
	@Autowired
	private SysMenuPrivilegeService sysMenuPrivilegeService;
	
	@Test
	public void testQueryAll(){
		List<SysMenuPrivilegeModel> list = sysMenuPrivilegeService.findAllSysMenuPrivileges();
		System.out.println(list.size());
		
	}
	
	
}
