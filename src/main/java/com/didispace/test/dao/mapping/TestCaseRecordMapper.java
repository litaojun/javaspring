package com.didispace.test.dao.mapping;

import java.util.List;
import java.util.Map;

import com.didispace.test.dao.impl.TestCaseRecord;
//http://blog.csdn.net/winter_chen001/article/details/77249029
public interface TestCaseRecordMapper 
{
    int deleteByPrimaryKey(Integer id);

    int insert(TestCaseRecord record);

    int insertSelective(TestCaseRecord record);

    TestCaseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestCaseRecord record);

    int updateByPrimaryKey(TestCaseRecord record);
    
    List<Map<String, Object>> getTestPlanRstHashMap(Integer plan_id);
    List<TestCaseRecord> getTestCasesByPlanIdOrInterface(TestCaseRecord record);
}