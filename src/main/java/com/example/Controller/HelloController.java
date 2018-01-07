package com.example.Controller;

import com.example.Entity.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


// 要通过web方式访问要添加RestController注释,RestController等同于@Controller+@ResponseBody
@RestController
@RequestMapping(value = "/base")
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//// 使用配置文件里的配置
//    @Value("${content}")
//    private String content;


    private final GirlProperties girlProperties;

    @Autowired
    public HelloController(GirlProperties girlProperties) {
        this.girlProperties = girlProperties;
    }
//  @pathVariable注解的使用,url后面要跟上参数值{}
    @RequestMapping(value = "/hi/{id}", method = RequestMethod.GET)
    public String Hi(@PathVariable("id") String str) {
        return "str:" + str;
    }
//  如果想配置多个url来访问这个页面,可以写成一个集合,@RequestMapping 可以给整个类设置一个url
    @RequestMapping(value ={"/hello","/say"}, method = RequestMethod.GET)
//    参数可以写在url的后面也可以写在前面,PathVariable的注解使用方法
//    required 是否必传,defaultValue默认值
    public String Say(@RequestParam(value="id",required=false,defaultValue = "0") Integer id) {
        return "id:" + id;
//        girlProperties.setAge(24);
//        girlProperties.setCupSize("F");
//        return girlProperties.getCupSize()+girlProperties.getAge();
//        return content;
    }

    //    @RequestMapping(value="/go",method = RequestMethod.GET)
//    使用GetMapping可以减少代码的编写,可以使用PostMapping,DelMapping,PutMapping等
    @GetMapping(value = "/go")
    public String Go(@RequestParam(value = "go", required = false, defaultValue = "xxx") String go) {
        System.out.println(go);
        String str = null;
        if (!Objects.equals(go, "")) {
            str = go + "hello";
        }
        return "well:"+str;
    }
}
