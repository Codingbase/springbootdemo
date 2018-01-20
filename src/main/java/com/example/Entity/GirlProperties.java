package com.example.Entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 这个类获取配置文件里的一些配置字段信息
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String api;

    private Integer age;

    public String getApi() {
        return api;
    }

    public int getAge() {
        return age;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
