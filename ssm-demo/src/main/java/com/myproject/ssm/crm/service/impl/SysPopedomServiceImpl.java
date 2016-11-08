package com.myproject.ssm.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.ssm.crm.common.domain.SysPopedomKey;
import com.myproject.ssm.crm.dal.SysPopedomDAO;
import com.myproject.ssm.crm.dal.common.object.SysPopedomDO;
import com.myproject.ssm.crm.service.SysPopedomService;
import com.myproject.ssm.crm.service.common.model.SysPopedomModel;

@Service("SysPopedomService")
public class SysPopedomServiceImpl implements SysPopedomService {

	@Autowired
	private SysPopedomDAO sysPopedomDAO;

	@Override
	public List<SysPopedomModel> selectAllPopedoms() {
		List<SysPopedomDO> allPopedoms = sysPopedomDAO.selectAllPopedoms();
		SysPopedomModel model = null;
		List<SysPopedomModel> models = new ArrayList<SysPopedomModel>();
		String[] ignoreProperties = { "sort", "sysPopedomKey" };
		SysPopedomKey sysPopedomKey = null;
		for (SysPopedomDO tmp : allPopedoms) {
			model = new SysPopedomModel();
			sysPopedomKey = new SysPopedomKey();
			sysPopedomKey.setPopedomModule(tmp.getPopedomModule());
			sysPopedomKey.setPopedomPrivilege(tmp.getPopedomPrivilege());
			BeanUtils.copyProperties(tmp, model, ignoreProperties);
			model.setSort(String.valueOf(tmp.getSort()));
			//
			model.setSysPopedomKey(sysPopedomKey);
			models.add(model);
		}
		return models;
	}

}
