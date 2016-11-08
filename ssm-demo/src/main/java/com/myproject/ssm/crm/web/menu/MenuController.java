package com.myproject.ssm.crm.web.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.ssm.crm.service.SysMenuService;
import com.myproject.ssm.crm.service.common.model.SysMenuModel;

@Controller
public class MenuController {
	
	private Logger LOGGER =LoggerFactory.getLogger(MenuController.class);
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping(value = "/crm/sys/menuActionTop", method = RequestMethod.GET)
	public String menuActionTop() {
		return "page/menu/top";
	}

	@RequestMapping(value = "/crm/sys/menuActionLeft", method = RequestMethod.GET)
	public String menuActionLeft(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<SysMenuModel> sysMenus = sysMenuService.findAllSysMenus();
		model.addAttribute("sysMenus", sysMenus);
		return "page/menu/left";
	}
	
	@RequestMapping(value = "/crm/sys/menuActionCenter", method = RequestMethod.GET)
	public String menuActionCenter(){
		return "page/menu/center";
	}
}