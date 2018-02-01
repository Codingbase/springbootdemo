package com.example.dao;

import com.example.pojo.Test;
import com.example.pojo.TestExample;
import com.example.pojo.TestWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    long countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestWithBLOBs record);

    int insertSelective(TestWithBLOBs record);

    List<TestWithBLOBs> selectByExampleWithBLOBs(TestExample example);

    List<Test> selectByExample(TestExample example);

    TestWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestWithBLOBs record, @Param("example") TestExample example);

    int updateByExampleWithBLOBs(@Param("record") TestWithBLOBs record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);

    int updateByPrimaryKeySelective(TestWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TestWithBLOBs record);

    int updateByPrimaryKey(Test record);
}