package com.didispace.test.dao.mapping;

import com.didispace.test.dao.impl.TestRunProcess;

public interface TestRunProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestRunProcess record);

    int insertSelective(TestRunProcess record);

    TestRunProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestRunProcess record);

    int updateByPrimaryKey(TestRunProcess record);
    
    TestRunProcess selectByPronameAndStarttime(TestRunProcess testRunProcess);
}