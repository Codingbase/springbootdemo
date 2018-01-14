package com.example.Controller;

import com.example.Entity.Girl;
import com.example.Interface.GirlRepository;
import com.example.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shen on 2018/1/4.
 */
@CrossOrigin
@RestController
public class GirlController {
//    autowired自动装配
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * POST请求传参数,RequestParam 添加参数的方法
     * 需要返回一个对象所以定义一个public Girl对象
     * 返回一个对象
     * 当一个对象属性特别多的时候,参数传一个对象,从对象里获取属性
     */
    @PostMapping(value ="/girls")
    public Girl girlAdd(Girl girl){
//        给函数传一个对象,从对象里获取属性
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlRepository.save(girl);
    }

    //查询一个女生id findOne 方法 查询一个id使用PathVariable方法
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    // 更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    //删除  PathVariable是路径上的参数 删除没有返回值,所以操作完使用void方法
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
         girlRepository.delete(id);
    }
    // 通过age年龄来查询,会返回一个list,所以这里使用List<Girl>
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }


    @PostMapping(value ="/girls/two")
    public void girlTwo() {
        girlService.insetrTwo();
    }
}
