package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Created by shen on 2018/1/6.
 * Entity实体类方法,生成数据库对应的表字段
 */

//通过这种方法就可以创建一个表的势力,然后进行GET/POST方法的使用
@Entity
public class Man {
    @Id
    @GeneratedValue
    private Integer Id;

    private String name;

    private String tag;

    public Man() {
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
