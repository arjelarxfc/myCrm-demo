package com.myproject.ssm.crm.dal;

import java.util.List;

import com.myproject.ssm.crm.common.domain.SysPopedomKey;
import com.myproject.ssm.crm.dal.common.object.SysPopedomDO;

public interface SysPopedomDAO {
    int deleteByPrimaryKey(SysPopedomKey key);

    int insert(SysPopedomDO record);

    int insertSelective(SysPopedomDO record);

    SysPopedomDO selectByPrimaryKey(SysPopedomKey key);

    int updateByPrimaryKeySelective(SysPopedomDO record);

    int updateByPrimaryKeyWithBLOBs(SysPopedomDO record);

    int updateByPrimaryKey(SysPopedomDO record);

	List<SysPopedomDO> selectAllPopedoms();

	List<String> findAllModules();
}