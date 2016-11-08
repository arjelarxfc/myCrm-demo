package com.myproject.ssm.crm.service.company;

import java.util.List;

import com.myproject.ssm.crm.common.domain.ReportBean;
import com.myproject.ssm.crm.service.common.model.CompanyModel;

public interface CompanyService {
	
	/**
	 * 当前的登陆用户和查询条件
	 * @param companyModel
	 * @return
	 */
	public List<CompanyModel> getCompanysCondition(CompanyModel companyModel);
	
	/**
	 * 为报表分析获取客户分类情况
	 * @return
	 */
	public List<ReportBean> getReportBeans();
}
