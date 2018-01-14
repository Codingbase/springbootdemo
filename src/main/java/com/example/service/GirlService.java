package com.example.service;

import com.example.Entity.Girl;
import com.example.Interface.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by shen on 2018/1/7.
 * Service控制
 * @Transactional 事物控制,如果两天数据有一条失败.另一条也不插入
 */

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insetrTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("C");
        girlA.setAge(20);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("A");
        girlB.setAge(25);
        girlRepository.save(girlB);
    }
// 添加逻辑判断年龄并抛出异常
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new Exception("你还在上小学吧!");
        } else if (age > 10 && age < 16) {
            throw new Exception("你可能上初中");
        } else if (age > 16) {
            throw new Exception("你可能上大学了!");
        }
    }
}
