package com.myproject.ssm.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringProviderCore {

	protected ApplicationContext context;

	public void load(String filename) {
		context = new ClassPathXmlApplicationContext(filename);
	}
}
