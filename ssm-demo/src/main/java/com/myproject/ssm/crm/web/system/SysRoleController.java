package com.myproject.ssm.crm.web.system;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.myproject.ssm.crm.service.SysMenuPrivilegeService;
import com.myproject.ssm.crm.service.SysMenuService;
import com.myproject.ssm.crm.service.SysPopedomPrivilegeService;
import com.myproject.ssm.crm.service.SysPopedomService;
import com.myproject.ssm.crm.service.SysRoleService;
import com.myproject.ssm.crm.service.common.model.SysMenuModel;
import com.myproject.ssm.crm.service.common.model.SysMenuPrivilegeModel;
import com.myproject.ssm.crm.service.common.model.SysPopedomModel;
import com.myproject.ssm.crm.service.common.model.SysPopedomPrivilegeModel;
import com.myproject.ssm.crm.service.common.model.SysRoleModel;

@Controller
public class SysRoleController {

	private Logger LOGGER = LoggerFactory.getLogger(SysRoleController.class);

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysMenuService sysMenuService;

	@Autowired
	private SysMenuPrivilegeService sysMenuPrivilegeService;

	@Autowired
	private SysPopedomService sysPopedomService;

	@Autowired
	private SysPopedomPrivilegeService sysPopedomPrivilegeService;

	/**
	 * 操作权限组是系统设置子菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/crm/sys/role/list", method = RequestMethod.GET)
	public String sysRoleList(Model model, @Param("loginname") String loginname) {
		List<SysRoleModel> list = sysRoleService.getAllRoles();
		if (CollectionUtils.isEmpty(list)) {
			LOGGER.error("SysSettingController sysRoleList|list is null");
		}
		model.addAttribute("sysRoles", list);
		return "page/sys/role/list";
	}

	/**
	 * 新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "crm/sys/role/addpage", method = RequestMethod.GET)
	public String roleAddPage() {
		return "page/sys/role/add";
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "crm/sys/role/add", method = RequestMethod.POST)
	public ModelAndView roleAdd(HttpServletResponse response, @ModelAttribute SysRoleModel model) {
		int i = sysRoleService.roleAdd(model);
		LOGGER.info("SysRoleController || roleAdd 创建一个新的角色" + i);
		return new ModelAndView("redirect:/crm/sys/role/list");
	}

	/**
	 * 跳转更新页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/role/edit", method = RequestMethod.GET)
	public String groupEditPage(String id, Model model) {
		SysRoleModel role = sysRoleService.getRoleById(id);
		model.addAttribute("role", role);
		return "page/sys/role/edit";
	}

	/**
	 * 更新指定角色
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/role/update", method = RequestMethod.POST)
	public ModelAndView roleUpdate(HttpServletResponse response, @ModelAttribute SysRoleModel model) {
		int i = sysRoleService.roleUpdate(model);
		LOGGER.info("SysRoleController || roleUpdate 更新指定角色:" + i);
		return new ModelAndView("redirect:/crm/sys/role/list");
	}

	/**
	 * 可批量删除选定的角色
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/role/delete", method = RequestMethod.POST)
	public ModelAndView groupDel(HttpServletResponse response, @Param("ids") String ids) {
		int i = sysRoleService.deleteRole(ids);
		LOGGER.info("SysRoleController || groupDel 可批量删除选定的角色:" + i);
		return new ModelAndView("redirect:/crm/sys/role/list");
	}

	/**
	 * 
	 * @param response
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "crm/sys/role/listMenu", method = RequestMethod.GET)
	public String listMenu(Model model, HttpServletResponse response, @Param("roleId") String roleId) {
		List<SysMenuModel> sysMenus = sysMenuService.findAllSysMenus();
		List<SysMenuPrivilegeModel> sysMenuPrivileges = sysMenuPrivilegeService.findById(roleId);
		SysRoleModel sysRole = sysRoleService.getRoleById(roleId);
		model.addAttribute("sysRole", sysRole);
		model.addAttribute("sysMenus", sysMenus);
		model.addAttribute("sysMenuPrivileges", sysMenuPrivileges);
		return "page/sys/role/menu/view";
	}

	/**
	 * 操作权限组的修改指定权限组它可访问的菜单
	 * 
	 * @param response
	 * @param popedomModule
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/role/updateMenuPrivilege", method = RequestMethod.POST)
	public ModelAndView updateMenuPrivilege(HttpServletResponse response, @Param("menuModule") String menuModule,
			@ModelAttribute SysRoleModel model, String roleId) {
		// 返回更新条数
		int i=0;
		i = sysMenuPrivilegeService.updateMenuPrivilege(model, roleId, menuModule);
		LOGGER.info("SysRoleController || updateMenuPrivilege 更新指定权限组它可访问的菜单条数：" + i);
		return new ModelAndView("redirect:/crm/sys/role/listMenu?roleId=" + roleId);
	}

	/**
	 * 
	 * @param response
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "crm/sys/role/listPopedom", method = RequestMethod.GET)
	public String listPopedom(Model model, HttpServletResponse response, @Param("roleId") String roleId) {
		List<SysPopedomModel> allPopedoms = sysPopedomService.selectAllPopedoms();
		List<SysPopedomPrivilegeModel> popedomPrivileges = sysPopedomPrivilegeService
				.selectPopedomPrivilegeByRoleId(roleId);
		SysRoleModel sysRole = sysRoleService.getRoleById(roleId);
		model.addAttribute("sysPopedoms", allPopedoms);
		model.addAttribute("sysPopedomPriviles", popedomPrivileges);
		model.addAttribute("sysRole", sysRole);
		return "page/sys/role/popedom/view";
	}

	/**
	 * 操作权限组对具体模块下的具体权限的认证操作
	 * 
	 * @param response
	 * @param popedomModule
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "crm/sys/role/updatePopedom", method = RequestMethod.POST)
	public ModelAndView updatePopedom(HttpServletResponse response, @Param("popedomModule") String popedomModule,
			@ModelAttribute SysRoleModel model, String id) {
		int i=0;
		i=sysPopedomPrivilegeService.updatePopedom(id,popedomModule);
		LOGGER.info("SysRoleController || updatePopedom 更新指定权限组模块下的具体权限：" + i);
		
		return new ModelAndView("redirect:/crm/sys/role/listPopedom?roleId=" + id);
	}
}
