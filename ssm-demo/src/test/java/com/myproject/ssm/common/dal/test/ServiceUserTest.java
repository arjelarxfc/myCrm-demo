package com.myproject.ssm.common.dal.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.ssm.crm.service.UserService;
import com.myproject.ssm.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:configs/spring/spring-mvc.xml"})
public class ServiceUserTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testServiceQueryById(){
		UserModel userModel=userService.queryById(6);
		System.out.println(userModel.getId()+"-----"+userModel.getUsername());
	}
	
}
