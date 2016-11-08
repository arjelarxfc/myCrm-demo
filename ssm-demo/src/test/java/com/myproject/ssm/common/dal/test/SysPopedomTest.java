package com.myproject.ssm.common.dal.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.common.domain.SysPopedomKey;
import com.myproject.ssm.crm.dal.SysPopedomDAO;
import com.myproject.ssm.crm.dal.common.object.SysPopedomDO;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:configs/spring/spring-mybatis.xml" })
public class SysPopedomTest {

	@Autowired
	private SysPopedomDAO sysPopedomDAO;

	@Test
	public void testQuerySysPopedom() {
		SysPopedomKey key=new SysPopedomKey();
		key.setPopedomModule("group");
		key.setPopedomPrivilege("add");
		SysPopedomDO popedom = sysPopedomDAO.selectByPrimaryKey(key);
		System.out.println(popedom.getPopedomName());
	}
	
	
	
}
