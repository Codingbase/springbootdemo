package com.example.Controller;

import com.example.Entity.Girl;
import com.example.Entity.Result;
import com.example.Interface.GirlRepository;
import com.example.service.GirlService;
import com.example.utlis.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shen on 2018/1/4.
 */
@CrossOrigin
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
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
     * 返回一个对象 Girl
     * 当一个对象属性特别多的时候,参数传一个对象,从对象里获取属性
     * @Valid 表单验证,后面有参数BindingResult bindingResult,然后做判断
     */

    @PostMapping(value ="/girls")
    @ResponseBody
    public Result girlAdd(@RequestBody  Girl girl, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

//        给函数传一个对象,从对象里获取属性
        girl.setApi(girl.getApi());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());
        Result result = new Result();
        return ResultUtil.success(girlRepository.save(girl));
    }

    //查询一个女生id findOne 方法 查询一个id使用PathVariable方法
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    // 更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("api") String api,
                           @RequestParam("age") Integer age,
                           @RequestParam("money") Double money) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setApi(api);
        girl.setId(id);
        girl.setMoney(money);
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

    // 插入两条数据 如果一条插入失败另一条也不插入
    @PostMapping(value ="/girls/two")
    public void girlTwo() {
        girlService.insetrTwo();
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
