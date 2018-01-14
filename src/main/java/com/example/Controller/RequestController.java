package com.example.Controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by shen on 2018/1/14.
 * spring提供的 resttemplate类
 */
public class RequestController {

    public <T> T restTemplate(String url, Map<String,T> params, Class<T> var, HttpMethod method) {
        RestTemplate restTemplate = new RestTemplate();
        FormHttpMessageConverter fc = new FormHttpMessageConverter();
        StringHttpMessageConverter s = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        List<HttpMessageConverter<?>> partConverters = new ArrayList<HttpMessageConverter<?>>();
        partConverters.add(s);
        partConverters.add(new ResourceHttpMessageConverter());
        fc.setPartConverters(partConverters);
        restTemplate.getMessageConverters().addAll(Arrays.asList(fc, new MappingJackson2HttpMessageConverter()));
        MultiValueMap<String, T> map = new LinkedMultiValueMap<>();
        map.setAll(params);
        switch (method) {
            case POST:
                return restTemplate.postForObject(url, map, var);
            case GET:
                String getParams = "?" + map.keySet().stream().map(k -> String.format("%s={%s}", k, k)).collect(Collectors.joining("&"));
                return restTemplate.getForObject(url + getParams, var, params);
            default:
                return restTemplate.postForObject(url, map, var);
        }
    }
}
