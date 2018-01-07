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
}
