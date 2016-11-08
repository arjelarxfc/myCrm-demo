package com.myproject.ssm.crm.web.system;

import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.myproject.ssm.crm.service.SysUserGroupService;
import com.myproject.ssm.crm.service.common.model.SysUserGroupModel;

@Controller
public class GroupController {

	private Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

	@Autowired
	private SysUserGroupService sysUserGroupService;

	/**
	 * 获取所有系统部门
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/crm/sys/group/list")
	public String sysGroupList(@Param("name") String name, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		List<SysUserGroupModel> groups = null;
		if (StringUtils.isBlank(name)) {
			groups = sysUserGroupService.getGroups(null);
		} else {
			groups = sysUserGroupService.getGroups(name);
		}
		if (CollectionUtils.isEmpty(groups)) {
			LOGGER.error("SysSettingController sysGroupList|groups is null");
		}
		model.addAttribute("sysUserGroups", groups);
		return "page/sys/group/list";
	}

	/**
	 * 新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "crm/sys/group/addpage", method = RequestMethod.GET)
	public String groupAddPage() {
		return "page/sys/group/add";
	}

	/**
	 * 跳转到更新页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "crm/sys/group/edit", method = RequestMethod.GET)
	public String groupEditPage(String id, Model model) {
		SysUserGroupModel group = sysUserGroupService.getGroupById(Integer.valueOf(id));
		model.addAttribute("group", group);
		return "page/sys/group/edit";
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "crm/sys/group/usersInGroup", method = RequestMethod.GET)
	public String usersInGroup(String id, Model model) {
		SysUserGroupModel group = sysUserGroupService.getGroupById(Integer.valueOf(id));
		model.addAttribute("group", group);
		return "page/sys/group/edit";
	}

	/**
	 * 创建一个新的部门
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/group/add", method = RequestMethod.POST)
	public ModelAndView groupAdd(HttpServletResponse response, @ModelAttribute SysUserGroupModel model) {
		int i = sysUserGroupService.groupAdd(model);
		LOGGER.info("创建一个新的部门" + i);
		return new ModelAndView("redirect:/crm/sys/group/list");
	}

	/**
	 * 更新指定部门
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/group/update", method = RequestMethod.POST)
	public ModelAndView groupUpdate(HttpServletResponse response, @ModelAttribute SysUserGroupModel model) {
		int i = sysUserGroupService.groupUpdate(model);
		LOGGER.info("更新指定部门:" + i);
		return new ModelAndView("redirect:/crm/sys/group/list");
	}

	/**
	 * 可批量删除选定的部门
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/group/delete", method = RequestMethod.POST)
	public ModelAndView groupDel(HttpServletResponse response, @Param("ids") String ids) {
		int i = sysUserGroupService.deleteGroup(ids);
		LOGGER.info("可批量删除选定的部门:" + i);
		return new ModelAndView("redirect:/crm/sys/group/list");
	}

}
