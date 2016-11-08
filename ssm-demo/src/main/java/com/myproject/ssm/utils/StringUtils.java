package com.myproject.ssm.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.myproject.ssm.crm.dal.common.object.SysMenuPrivilegeDO;

public class StringUtils {
	
	public void strSplitDemo(){
		String menuModule="company,company,company,linkTouch,report,report,report,khfx,sys,sys,sys,code";
		List<String> strList=Arrays.asList(menuModule.split(","));
		List<SysMenuPrivilegeDO> list=new ArrayList<SysMenuPrivilegeDO>();
		SysMenuPrivilegeDO menuPriv=null;
		int index=0;
		for(String menuStr:strList){
			if(index%2==0){
				menuPriv=new SysMenuPrivilegeDO();
				menuPriv.setMenuModule(menuStr);
				menuPriv.setRoleId("aaaaa");
			}else{
				menuPriv.setMenuPrivilege(menuStr);
				list.add(menuPriv);
			}
			index++;
		}
		System.out.println(list.size()+"对数据");
		for(SysMenuPrivilegeDO tmp:list){
			System.out.println(tmp.getRoleId()+"---"+tmp.getMenuModule()+"------"+tmp.getMenuPrivilege());
		}
	}
	
	public static void main(String[] args) {
		StringUtils strUtils=new StringUtils();
		strUtils.strSplitDemo();
	}
}
