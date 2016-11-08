package com.myproject.ssm.crm.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {

	String module();//模块名称

	String privilege();//权限名称

}
