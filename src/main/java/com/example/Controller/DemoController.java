package com.example.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.aspct.HTTPAspect;
import com.example.pojo.TestWithBLOBs;
import com.example.service.DemoService;
import com.example.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/demo")
public class DemoController {
    private final static Logger logger = LoggerFactory.getLogger(HTTPAspect.class);
    @Autowired
    private DemoService demoService;
    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public String demo(@RequestParam("url") String url,@RequestParam("params") String params){

        logger.info("=======request param  url = {}",url);
        logger.info("param={}",params);
        String result = demoService.test(url,params);
        logger.info("result = {}",result);
        return  result;
    }

    @RequestMapping("gettest")
    public String demo1(@RequestParam("url") String url) {
        String result = demoService.gettest(url, null);
        return result;
    }

    @RequestMapping("test1")
    public String demo2(@RequestParam(required = false) Integer id,
                        @RequestParam(required = false) String name){
        String result = testService.findTestById(id,name);
        return result;
    }

    @RequestMapping("test2")
    public String demo3(@RequestBody TestWithBLOBs testWithBLOBs){
        testService.save(testWithBLOBs);
        JSONObject json = new JSONObject();
        json.put("status:", 200);
        return json.toJSONString();
    }
}
