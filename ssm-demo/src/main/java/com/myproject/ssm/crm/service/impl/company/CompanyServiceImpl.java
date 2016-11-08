package com.myproject.ssm.crm.service.impl.company;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.ssm.crm.common.domain.ReportBean;
import com.myproject.ssm.crm.dal.SysUserDAO;
import com.myproject.ssm.crm.dal.common.object.CompanyDO;
import com.myproject.ssm.crm.dal.common.object.SysUserDOWithBLOBs;
import com.myproject.ssm.crm.dal.company.CompanyDAO;
import com.myproject.ssm.crm.service.common.model.CompanyModel;
import com.myproject.ssm.crm.service.common.model.SysUserModel;
import com.myproject.ssm.crm.service.company.CompanyService;

@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private SysUserDAO sysUserDAO;
	
	
	public List<CompanyModel> getCompanysCondition(CompanyModel companyModel){
		Map<String,Object> retMap=new HashMap<String,Object>();
		if(companyModel.getSysUserModel()!=null){
			retMap.put("sysUserId", companyModel.getSysUserModel().getId());
		}
		if(StringUtils.isNotBlank(companyModel.getCode())){
			retMap.put("code", companyModel.getCode());
		}
		if(StringUtils.isNotBlank(companyModel.getName())){
			retMap.put("name", companyModel.getName());
		}
		if(StringUtils.isNotBlank(companyModel.getPycode())){
			retMap.put("pycode", companyModel.getPycode());
		}
		if(StringUtils.isNotBlank(companyModel.getTel1())){
			retMap.put("tel1", companyModel.getTel1());
		}
		if(StringUtils.isNotBlank(companyModel.getSource())){
			retMap.put("source", companyModel.getSource());
		}
		if(StringUtils.isNotBlank(companyModel.getGrade())){
			retMap.put("grade", companyModel.getGrade());
		}
		if(StringUtils.isNotBlank(companyModel.getQuality())){
			retMap.put("quality", companyModel.getQuality());
		}
		
		List<CompanyDO> list = companyDAO.getCompanysCondition(retMap);
		//对象转换
		List<CompanyModel> models=new ArrayList<CompanyModel>();
		CompanyModel comModel=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SysUserDOWithBLOBs sysUserDO=null;
		//忽略的属性nextTouchDate ownerUser
		String[] ingoredStr={"nextTouchDate","ownerUser"};
		//sysUser忽略的属性
		String[] ignoreProperties={"beginDate","endDate","birthday","workDate","finishSchoolDate"};
		SysUserModel sysUserModel=null;
		for(CompanyDO tmp:list){
			comModel=new CompanyModel();
			BeanUtils.copyProperties(tmp, comModel, ingoredStr);
			if(tmp.getNextTouchDate()!=null){
				comModel.setNextTouchDate(sdf.format(tmp.getNextTouchDate()));
			}
			//设置sysUserModel对象
			sysUserDO = sysUserDAO.selectByPrimaryKey(tmp.getOwnerUser());
			sysUserModel=new SysUserModel();
			BeanUtils.copyProperties(sysUserDO, sysUserModel, ignoreProperties);
			if(sysUserDO.getBeginDate()!=null){
				sysUserModel.setBeginDate(sdf.format(sysUserDO.getBeginDate()));
			}
			if(sysUserDO.getEndDate()!=null){
				sysUserModel.setEndDate(sdf.format(sysUserDO.getEndDate()));
			}
			if(sysUserDO.getBirthday()!=null){
				sysUserModel.setBirthday(sdf.format(sysUserDO.getBirthday()));
			}
			if(sysUserDO.getWorkDate()!=null){
				sysUserModel.setWorkDate(sdf.format(sysUserDO.getWorkDate()));
			}
			if(sysUserDO.getFinishSchoolDate()!=null){
				sysUserModel.setFinishSchoolDate(sdf.format(sysUserDO.getFinishSchoolDate()));
			}
			comModel.setSysUserModel(sysUserModel);
			models.add(comModel);
		}
		return models;
	}
	
	
	public List<ReportBean> getReportBeans(){
		List<ReportBean> list = companyDAO.getReportBeans();
		return list;
	}
	
}
