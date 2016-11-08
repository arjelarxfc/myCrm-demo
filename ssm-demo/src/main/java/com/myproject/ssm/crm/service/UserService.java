package com.myproject.ssm.crm.service;

import java.util.List;

import com.myproject.ssm.model.UserModel;

public interface UserService {

	UserModel queryById(int i);

	List<UserModel> querAllUsers();

}
