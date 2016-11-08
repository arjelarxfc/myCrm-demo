package com.myproject.ssm.crm.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.common.domain.SysMenuKey;
import com.myproject.ssm.crm.dal.SysMenuDAO;
import com.myproject.ssm.crm.dal.common.object.SysMenuDO;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:configs/spring/spring-mybatis.xml" })
public class SysMenuTest {
	
	@Autowired
	private SysMenuDAO sysMenuDAO;
	
	@Test
	public void testQueryId(){
		SysMenuKey key=new SysMenuKey();
		key.setMenuModule("company");
		key.setMenuPrivilege("base");
		SysMenuDO sysMenuDO=sysMenuDAO.selectByPrimaryKey(key);
		System.out.println(sysMenuDO.getMenuName());
		
		
		
	}
	
}
