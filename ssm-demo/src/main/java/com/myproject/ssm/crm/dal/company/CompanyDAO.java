package com.myproject.ssm.crm.dal.company;

import java.util.List;
import java.util.Map;

import com.myproject.ssm.crm.common.domain.ReportBean;
import com.myproject.ssm.crm.dal.common.object.CompanyDO;

public interface CompanyDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyDO record);

    int insertSelective(CompanyDO record);

    CompanyDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyDO record);

    int updateByPrimaryKeyWithBLOBs(CompanyDO record);

    int updateByPrimaryKey(CompanyDO record);
    
    /**
     * 当前的登陆用户和查询条件
     * @param sysUser
     * @param company
     * @return
     */
    List<CompanyDO> getCompanysCondition(Map<String, Object> retMap);
    
    /**
     * 为报表分析获取客户分类情况
     * @return
     */
    List<ReportBean> getReportBeans();
    
}