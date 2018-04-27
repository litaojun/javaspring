package com.didispace.test.dao.mapping;

import com.didispace.test.dao.impl.TestRunConfig;

public interface TestRunConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestRunConfig record);

    int insertSelective(TestRunConfig record);

    TestRunConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestRunConfig record);

    int updateByPrimaryKey(TestRunConfig record);
    
    TestRunConfig selectByProName(String projectname);
}