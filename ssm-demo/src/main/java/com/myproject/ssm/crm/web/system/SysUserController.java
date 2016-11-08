package com.myproject.ssm.crm.web.system;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.ssm.crm.service.SysRoleService;
import com.myproject.ssm.crm.service.SysUserGroupService;
import com.myproject.ssm.crm.service.SysUserService;
import com.myproject.ssm.crm.service.common.model.SysRoleModel;
import com.myproject.ssm.crm.service.common.model.SysUserGroupModel;
import com.myproject.ssm.crm.service.common.model.SysUserModel;
import com.myproject.ssm.utils.MD5keyBean;
import com.myproject.ssm.utils.SessionUtils;

@Controller
public class SysUserController {

	private Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysRoleService SysRoleService;

	@Autowired
	private SysUserGroupService sysUserGroupService;

	@RequestMapping(value = "crm/login", method = RequestMethod.GET)
	public String crm() {
		return "page/login";// wxf283416379
	}

	@RequestMapping(value = "crm/sys/sysUserLogin", method = RequestMethod.POST)
	public String sysUserLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		MD5keyBean md5 = new MD5keyBean();
		pwd = md5.getkeyBeanofStr(pwd);
		System.out.println(name + "---" + pwd);

		SysUserModel sysUserModel = sysUserService.findSysUserByNameAndPassword(name, pwd);
		if (sysUserModel == null) {
			LOGGER.error("there's no sysUser");
			return "page/login";
		}
		SessionUtils.setSysUserToSession(request, sysUserModel);
		addCookie(name, request.getParameter("password"), response, request);

		return "page/menu/main";
	}

	// 增加cookie方法
	private void addCookie(String name, String pwd, HttpServletResponse response, HttpServletRequest request) {
		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(pwd)) {
			try {
				Cookie nameCookie = new Cookie("name", URLEncoder.encode(name, "utf-8"));
				Cookie pwdCookie = new Cookie("pwd", pwd);
				nameCookie.setPath(request.getContextPath() + "/");
				pwdCookie.setPath(request.getContextPath() + "/");
				if (StringUtils.isBlank(request.getParameter("rememberMe"))) {
					nameCookie.setMaxAge(0);
					pwdCookie.setMaxAge(0);
				} else {
					nameCookie.setMaxAge(24 * 60 * 60);
					pwdCookie.setMaxAge(24 * 60 * 60);
				}
				response.addCookie(nameCookie);
				response.addCookie(pwdCookie);
			} catch (UnsupportedEncodingException e) {
				LOGGER.error("unsupported Encoding", e);
			}
		}
	}

	/**
	 * 人事管理是系统设置子菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/crm/sys/user/list", method = RequestMethod.GET)
	public String sysUserList(Model model) {
		List<SysUserModel> list = sysUserService.getAllSysUsers();
		if (CollectionUtils.isEmpty(list)) {
			LOGGER.error("SysSettingController sysUserList|list is null");
		}
		model.addAttribute("sysUsers", list);
		return "page/sys/user/list";
	}

	/**
	 * 跳转添加页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "crm/sys/user/addpage", method = RequestMethod.GET)
	public String userAddpage() {
		return "page/sys/user/add";
	}

	/**
	 * 跳转更新页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/user/edit", method = RequestMethod.GET)
	public String userEditPage(String id, Model model) {
		SysUserModel sysUserModel = sysUserService.getUserById(id);
		if (sysUserModel == null) {
			LOGGER.error("查询的用户这个用户数据库不存在，id=" + id);
			model.addAttribute("sysUser", new SysUserModel());
		} else {
			model.addAttribute("sysUser", sysUserModel);
		}
		return "page/sys/user/edit";
	}

	/**
	 * ajax返回添加的获取所有的操作权限组
	 * 
	 * @return
	 */
	@RequestMapping(value = "crm/sys/user/json/sysRoleSelect", method = RequestMethod.GET)
	public @ResponseBody List<SysRoleModel> sysRoleSelect() {
		List<SysRoleModel> roles = null;
		roles = SysRoleService.getAllRoles();
		if (CollectionUtils.isEmpty(roles)) {
			LOGGER.error("roles is empty.");
			return new ArrayList<SysRoleModel>();
		}
		return roles;
	}

	/**
	 * ajax返回添加的获取所有的部门
	 * 
	 * @return
	 */
	@RequestMapping(value = "crm/sys/user/json/sysUserGroupSelect", method = RequestMethod.GET)
	public @ResponseBody List<SysUserGroupModel> sysUserGroupSelect() {
		List<SysUserGroupModel> models = sysUserGroupService.getGroups(null);
		if (CollectionUtils.isEmpty(models)) {
			LOGGER.error("models is empty.");
			return new ArrayList<SysUserGroupModel>();
		}
		return models;
	}

	/**
	 * 创建一个新系统用户，并且指定部门和所具有的操作权限
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/user/add", method = RequestMethod.POST)
	public ModelAndView sysUserAdd(HttpServletResponse response, @ModelAttribute SysUserModel sysUserModel,
			@Param("sysRoleId") String sysRoleId, @Param("sysUserGroupId") String sysUserGroupId) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("sysUserModel", sysUserModel);
		retMap.put("sysRoleId", sysRoleId);
		retMap.put("sysUserGroupId", sysUserGroupId);
		int i = sysUserService.sysUserAdd(retMap);
		LOGGER.info("创建一个新系统用户" + i);
		return new ModelAndView("redirect:/crm/sys/user/list");
	}

	/**
	 * update一个系统用户
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/user/update", method = RequestMethod.POST)
	public ModelAndView sysUserUpdate(HttpServletResponse response, @ModelAttribute SysUserModel sysUserModel,
			@Param("sysRoleId") String sysRoleId, @Param("sysUserGroupId") String sysUserGroupId) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("sysUserModel", sysUserModel);
		retMap.put("sysRoleId", sysRoleId);
		retMap.put("sysUserGroupId", sysUserGroupId);
		int i = sysUserService.sysUserUpdate(retMap);
		LOGGER.info("更新指定系统用户" + i);
		return new ModelAndView("redirect:/crm/sys/user/list");
	}
	
	/**
	 * 删除一个系统用户
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/user/delete", method = RequestMethod.POST)
	public ModelAndView sysUserDel(@Param("ids") String ids) {
		int i = sysUserService.sysUserDel(ids);
		LOGGER.info("更新指定系统用户"+i);
		return new ModelAndView("redirect:/crm/sys/user/list");
	}
	
	/**
	 * 启用系统用户
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/user/enable", method = RequestMethod.POST)
	public ModelAndView sysUserEnable(@Param("ids") String ids) {
		int i = sysUserService.sysUserStatus(ids,"enable");
		LOGGER.info("更新指定系统用户"+i);
		return new ModelAndView("redirect:/crm/sys/user/list");
	}
	
	/**
	 * 停用系统用户
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/user/disable", method = RequestMethod.POST)
	public ModelAndView sysUserDisable(@Param("ids") String ids) {
		int i = sysUserService.sysUserStatus(ids,"disable");
		LOGGER.info("更新指定系统用户"+i);
		return new ModelAndView("redirect:/crm/sys/user/list");
	}
	
}
