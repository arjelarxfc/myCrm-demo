package com.myproject.ssm.crm.web.report;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.ssm.crm.common.domain.ReportBean;
import com.myproject.ssm.crm.service.company.CompanyService;
import com.myproject.ssm.crm.web.company.CustomerController;

@Controller
public class ReportController {

	private Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/report/company/customerAnalysis", method = RequestMethod.GET)
	public String reportBean(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<ReportBean> beans = companyService.getReportBeans();
		if (CollectionUtils.isEmpty(beans)) {
			LOGGER.error("CustomerController customerList|beans is null");
		}
		model.addAttribute("reportBeans", beans);
		// 计算合计的客户数量
		Long count = 0L;
		for (ReportBean bean : beans) {
			count += bean.getCount();
		}
		model.addAttribute("sum", count);

		return "page/report/khflfxReport";
	}
	
	
	
}
