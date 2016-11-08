package com.myproject.ssm.crm.web.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SysSettingController {

	private Logger LOGGER = LoggerFactory.getLogger(SysSettingController.class);

	
	/**
	 * 系统设置的城市资料URL
	 * @return
	 */
	@RequestMapping(value = "/crm/sys/city/list", method = RequestMethod.GET)
	public String cityList() {
		return "page/sys/city/list";
	}

	/**
	 * 系统设置的编码规则URL
	 * @return
	 */
	@RequestMapping(value = "/crm/sys/code/list", method = RequestMethod.GET)
	public String codeRuleList() {
		return "page/sys/code/list";
	}

	/**
	 * 系统设置的省份资料URL
	 * @return
	 */
	@RequestMapping(value = "/crm/sys/province/list", method = RequestMethod.GET)
	public String provinceList() {
		return "page/sys/province/list";
	}

	
	
}
