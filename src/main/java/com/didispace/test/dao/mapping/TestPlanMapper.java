package com.didispace.test.dao.mapping;

import java.util.ArrayList;

import com.didispace.test.dao.impl.TestPlan;
public interface TestPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestPlan record);

    int insertSelective(TestPlan record);

    TestPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestPlan record);

    int updateByPrimaryKey(TestPlan record);
    int selectMaxId();
    ArrayList<TestPlan> selectPlanListByProjectName(String projectname);
} 