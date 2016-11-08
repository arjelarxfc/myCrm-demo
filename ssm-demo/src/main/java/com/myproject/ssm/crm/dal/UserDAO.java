package com.myproject.ssm.crm.dal;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.ssm.crm.dal.common.object.UserDO;

@Repository
public interface UserDAO {
	
    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKeyWithBLOBs(UserDO record);

    int updateByPrimaryKey(UserDO record);
    
    List<UserDO> queryAllUsers();
}