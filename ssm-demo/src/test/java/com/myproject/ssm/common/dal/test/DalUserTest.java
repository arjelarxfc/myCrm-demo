package com.myproject.ssm.common.dal.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.dal.UserDAO;
import com.myproject.ssm.crm.dal.common.object.UserDO;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:configs/spring/spring-mybatis.xml"})
public class DalUserTest {
	
	private static Logger logger = Logger.getLogger(DalUserTest.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void testQueryById(){
		UserDO userDO=userDAO.selectByPrimaryKey(5);
		System.out.println(userDO.getId()+"----"+userDO.getUsername());
	}
	
}
