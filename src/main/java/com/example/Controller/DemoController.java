package com.example.Controller;

import com.example.aspct.HTTPAspect;
import com.example.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final static Logger logger = LoggerFactory.getLogger(HTTPAspect.class);
    @Autowired
    private DemoService demoService;
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
}
