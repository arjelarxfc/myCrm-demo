package com.myproject.ssm.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringProvider {
	
	private static Logger LOGGER =LoggerFactory.getLogger(SpringProvider.class);
	
	private static SpringProviderCore core;
	static{
		core=new SpringProviderCore();
		core.load("configs/spring/applicationContext.xml");
	}
	
	public static Object getBean(String beanName){
		if(StringUtils.isBlank(beanName)){
			LOGGER.error("SpringProvider getBean|the beanname:"+beanName+" is null!");
		}
		Object bean=null;
		if(core.context.containsBean(beanName)){
			bean=core.context.getBean(beanName);
		}
		if(bean==null){
			LOGGER.error("SpringProvider getBean|the bean:"+bean+"is NOT exits!");
		}
		return bean;
	}
	
	
	
}
