package com.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.aspct.HTTPAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by shen on 2018/1/14.
 */
@Service
public class DemoService {
    private final static Logger logger = LoggerFactory.getLogger(HTTPAspect.class);

    @Autowired
    private RestTemplate restTemplate;

    public String test(String url,String param){
        JSONObject jsonObject = JSON.parseObject(param);
        logger.info("请求参数 = {}",jsonObject);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toJSONString(),headers);
        String result = restTemplate.postForObject(url, entity, String.class);
        logger.info(result);
        return result;
    }




    public String gettest(String url, Map<String,Object> param){
        logger.info("url:" + url);
        logger.info("----------");
        String result = restTemplate.getForEntity(url, String.class).getBody();
        logger.info("result:" + result);
        return result;
    }
}
