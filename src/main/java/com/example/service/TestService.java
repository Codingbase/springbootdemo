package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.dao.TestMapper;
import com.example.pojo.TestExample;
import com.example.pojo.TestWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper mapper;

    public String findTestById(Integer id,String name){
        JSONObject jsonObject = new JSONObject();
//        if(null==id){
        TestExample example = new TestExample();
        TestExample.Criteria criteria = example.createCriteria();
        if(null!=id) criteria.andIdEqualTo(id);
        if(!StringUtils.isEmpty(name)) criteria.andNameEqualTo(name);
        List<TestWithBLOBs> list = mapper.selectByExampleWithBLOBs(example);
        jsonObject.put("status",200);
        jsonObject.put("data", list);
        return jsonObject.toJSONString();
//        }

//        TestWithBLOBs testWithBLOBs = mapper.selectByPrimaryKey(id);
//
//        jsonObject.put("status",200);
//        jsonObject.put("data",testWithBLOBs);
//        return jsonObject.toJSONString();
    }

    public void save (TestWithBLOBs testWithBLOBs){
        mapper.insert(testWithBLOBs);
    }
}
