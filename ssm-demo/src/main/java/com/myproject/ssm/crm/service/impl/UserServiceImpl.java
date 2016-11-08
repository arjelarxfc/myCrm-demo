package com.myproject.ssm.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.myproject.ssm.crm.dal.UserDAO;
import com.myproject.ssm.crm.dal.common.object.UserDO;
import com.myproject.ssm.crm.service.UserService;
import com.myproject.ssm.model.UserModel;

@Service("UserService")
public class UserServiceImpl implements UserService {

	private Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserModel queryById(int id) {
		UserModel userModel = new UserModel();
		UserDO userDO = userDAO.selectByPrimaryKey(id);
		if (userDO != null) {
			userModel.setCardId(userDO.getCardId());
			userModel.setPassword(userDO.getPassword());
			userModel.setAge(String.valueOf(userDO.getAge()));
			userModel.setUsername(userDO.getUsername());
			userModel.setUserInfo(userDO.getUserInfo());
			userModel.setState(userDO.getState());
		} else {
			if(LOGGER.isInfoEnabled()){
				LOGGER.info("��ѯ����Ϊ�ա�");
			}
		}
		return userModel;

	}

	@Override
	public List<UserModel> querAllUsers() {
		List<UserModel> userModels=new ArrayList<UserModel>();
		List<UserDO> userDOs=userDAO.queryAllUsers();
		if(CollectionUtils.isEmpty(userDOs)){
			if(LOGGER.isInfoEnabled()){
				LOGGER.info("user��Ϊ��");
			}
		}else{
			UserModel userModel=null;
			for(UserDO tmp:userDOs){
				userModel=new UserModel();
				userModel.setCardId(tmp.getCardId());
				userModel.setId(tmp.getId());
				userModel.setUsername(tmp.getUsername());
				userModel.setState(tmp.getState());
				
				userModels.add(userModel);
			}
		}
		return userModels;
	}

}
