package com.myproject.ssm.crm.web.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.ssm.crm.service.common.model.CompanyModel;
import com.myproject.ssm.crm.service.company.CompanyService;

@Controller
public class CustomerController {

	private Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/crm/company/list", method = RequestMethod.GET)
	public String customerList(HttpServletRequest request, HttpServletResponse response, Model model) {
		CompanyModel companyModel = new CompanyModel();
		List<CompanyModel> list = companyService.getCompanysCondition(companyModel);
		if (CollectionUtils.isEmpty(list)) {
			LOGGER.error("CustomerController customerList|CompanyModels is null");
		}
		model.addAttribute("companyList", list);
		return "page/customer/base/list";
	}

	@RequestMapping(value = "/crm/customer/linkman/view", method = RequestMethod.GET)
	public String linkman() {
		return "page/customer/linkman/view";
	}

	@RequestMapping(value = "/crm/customer/linktouch/view", method = RequestMethod.GET)
	public String linktouch() {
		return "page/customer/linktouch/view";
	}

	@RequestMapping(value = "/crm/customer/rule/rule", method = RequestMethod.GET)
	public String rule() {
		return "page/customer/rule/rule";
	}

	@RequestMapping(value = "/crm/company/edit", method = RequestMethod.GET)
	public String cstmEdit(@Param("companyId") String companyId) {
		System.out.println("companyId:"+companyId);
		return "page/customer/base/edit";
	}
	
	@RequestMapping(value = "/crm/company/add", method = RequestMethod.GET)
	public String cstmAddPage() {
		return "page/customer/base/add";
	}
	
	@RequestMapping(value = "/crm/company/nextTouchTime", method = RequestMethod.GET)
	public String nextTouchTimePg(@Param("ids") String ids) {
		System.out.println("ids:"+ids);
		return "page/customer/base/nextTouchTime";
	}
	
	@RequestMapping(value = "/crm/company/showShareSetOne", method = RequestMethod.GET)
	public String showShareSetOne(@Param("id") String id) {
		System.out.println("id:"+id);
		return "page/customer/base/shareSetOne";
	}
	
	@RequestMapping(value = "/crm/company/changePerson", method = RequestMethod.GET)
	public String changePerson(@Param("ids") String ids) {
		System.out.println("ids:"+ids);
		return "page/customer/base/changePerson";
	}

}
