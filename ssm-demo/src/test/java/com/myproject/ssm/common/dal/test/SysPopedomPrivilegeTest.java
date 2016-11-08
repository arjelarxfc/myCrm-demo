package com.myproject.ssm.common.dal.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.dal.SysPopedomPrivilegeDAO;
import com.myproject.ssm.crm.dal.common.object.SysPopedomPrivilegeDO;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:configs/spring/spring-mybatis.xml" })
public class SysPopedomPrivilegeTest {

	@Autowired
	private SysPopedomPrivilegeDAO popedomPrivilegeDAO;

	@Test
	public void testQueryPrivileges() {

		List<SysPopedomPrivilegeDO> popdomPrivilegs = popedomPrivilegeDAO.selectAllPopedomPrivileges();
		for (SysPopedomPrivilegeDO key : popdomPrivilegs) {
			System.out.println(key.getPopedomPrivilege() + "----" + key.getPopedomModule());
		}

	}

}
