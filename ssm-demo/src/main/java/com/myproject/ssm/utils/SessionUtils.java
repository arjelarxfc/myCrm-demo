package com.myproject.ssm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.myproject.ssm.crm.service.common.model.SysUserModel;
public class SessionUtils {
	
	public static void setSysUserToSession(HttpServletRequest request,SysUserModel sysUserModel) {
		if(sysUserModel==null){
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("sysUserKey", sysUserModel);
	}
	
	
	public static SysUserModel getSysUserFormSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session==null){
			return null;
		}
		return (SysUserModel) session.getAttribute("sysUserKey");
	}
	
}
