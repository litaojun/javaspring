package com.didispace.dao.mapper;

import com.didispace.dao.impl.TestCaseRecord;

public interface TestCaseRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestCaseRecord record);

    int insertSelective(TestCaseRecord record);

    TestCaseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestCaseRecord record);

    int updateByPrimaryKey(TestCaseRecord record);
}