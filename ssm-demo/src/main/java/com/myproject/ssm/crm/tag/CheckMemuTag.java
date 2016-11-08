package com.myproject.ssm.crm.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.ssm.crm.service.SysMenuPrivilegeService;
import com.myproject.ssm.crm.service.common.model.SysMenuPrivilegeModel;
import com.myproject.ssm.crm.service.common.model.SysUserModel;
import com.myproject.ssm.utils.SessionUtils;
import com.myproject.ssm.utils.SpringProvider;

public class CheckMemuTag implements SimpleTag {

	private Logger LOGGER=LoggerFactory.getLogger(CheckMemuTag.class);
	
	@Autowired
	private SysMenuPrivilegeService sysMenuPrivilegeService;
	//xfc
	private PageContext pageContext;
	private JspFragment jspFragment;

	// <itcast:checkMemu module="${sysMenu.sysMenuKey.menuModule}"
	// privilege="${sysMenu.sysMenuKey.menuPrivilege}">
	private String module;
	private String privilege;


	public void doTag() throws JspException, IOException {
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		
		//使用SimpleTag这个调用doTag方法时，来不及给service使用注解方式注入对象，所以使用配置文件方式手动为对象获取对象的bean
		sysMenuPrivilegeService = (SysMenuPrivilegeService) SpringProvider.getBean("SysMenuPrivilegeService");
		
		SysUserModel sysUser = SessionUtils.getSysUserFormSession(request);
		if (sysUser == null) {
			LOGGER.error("sysUser is null");
			return;
		}

		if (sysUser.getSysRoleModel() == null) {
			LOGGER.error("SysRole is null");
			return;
		}

		String roleId = sysUser.getSysRoleModel().getId();

		List<SysMenuPrivilegeModel> list = sysMenuPrivilegeService.findAllSysMenuPrivileges();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				SysMenuPrivilegeModel s = list.get(i);
				if (StringUtils.isNotBlank(roleId) && StringUtils.isNotBlank(module)
						&& StringUtils.isNotBlank(privilege)) {
					if (roleId.equals(s.getRoleId()) && module.equals(s.getSysMenuKey().getMenuModule())
							&& privilege.equals(s.getSysMenuKey().getMenuPrivilege())) {
						this.jspFragment.invoke(null);
						break;
					}
				}
			}
		}
	}

	public JspTag getParent() {
		return null;
	}

	public void setJspBody(JspFragment jspFragment) {
		this.jspFragment = jspFragment;
	}

	public void setJspContext(JspContext pc) {
		this.pageContext = (PageContext) pc;
	}

	public void setParent(JspTag arg0) {
	}

	public void setModule(String module) {
		this.module = module;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

}
